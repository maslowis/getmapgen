package com.github.getmapgen.view;

/**
 * Object containing the initial parameters for generation getmap requests
 *
 * @author maslowis
 */
public class InputValues {
    private String storage;
    private String coordinateSystem;
    private String minX;
    private String minY;
    private String maxX;
    private String maxY;
    private String host;
    private String patternQuery;
    private String zooms;
    private String layers;

    public InputValues() {
    }

    public  InputValues(String storage, String coordinateSystem, String minX, String minY, String maxX, String maxY, String host, String patternQuery, String zooms, String layers) {
        this.storage = storage;
        this.coordinateSystem = coordinateSystem;
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
        this.host = host;
        this.patternQuery = patternQuery;
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

    public String getPatternQuery() {
        return patternQuery;
    }

    public void setPatternQuery(String patternQuery) {
        this.patternQuery = patternQuery;
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

}
