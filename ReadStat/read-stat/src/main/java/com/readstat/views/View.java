package com.readstat.views;

import javax.swing.JPanel;

/*
 * Author:        Linnea Jones
 * Class:         CSCI 4448
 * Purpose:       Defines the general form for view objects
 * Revision Date: 7/13/2025
 */

public abstract class View extends JPanel {
    protected String view_name;
    public String getViewName() { return view_name; }
}
