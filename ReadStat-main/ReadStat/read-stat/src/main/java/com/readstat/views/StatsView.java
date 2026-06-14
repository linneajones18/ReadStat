package com.readstat.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/*
 * Author:        Linnea Jones
 * Class:         CSCI 4448
 * Purpose:       Defines what the user sees when the statistics page is open
 * Revision Date: 7/23/2025
 */

public class StatsView extends View {
    private JButton logout_button;
    private JButton go_to_track_button;
    private JPanel chartPanels;

    public StatsView() {
        view_name = "Stats";

        logout_button = new JButton("Logout");
        go_to_track_button = new JButton("Track More Books");
        chartPanels = new JPanel();
        chartPanels.setLayout(new BoxLayout(chartPanels, BoxLayout.Y_AXIS));
        chartPanels.setPreferredSize(new Dimension(450, 1000));


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel title_row = new JPanel(new FlowLayout(FlowLayout.CENTER));
        title_row.add(new JLabel("Reading Statistics"));

        JPanel go_track_row = new JPanel(new FlowLayout(FlowLayout.CENTER));
        go_track_row.add(go_to_track_button);

        JPanel logout_row = new JPanel(new FlowLayout(FlowLayout.CENTER));
        logout_row.add(logout_button);

        panel.add(title_row);
        panel.add(go_track_row);
        panel.add(logout_row);
        panel.add(chartPanels);

        // chatgpt and copilot both provided pieces of this block of code for making the scroll bar function properly
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.add(panel, BorderLayout.CENTER);
        JScrollPane scrollPane = new JScrollPane(wrapper);
        scrollPane.setPreferredSize(new Dimension(480, 550));
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane);
    }

    public void setLogoutListener(ActionListener listener) { logout_button.addActionListener(listener); }
    public void setGoToTrackingListener(ActionListener listener) { go_to_track_button.addActionListener(listener); }
    public void clearCharts() { chartPanels.removeAll(); }

    // register a chart to show up on the chartpanel
    public void addCharts(JFreeChart chart) { 
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 300));
        chartPanels.add(Box.createVerticalStrut(20));
        chartPanels.add(chartPanel);
        chartPanels.revalidate();
        chartPanels.repaint();
    }
}
