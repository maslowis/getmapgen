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

import com.github.getmapgen.view.Form;
import com.github.getmapgen.view.InputValues;
import org.apache.log4j.Logger;

/**
 * Simple delegate for {@link com.github.getmapgen.view.Form}. Provides access for progress bar, status field, visibility of form and get input values.
 *
 * @author maslowis
 */
public class FormDelegate {
    private static final Logger log = Logger.getLogger(FormDelegate.class);
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
        log.info(msg);
    }

    public InputValues getInput() {
        return gui.getInput();
    }

    void setVisibleForm(boolean b) {
        gui.setVisible(b);
    }
}
