
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ConnectionTerm extends JFrame {
    private List<Stop> stops;
    private List<StopComponent> stopComponents;
    private Thread run;

    public ConnectionTerm(TrainConnection c) {
        System.out.println(c.getStops());
        setTitle(c.getName());
        setSize(400, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        stops = c.getStops();
        JPanel firstPanel = new JPanel(new GridLayout(stops.size(), 1));
        int currentDelay = 0;
        stopComponents = new ArrayList<>();
        for (Stop s : stops) {
            StopComponent stopComponent = new StopComponent(s);

            int randomNumber = (int) (Math.random() * 15) - 5;
            currentDelay += randomNumber;
            stopComponent.setDelay(currentDelay);
            if (currentDelay > 10) {
                int reasonIndex = (int) (Math.random() * StopComponent.DELAY_REASONS.length);
                stopComponent.setReason(stopComponent.DELAY_REASONS[reasonIndex]);
            }
            stopComponents.add(stopComponent);
            firstPanel.add(stopComponent);
        }

        add(firstPanel, BorderLayout.CENTER);
        setVisible(true);
        simulation();
    }

    public void simulation() {
        run = new Thread(() -> {
            try {
                for (int i = 0; i < stops.size(); i++) {
                    int delayTime = (int) (Math.random() * 4000) + 2000;
                    stopComponents.get(i).setStopReached(true);
                    Thread.sleep(delayTime);
                }
            } catch (InterruptedException e) {
            }
        });
        // starten
        run.start();
        // wieder beenden:
        // if (run != null) {
        // run.interrupt();
        // }

    }
}
