
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class CoronaWarnTerm extends JFrame implements CoronaWarnClient {
    private final JPhone phone;
    private List<Token> tokens = new LinkedList<>();
    private List<Token> seenTokens = new LinkedList<>();
    private WarnStatus currentStatus = WarnStatus.UNKNOWN;
    private JLabel lblInfectionStatus = new JLabel("", JLabel.CENTER);
    private JLabel lblCountSeenTokens = new JLabel("", JLabel.CENTER);
    private List<JComponent> toDisableOnInfection = new LinkedList<>();

    public CoronaWarnTerm(JPhone phone) {
        super(phone.getOwner());
        this.phone = phone;
        this.tokens = CoronaWarn.loadTokens(phone);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.initUI();
        this.newToken();
        this.updateInfectionLabel();
        this.updateCountLabel();
        this.startTokenRefresh();
        this.pack();
        this.setVisible(true);
    }

    private void initUI() {
        this.setLayout(new BorderLayout(5, 5));

        this.lblInfectionStatus.setOpaque(true);
        this.lblInfectionStatus.setPreferredSize(new Dimension(0, 100));
        this.add(this.lblInfectionStatus, BorderLayout.NORTH);
        this.add(this.lblCountSeenTokens, BorderLayout.SOUTH);

        JPanel pan = new JPanel(new GridLayout(0, 1, 5, 5));

        JButton btnRefreshTokens = new JButton("New Token");
        btnRefreshTokens.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CoronaWarnTerm.this.newToken();
            }
        });
        pan.add(btnRefreshTokens);
        this.toDisableOnInfection.add(btnRefreshTokens);

        JButton btnCheckForInfections = new JButton("Check for infections");
        btnCheckForInfections.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CoronaWarnTerm.this.checkForInfections();
            }
        });
        pan.add(btnCheckForInfections);
        this.toDisableOnInfection.add(btnCheckForInfections);

        JButton btnClear = new JButton("Clear tokens");
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CoronaWarnTerm.this.clear();
            }
        });
        pan.add(btnClear);
        this.toDisableOnInfection.add(btnClear);

        JButton btnReportInfection = new JButton("Report infection");
        btnReportInfection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CoronaWarnAPI.reportInfection(CoronaWarnTerm.this);
                CoronaWarnTerm.this.currentStatus = WarnStatus.INFECTED;
                CoronaWarnTerm.this.updateInfectionLabel();
                for (JComponent c : CoronaWarnTerm.this.toDisableOnInfection) {
                    c.setEnabled(false);
                }
            }
        });
        pan.add(btnReportInfection);
        this.toDisableOnInfection.add(btnReportInfection);

        this.add(pan);
    }

    private void clear() {
        this.seenTokens.clear();
        this.tokens.clear();
        CoronaWarn.clearTokenStore(this.phone);
        this.newToken();
        this.updateCountLabel();
        this.currentStatus = WarnStatus.UNKNOWN;
        this.updateInfectionLabel();
    }

    private void checkForInfections() {
        this.currentStatus = CoronaWarnAPI.checkInfection(this)
                ? WarnStatus.ALARM : WarnStatus.OK;
        this.updateInfectionLabel();
    }

    @Override
    public void tokenReceived(Token token) {
        this.seenTokens.add(token);
        this.updateCountLabel();
    }

    @Override
    public Token getCurrentToken() {
        return this.tokens.get(this.tokens.size() - 1);
    }

    private void updateInfectionLabel() {
        this.lblInfectionStatus.setText(this.currentStatus.getLabel());
        this.lblInfectionStatus.setBackground(this.currentStatus.getColor());
    }

    private void updateCountLabel() {
        this.lblCountSeenTokens
                .setText("Seen Tokens: " + this.seenTokens.size());
    }

    private void newToken() {
        Token token = new Token();
        this.tokens.add(token);
        CoronaWarn.saveToken(this.phone, token);
        CoronaWarnAPI.sendToken(this);
        this.lblCountSeenTokens.setToolTipText(token.toString());
    }

    private void startTokenRefresh() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                while (CoronaWarnTerm.this.currentStatus != WarnStatus.INFECTED) {
                    try {
                        Thread.sleep(150001);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    CoronaWarnTerm.this.newToken();
                }
            }
        };
        new Thread(r, "TokenRefresh").start();
    }

    @Override
    public List<Token> getAllTokens() {
        return this.tokens;
    }

    @Override
    public List<Token> getAllSeenTokens() {
        return this.seenTokens;
    }
}
