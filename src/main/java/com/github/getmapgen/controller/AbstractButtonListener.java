/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Ivan Maslov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
