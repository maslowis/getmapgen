package com.github.getmapgen.controller;

import java.awt.event.ActionEvent;

/**
 * Controller for stop button
 *
 * @author maslowis
 */
public class StopButtonListener extends AbstractButtonListener {

    public StopButtonListener(FormDelegate delegate) {
        super(delegate);
    }

    /**
     * Should interrupt a thread in which runs the generator getmap requests
     *
     * @param event event indicating that the stop button was pressed
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if (isRunThread())
            getWorkThread().interrupt();
    }
}
