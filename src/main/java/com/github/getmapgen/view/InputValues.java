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

package com.github.getmapgen.view;

import java.io.Serializable;

/**
 * Object containing the initial parameters for generation getmap requests
 *
 * @author maslowis
 */
public class InputValues implements Serializable {
    private static final long serialVersionUID = 8118878230763975043L;
    private String storage;
    private String coordinateSystem;
    private String minX;
    private String minY;
    private String maxX;
    private String maxY;
    private String host;
    private String patternRequest;
    private String zooms;
    private String layers;

    public InputValues() {
    }

    public InputValues(String storage, String coordinateSystem, String minX, String minY, String maxX, String maxY, String host, String patternRequest, String zooms, String layers) {
        this.storage = storage;
        this.coordinateSystem = coordinateSystem;
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
        this.host = host;
        this.patternRequest = patternRequest;
        this.zooms = zooms;
        this.layers = layers;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getCoordinateSystem() {
        return coordinateSystem;
    }

    public void setCoordinateSystem(String coordinateSystem) {
        this.coordinateSystem = coordinateSystem;
    }

    public String getMinX() {
        return minX;
    }

    public void setMinX(String minX) {
        this.minX = minX;
    }

    public String getMinY() {
        return minY;
    }

    public void setMinY(String minY) {
        this.minY = minY;
    }

    public String getMaxX() {
        return maxX;
    }

    public void setMaxX(String maxX) {
        this.maxX = maxX;
    }

    public String getMaxY() {
        return maxY;
    }

    public void setMaxY(String maxY) {
        this.maxY = maxY;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPatternRequest() {
        return patternRequest;
    }

    public void setPatternRequest(String patternRequest) {
        this.patternRequest = patternRequest;
    }

    public String getZooms() {
        return zooms;
    }

    public void setZooms(String zooms) {
        this.zooms = zooms;
    }

    public String getLayers() {
        return layers;
    }

    public void setLayers(String layers) {
        this.layers = layers;
    }

    /**
     * Return instance {@link com.github.getmapgen.view.InputValues} with default values
     *
     * @return {@link com.github.getmapgen.view.InputValues}
     */
    public static InputValues getDefaultInputValues() {
        InputValues defaultInputValues = new InputValues();
        defaultInputValues.setStorage("MEGION");
        defaultInputValues.setCoordinateSystem("3857");
        defaultInputValues.setZooms("10000\n" +
                "25000\n" +
                "50000\n" +
                "100000\n" +
                "250000\n" +
                "500000\n" +
                "1000000");
        defaultInputValues.setLayers("60712\n" +
                "59144");
        defaultInputValues.setHost("http://map1.admmegion.ru/");
        defaultInputValues.setPatternRequest("CacheService/GetTile?FORMAT=&LAYERS=&SERVICE=&VERSION=&REQUEST=&STYLES=&SRS=&BBOX=&WIDTH=&HEIGHT=");
        defaultInputValues.setMaxX("8481409.24530765");
        defaultInputValues.setMaxY("8668214.40303203");
        defaultInputValues.setMinX("8452441.87870273");
        defaultInputValues.setMinY("8629333.48988297");
        return defaultInputValues;
    }
}
