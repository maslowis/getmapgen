package com.github.getmapgen.controller;

import com.github.getmapgen.view.Form;
import com.github.getmapgen.view.InputValues;

/**
 * Simple delegate for {@link com.github.getmapgen.view.Form}. Provides access for progress bar, status field, visibility of form and get input values.
 *
 * @author maslowis
 */
public class FormDelegate {
    private Form gui;

    public FormDelegate(Form gui) {
        this.gui = gui;
    }

    public void incrementProgressBar(int increment) {
        gui.incrementProgressBar(increment);
    }

    public void initializeProgressBar(int min, int max) {
        gui.initializeProgressBar(min, max);
    }

    public void displayStatus(String msg) {
        gui.displayStatus(msg);
    }

    public InputValues getInput() {
        return gui.getInput();
    }

    void setVisibleForm(boolean b) {
        gui.setVisible(b);
    }
}
