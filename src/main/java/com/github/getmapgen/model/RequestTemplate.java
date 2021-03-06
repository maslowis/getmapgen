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

import com.github.getmapgen.Util;
import com.github.getmapgen.view.InputValues;

/**
 * Object storing template of getmap request as a string
 *
 * @author maslowis
 */
public class RequestTemplate {
    private String service;
    private String version;
    private String request;
    private String styles;
    private String width;
    private String height;
    private String format;
    private String layers;
    private String srs;
    private String host;
    private String pattern;
    private String template;

    public RequestTemplate(InputValues input) {
        this.service = "WMS";
        this.version = "1.1.1";
        this.request = "GetMap";
        this.styles = "";
        this.format = "image%2Fpng";
        this.width = String.valueOf(GeneratorRequests.TILE_SIZE);
        this.height = String.valueOf(GeneratorRequests.TILE_SIZE);
        this.layers = buildLayers(input.getStorage(), input.getLayers());
        this.srs = buildSrs(input.getCoordinateSystem());
        this.host = input.getHost();
        this.pattern = input.getPatternRequest();
        this.template = buildPattern();
    }

    private String buildLayers(String storage, String layers) {
        StringBuilder layersBuilder = new StringBuilder();
        String[] layersArr = Util.splitString(layers);
        for (int i = 0; i < layersArr.length; ++i) {
            if (i == 0) {
                layersBuilder.append(storage);
                layersBuilder.append("%3ACATALOG_");
                layersBuilder.append(layersArr[i]);
            } else {
                layersBuilder.append("%2C");
                layersBuilder.append(storage);
                layersBuilder.append("%3ACATALOG_");
                layersBuilder.append(layersArr[i]);
            }
        }
        return layersBuilder.toString();
    }

    private String buildSrs(String arg) {
        return "EPSG%3A".concat(arg);
    }

    private String buildPattern() {
        StringBuilder pattern = new StringBuilder()
                .append(this.host)
                .append(this.pattern);
        return pattern
                .insert(offset(pattern, "FORMAT="), this.format)
                .insert(offset(pattern, "LAYERS="), this.layers)
                .insert(offset(pattern, "SERVICE="), this.service)
                .insert(offset(pattern, "VERSION="), this.version)
                .insert(offset(pattern, "REQUEST="), this.request)
                .insert(offset(pattern, "STYLES="), this.styles)
                .insert(offset(pattern, "SRS="), this.srs)
                .insert(offset(pattern, "WIDTH="), this.width)
                .insert(offset(pattern, "HEIGHT="), this.height)
                .toString();
    }

    private int offset(StringBuilder builder, String keyword) {
        return builder.indexOf(keyword) + keyword.length();
    }

    /**
     * Create specific getmap request from template request
     *
     * @param maxX maximum X-axis of the bounding box for specific tile
     * @param maxY maximum Y-axis of the bounding box for specific tile
     * @param minX minimum X-axis of the bounding box for specific tile
     * @param minY minimum Y-axis of the bounding box for specific tile
     * @return getmap request as string
     */
    public String getRequest(String maxX, String maxY, String minX, String minY) {
        StringBuilder requestBuilder = new StringBuilder(this.template);
        String bbox = new StringBuilder()
                .append(minX)
                .append(",")
                .append(minY)
                .append(",")
                .append(maxX)
                .append(",")
                .append(maxY)
                .toString();
        return requestBuilder.insert(offset(requestBuilder, "BBOX="), bbox).toString();
    }

}
