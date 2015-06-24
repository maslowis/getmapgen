package com.github.getmapgen.model;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class SenderRequestTest {
    @Mock
    private CloseableHttpClient client;
    @InjectMocks
    private SenderRequest sender;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSend() throws Exception {
        sender.send(anyString());
        verify(client, times(1)).execute(any(HttpGet.class));
    }
}