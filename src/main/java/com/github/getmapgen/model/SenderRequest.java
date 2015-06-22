package com.github.getmapgen.model;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * Object is responsible for sending getmap request
 *
 * @author maslowis
 */
public class SenderRequest {
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
    public String send(String url) {
        HttpGet request = new HttpGet(url);
        try {
            CloseableHttpResponse response = client.execute(request);
            String msg = "REQUEST " + request.getURI() + " IS SEND\n" + "RESPONSE: " + response.getStatusLine().toString() + "\n";
            response.close();
            return msg;
        } catch (Exception e) {
            e.printStackTrace();
            return ("REQUEST " + request.getURI() + " FAILED\n");
        }
    }
}
