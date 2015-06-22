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