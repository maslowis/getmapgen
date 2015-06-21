package com.github.getmapgen.controller;

import com.github.getmapgen.model.GeneratorRequests;

import java.awt.event.ActionEvent;

/**
 * Controller for run button
 *
 * @author maslowis
 */
public class RunButtonListener extends AbstractButtonListener {

    public RunButtonListener(FormDelegate delegate) {
        super(delegate);
    }

    /**
     * Create and run the generator getmap requests in a separate thread
     *
     * @param event event indicating that the run button was pressed
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if (!isRunThread()) {
            setWorkThread(new Thread(new GeneratorRequests(getDelegate()), "getmapgen"));
            getWorkThread().start();
        }
    }
}
