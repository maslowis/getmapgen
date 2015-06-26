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

import org.apache.log4j.Logger;

import java.awt.event.ActionEvent;

/**
 * Controller for exit button
 *
 * @author maslowis
 */
public class ExitButtonListener extends AbstractButtonListener {
    private static final Logger log = Logger.getLogger(ExitButtonListener.class);

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
                log.error(e);
            }
        }
        getDelegate().setVisibleForm(false);
        System.exit(0);
    }


}
