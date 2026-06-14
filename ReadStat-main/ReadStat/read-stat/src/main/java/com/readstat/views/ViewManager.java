package com.readstat.views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/*
 * Author:        Linnea Jones
 * Class:         CSCI 4448
 * Purpose:       Defines the main traits of the app frame and opens and closes views as called
 * Revision Date: 7/22/2025
 */

//  SINGLETON PATTERN
public class ViewManager extends JFrame {
    private static final ViewManager instance = new ViewManager();
    private JPanel cardPanel;
    private CardLayout cardLayout;

    private JLabel message;
    private JPanel messagePanel;
    private Timer message_timer;

    // chatgpt helped with formatting the base page
    private ViewManager() {
        message = new JLabel("");
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        message.setHorizontalAlignment(SwingConstants.CENTER);
        message.setForeground(Color.BLACK);
        message.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        messagePanel = new JPanel(new BorderLayout());
        messagePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        messagePanel.add(message, BorderLayout.CENTER);
        messagePanel.setVisible(false);

        JPanel root = new JPanel(new BorderLayout());
        root.add(messagePanel, BorderLayout.NORTH);
        root.add(cardPanel, BorderLayout.CENTER);

        setContentPane(root);
        setTitle("ReadStat");
        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static ViewManager getInstance() { return instance; }

    public void registerView(View view, String view_name) {
        cardPanel.add(view, view_name);  
    }

    public void showView(String view_name) {
        cardLayout.show(cardPanel, view_name);
        setTitle("ReadStat - " + view_name);    
        setVisible(true);
    }

    // pieces of this function related to timer implementation came from chatgpt
    public void showMessage(String message_text, boolean status) {

        if (message_timer != null && message_timer.isRunning()) {
            message_timer.stop();
        }

        message.setForeground(status ? Color.GREEN : Color.RED);
        messagePanel.setBorder(BorderFactory.createLineBorder(status ? new Color(85, 255, 85) : new Color(255, 85, 85)));
        message.setText(message_text);
        messagePanel.setVisible(true);

        message_timer = new Timer(2000, e -> {
            message.setText("");
            messagePanel.setVisible(false);
        });
        message_timer.setRepeats(false);
        message_timer.start();
    }
}
