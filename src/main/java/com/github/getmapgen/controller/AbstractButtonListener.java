package com.github.getmapgen.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Abstract controller for button. It contains a link to thread in which runs generator getmap requests.
 *
 * @author maslowis
 */
public abstract class AbstractButtonListener implements ActionListener {
    //   thread in which runs generator getmap requests
    private static Thread workThread;
    private FormDelegate delegate;

    protected AbstractButtonListener(FormDelegate delegate) {
        this.delegate = delegate;
    }

    protected Thread getWorkThread() {
        return AbstractButtonListener.workThread;
    }

    protected void setWorkThread(Thread workThread) {
        AbstractButtonListener.workThread = workThread;
    }

    protected FormDelegate getDelegate() {
        return delegate;
    }

    protected boolean isRunThread() {
        return AbstractButtonListener.workThread != null && AbstractButtonListener.workThread.isAlive();
    }

    @Override
    public abstract void actionPerformed(ActionEvent event);
}
