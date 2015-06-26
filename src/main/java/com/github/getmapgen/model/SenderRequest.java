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
