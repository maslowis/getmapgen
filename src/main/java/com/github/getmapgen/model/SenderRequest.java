package com.github.getmapgen.model;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.log4j.Logger;

/**
 * Object is responsible for sending getmap request
 *
 * @author maslowis
 */
public class SenderRequest {
    private static final Logger log = Logger.getLogger(SenderRequest.class);
    private CloseableHttpClient client;

    public SenderRequest(CloseableHttpClient client) {
        this.client = client;
    }

    /**
     * Send getmap request
     *
     * @param url string representation of URL
     * @return message about successful \ unsuccessful request
     */
    public String send(final String url) {
        HttpGet request = null;
        CloseableHttpResponse response = null;
        String msg = null;
        try {
            request = new HttpGet(url);
            response = client.execute(request);
            msg = String.format("REQUEST %1s IS SEND. RESPONSE: %2s.", url, response.getStatusLine().toString());
            response.close();
        } catch (Exception e) {
            msg = String.format("REQUEST %1s FAILED", url);
            log.error(msg, e);
        }
        return msg;
    }
}
