import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ChoronaTerminal {

    private CellButton[][] cellButtons;
    private Room room;
    private JLabel stepLbl;
    private JButton stepBtn;
    private JButton playBtn;
    private JButton saveBtn;
    private Variant variant;
    private JFrame frame;

    public ChoronaTerminal(Variant variant, Room room) {
        this.room = room;
        this.cellButtons = new
                CellButton[room.getSetting().getHeight()][room.getSetting().getWidth()];
        this.variant = variant;
        this.displayTerminal();
    }

    void displayTerminal() {
        this.frame = new JFrame( "Chorona - " + this.variant.getLabel() + " (" +
                this.variant.getDesignation() + ")" );
        JPanel cellPanel = new JPanel();
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout( new GridLayout( 1, 3, 10, 10 ) );
        cellPanel.setLayout( new GridLayout( this.room.getSetting().getHeight(),
                this.room.getSetting().getWidth() ) );
        this.stepLbl = new JLabel( "Steps: 0", SwingConstants.CENTER );
        this.stepBtn = new JButton("Step");
        this.playBtn = new JButton("Play");
        this.saveBtn = new JButton( "Save" );
        for ( int y = 0; y < this.cellButtons.length; y++ ) {
            for ( int x = 0; x < this.cellButtons[y].length; x++ ) {
                cellPanel.add( this.cellButtons[y][x] = new CellButton() );
            }
        }
        for ( Point p : this.room.getSetting().getPolluters() ) {
            this.cellButtons[p.getY()][p.getX()].setPolluter( true );
        }
        this.stepBtn.addActionListener(e -> this.performStep());
        this.playBtn.addActionListener( e -> this.animate() );
        this.saveBtn.addActionListener( e -> this.save() );
        menuPanel.add(this.stepBtn);
        menuPanel.add(this.playBtn);
        menuPanel.add( this.saveBtn );
        this.frame.add( this.stepLbl, BorderLayout.NORTH );
        this.frame.add(menuPanel, BorderLayout.SOUTH);
        this.frame.add(cellPanel, BorderLayout.CENTER);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(700, 720);
        this.updateUI();
        this.frame.setVisible(true);
    }

    private void performStep() {
        this.room.step();
        this.updateUI();
    }

    private void updateUI() {
        this.stepLbl.setText( "Steps: " + this.room.getSteps() );
        for ( int y = 0; y < this.room.getSetting().getHeight(); y++ ) {
            for ( int x = 0; x < this.room.getSetting().getWidth(); x++ ) {
                this.cellButtons[y][x].setDose( this.room.getDose( x, y ) );
            }
        }
    }

    public void animate() {
        new Thread( () -> {
            this.stepBtn.setEnabled(false);
            this.playBtn.setEnabled(false);
            for(int i=0; i<20; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) { }
                this.performStep();
            }
            this.stepBtn.setEnabled(true);
            this.playBtn.setEnabled(true);
        } ).start();
    }

    private void save() {
        String fn = String.format( "%s-%s-%s-%s-%s.txt", this.variant.name(),
                this.room.getSetting().getWidth(), this.room.getSetting().getHeight(),
                this.room.getSetting().getPolluters().size(), this.room.getSteps() );
        try ( BufferedWriter bw = new BufferedWriter( new FileWriter( fn, false ) ) ) {
            for ( int y = 0; y < this.room.getSetting().getHeight(); y++ ) {
                for ( int x = 0; x < this.room.getSetting().getWidth(); x++ ) {
                    bw.write( String.format( "%s,%s,%s", x, y, this.room.getDose( x, y ) ) );
                    bw.newLine();
                }
            }
            JOptionPane.showMessageDialog( this.frame, fn + " saved successfully." );
        } catch ( Exception e ) {
            e.printStackTrace();
            JOptionPane.showMessageDialog( this.frame, fn + " not saved successfully.",
                    "Error", JOptionPane.ERROR_MESSAGE );
        }
    }
}
