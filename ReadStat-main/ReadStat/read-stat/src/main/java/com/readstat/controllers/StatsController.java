package com.readstat.controllers;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.readstat.DAOs.UserDAO;
import com.readstat.commands.LogoutCommand;
import com.readstat.records.*;
import com.readstat.views.StatsView;
import com.readstat.views.ViewManager;

/*
 * Author:        Linnea Jones
 * Class:         CSCI 4448
 * Purpose:       Defines the operation logic for what to do when the user interacts with the statistics page
 * Revision Date: 7/23/2025
 */

// OBSERVER PATTERN
public class StatsController {
    private StatsView view;

    public StatsController() {
        view = new StatsView();
        updateCharts();
        ViewManager.getInstance().registerView(view, view.getViewName());

        view.setLogoutListener(e -> handleLogout());
        view.setGoToTrackingListener(e -> handleGoToTracking());

        // chatgpt suggested this to ensure the view reloads the charts
        view.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                updateCharts();
            }
        });
    }

    public void handleLogout() {
        LogoutCommand.execute();
        ViewManager.getInstance().showView("Login");
        ViewManager.getInstance().showMessage("Logged out.", true);
    }

    public void handleGoToTracking() {
        ViewManager.getInstance().showView("Track Books");
    }

    // creates a pie chart representing the page ranges of the user's read books
    private JFreeChart getPagesChart() {
        UserDAO userDAO = new UserDAO();

        // code for creating a pie chart came from:
        // https://www.tutorialspoint.com/jfreechart/jfreechart_pie_chart.htm

        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        dataset.setValue("1-149 pages", userDAO.getReadCountByPageNumber(1, 149));
        dataset.setValue("150-299 pages", userDAO.getReadCountByPageNumber(150, 299) );
        dataset.setValue("300-499 pages", userDAO.getReadCountByPageNumber(300, 499) );
        dataset.setValue("500+ pages", userDAO.getReadCountByPageNumber(500, Integer.MAX_VALUE) );

        return ChartFactory.createPieChart("Books by Page Number", dataset);
    }

    // creates a bar chart displaying the user's top 5 most read authors
    private JFreeChart getAuthorChart() {
        UserDAO userDAO = new UserDAO();

        // code for creating a bar chart came from:
        // https://stackoverflow.com/questions/23665260/bar-chart-with-exact-value-printed-on-top-of-each-bar

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<AuthorRecord> top_authors = userDAO.getTopAuthors();
        for (AuthorRecord authorRecord : top_authors) {
            dataset.setValue(authorRecord.count(), "test", authorRecord.author());
        }

        return ChartFactory.createBarChart("Most Read Authors", "Author", "", dataset, PlotOrientation.VERTICAL, false, false, false);
    }

    // creates a pie chart representing the genres the user has read
    private JFreeChart getGenreChart() {
        UserDAO userDAO = new UserDAO();
        ArrayList<GenreRecord> genres = userDAO.getCommonGenres();

        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        for (GenreRecord genreRecord : genres) {
            dataset.setValue(genreRecord.name(), genreRecord.count());
        }

        return ChartFactory.createPieChart("Books Read by Genre", dataset);
    }

    public void updateCharts() {
        view.clearCharts();
        view.addCharts(getPagesChart());
        view.addCharts(getAuthorChart());
        view.addCharts(getGenreChart());
    }
}
