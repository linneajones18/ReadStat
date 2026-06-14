package com.readstat.views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ComponentAdapter;

import javax.swing.*;

import com.readstat.DAOs.*;
import com.readstat.records.Book;

/*
 * Author:        Linnea Jones
 * Class:         CSCI 4448
 * Purpose:       Defines what the user sees when the book tracking page is open
 * Revision Date: 7/23/2025
 */

public class TrackBooksView extends View{

    private ArrayList<JButton> track_buttons;
    private ArrayList<Book> visible_books;
    private JButton go_to_stats_button;
    private JComboBox<String> select_genres;
    private BookDAO bookDAO;
    private JPanel button_panel;

    public TrackBooksView() {
        view_name = "Track Books";
        bookDAO = new BookDAO();
        GenreDAO genreDAO = new GenreDAO();

        // fill genre search options
        ArrayList<String> genres = new ArrayList<>(Arrays.asList("Select by genre"));
        genres.addAll(genreDAO.getAllGenres());
        select_genres = new JComboBox<>(genres.toArray(new String[0]));
        
        go_to_stats_button = new JButton("Go to Statistics");
        visible_books = bookDAO.getAllBooks();

        // set to blank buttons
        button_panel = new JPanel();
        button_panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        button_panel.setLayout(new BoxLayout(button_panel, BoxLayout.Y_AXIS));


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setBorder(BorderFactory.createEmptyBorder(40, 30, 40, 40));

        JPanel go_stats_row = new JPanel(new FlowLayout(FlowLayout.LEFT));
        go_stats_row.add(go_to_stats_button);

        JPanel search_row = new JPanel(new FlowLayout(FlowLayout.LEFT));
        search_row.add(select_genres);

        panel.add(go_stats_row);
        panel.add(Box.createVerticalStrut(10));
        panel.add(search_row);
        refresh();
        panel.add(button_panel);

        // code for enabling scrolling came from chatgpt
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.add(panel, BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(wrapper);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        setLayout(new BorderLayout());

        add(scrollPane);

        // this override came from chatgpt and ensures that the buttons refresh every time the page opens
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                refresh();
            }
        });
    }

    public void setTrackListener(ActionListener listener, int index)    { track_buttons.get(index).addActionListener(listener); }
    public void setGoToStatsListener(ActionListener listener)           { go_to_stats_button.addActionListener(listener); }
    public void setGenreSearchListener(ActionListener listener)         { select_genres.addActionListener(listener); }
    public ArrayList<Book> getVisibleBooks()                            { return visible_books; }
    public String getSelectedGenre()                                    { return (String) select_genres.getSelectedItem(); }


    public void setVisibleBooks(ArrayList<Book> books) { 
        visible_books = books;
        refresh();
    }

    // recreates all tracking buttons so they match the read/unread options
    public void refresh() {
        UserDAO userDAO = new UserDAO();
        track_buttons = new ArrayList<>();

        for(int i = 0; i < visible_books.size(); i++) {
            if(userDAO.userHasReadBook(visible_books.get(i).ID())) { // the user has read the book, so the button option should be to untrack
                track_buttons.add(new JButton("Untrack"));
                track_buttons.get(i).setPreferredSize(new Dimension(85, 30));
            }
            else {
                track_buttons.add(new JButton("Track"));
                track_buttons.get(i).setPreferredSize(new Dimension(85, 30));
            }
        }

        // remove all track buttons
        button_panel.removeAll();

        // create all new track buttons
        for(int i = 0; i < visible_books.size(); i++) {
            JPanel book_row = new JPanel(new BorderLayout());
            book_row.setMaximumSize(new Dimension(350, 40)); // chatgpt suggested this line for fixing button size variation when the # of books are filtered
            book_row.setAlignmentX(Component.LEFT_ALIGNMENT);

            book_row.add(new JLabel(visible_books.get(i).title() + " - " + visible_books.get(i).author() + " - " + visible_books.get(i).pages() + " pages"), BorderLayout.WEST);
            book_row.add(Box.createRigidArea(new Dimension(10, 0)));
            book_row.add(track_buttons.get(i), BorderLayout.EAST);
            
            button_panel.add(book_row);
            button_panel.add(Box.createVerticalStrut(10));
        }

        button_panel.repaint();
        button_panel.revalidate();
    }


    // switches buttons between tracking and untracking
    public void switchButtonMode(int index) {
        if(track_buttons.get(index).getText() == "Untrack" ){
            track_buttons.get(index).setText("Track");
        }
        else {
            track_buttons.get(index).setText("Untrack");
        }
    }
}
