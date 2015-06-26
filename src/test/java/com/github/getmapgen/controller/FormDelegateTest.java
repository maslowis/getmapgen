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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class FormDelegateTest {
    @Mock
    private Form form;
    @InjectMocks
    private FormDelegate delegate;


    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testIncrementProgressBar() {
        delegate.incrementProgressBar(anyInt());
        verify(form, times(1)).incrementProgressBar(anyInt());
    }

    @Test
    public void testInitializeProgressBar() throws Exception {
        delegate.initializeProgressBar(anyInt(), anyInt());
        verify(form, times(1)).initializeProgressBar(anyInt(), anyInt());
    }

    @Test
    public void testDisplayStatus() throws Exception {
        delegate.displayStatus(anyString());
        verify(form, times(1)).displayStatus(anyString());
    }

    @Test
    public void testGetInput() throws Exception {
        delegate.getInput();
        verify(form, times(1)).getInput();
    }

    @Test
    public void testSetVisibleForm() throws Exception {
        delegate.setVisibleForm(anyBoolean());
        verify(form, times(1)).setVisible(anyBoolean());
    }
}