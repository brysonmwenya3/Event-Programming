package BugFixChallenge;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class Bug3_WrongThread extends JFrame {
    private final JLabel timeLabel;
    private final JButton startButton;
    private boolean running = false;
    private final Timer clockTimer;

    public Bug3_WrongThread() {
        setTitle("Bug 3 - Wrong Thread");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        timeLabel = new JLabel("Time: ");
        timeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        startButton = new JButton("Start Clock");
        clockTimer = new Timer(1000, e -> {
            if (running) {
                timeLabel.setText("Time: " + new Date());
            }
        });

        startButton.addActionListener(e -> {
            running = true;
            startButton.setEnabled(false);
            if (!clockTimer.isRunning()) {
                clockTimer.start();
            }
        });

        add(timeLabel);
        add(startButton);
        setSize(350, 150);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bug3_WrongThread().setVisible(true));
    }
}