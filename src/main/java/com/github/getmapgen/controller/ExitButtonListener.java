package com.github.getmapgen.controller;

import java.awt.event.ActionEvent;

/**
 * Controller for exit button
 *
 * @author maslowis
 */
public class ExitButtonListener extends AbstractButtonListener {

    public ExitButtonListener(FormDelegate delegate) {
        super(delegate);
    }

    /**
     * Interrupt a thread in which runs generator getmap requests and quits this app
     *
     * @param event event indicating that the exit button was pressed
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if (isRunThread()) {
            getWorkThread().interrupt();
            try {
                getWorkThread().join(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        getDelegate().setVisibleForm(false);
        System.exit(0);
    }


}
