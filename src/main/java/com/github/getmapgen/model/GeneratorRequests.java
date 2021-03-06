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
import com.github.getmapgen.controller.FormDelegate;
import com.github.getmapgen.view.InputValues;
import org.apache.http.impl.client.HttpClients;

/**
 * Generator for getmap request
 *
 * @author maslowis
 */
public class GeneratorRequests implements Runnable {
    // constants for calculating a number of tiles at each scale level
    public static final int DPI = 72;
    public static final double INCHES_PER_METER = 39.37;
    public static final double INCH = 1 / INCHES_PER_METER;
    public static final double PIXEL_LENGTH = INCH / DPI;
    public static final int TILE_SIZE = 256;

    private FormDelegate delegate;

    public GeneratorRequests(FormDelegate delegate) {
        this.delegate = delegate;
    }

    private int getAllTiles(int[] zoomsMap, double lengthMap) {
        int countAllTiles = 0;
        for (int zoom : zoomsMap) {
            double lengthTile = getLengthTile(zoom);
            int tileGrid = getTileGrid(lengthMap, lengthTile);
            int countTiles = getCountTiles(tileGrid);
            countAllTiles += countTiles;
        }
        return countAllTiles;
    }

    private int getCountTiles(int tileGrid) {
        return tileGrid * tileGrid;
    }

    private int getTileGrid(double lengthMap, double lengthTile) {
        int tileGrid = (int) Math.round(lengthMap / lengthTile);
        if (tileGrid == 0) return 1;
        return tileGrid;
    }

    private double getLengthTile(int zoom) {
        double resolution = zoom * PIXEL_LENGTH;
        return TILE_SIZE * resolution;
    }

    private double getLenghtMap(double maxX_Map, double maxY_Map, double minX_Map, double minY_Map) {
        return Math.max((maxX_Map - minX_Map), (maxY_Map - minY_Map));
    }


    private String getInitMessage(InputValues input) {
        return String.format("INITIAL PARAMETERS\n" +
                "STORAGE: %1s\nCOORDINATE SYS: %2s\n" +
                "MAX X: %3s; MAX Y: %4s; MIN X: %5s; MIN Y: %6s\nZOOMS:\n%7s\nLAYERS:\n%8s\nHOST: %9s\nPATTERN REQUEST: %10s", input.getStorage(), input.getCoordinateSystem(), input.getMaxX(), input.getMaxY(), input.getMinX(), input.getMinY(), input.getZooms(), input.getLayers(), input.getHost(), input.getPatternRequest());
    }

    private boolean threadInterrupted() {
        return Thread.currentThread().isInterrupted();
    }

    /**
     * Generate and send getmap requests
     */
    @Override
    public void run() {
//        get input form form
        final InputValues input = delegate.getInput();
//        display parameters input in fields of form
        delegate.displayStatus(getInitMessage(input));
//        instantiating sender and template for getmap request
        final SenderRequest sender = new SenderRequest(HttpClients.createDefault());
        final RequestTemplate template = new RequestTemplate(input);
//        variables for calculate bbox of tiles
        final int[] zooms = Util.stringToInt(Util.splitString(input.getZooms()));
        final double maxX_Map = Double.valueOf(input.getMaxX());
        final double maxY_Map = Double.valueOf(input.getMaxY());
        final double minX_Map = Double.valueOf(input.getMinX());
        final double minY_Map = Double.valueOf(input.getMinY());
        final double lengthMap = getLenghtMap(maxX_Map, maxY_Map, minX_Map, minY_Map);
// variable for increment progress
        int progress = 0;
//        set the start and end value of progress bar
        delegate.initializeProgressBar(progress, getAllTiles(zooms, lengthMap));
// go through zooms
        for (int zoom : zooms) {
//              check if thread has been interrupted then break
            if (threadInterrupted()) break;
//            display current zoom
            delegate.displayStatus("ZOOM IS " + zoom);
//            calculate tile grid for current zoom
            double lengthTile = getLengthTile(zoom);
            int tileGrid = getTileGrid(lengthMap, lengthTile);
//            calculate count of tiles on tile grid for this zoom and display it
            int countTiles = getCountTiles(tileGrid);
            delegate.displayStatus("COUNT OF TILES FOR THIS ZOOM IS " + countTiles);
//            go through tile grid
            for (int y = 1; y < tileGrid; y++) {
//                check if thread has been interrupted then break
                if (threadInterrupted()) break;
                for (int x = 1; x < tileGrid; x++) {
//                      check if thread has been interrupted then break
                    if (threadInterrupted()) break;
//                    calculate coordinate for bbox of tile
                    double maxX_Tile = minX_Map + (x * (lengthTile));
                    double maxY_Tile = minY_Map + (y * (lengthTile));
                    double minX_Tile = minX_Map + ((x - 1) * (lengthTile));
                    double minY_Tile = minY_Map + ((y - 1) * (lengthTile));
//                    build getmap request as string url
                    String url = template.getRequest(String.valueOf(maxX_Tile), String.valueOf(maxY_Tile), String.valueOf(minX_Tile), String.valueOf(minY_Tile));
//                    send getmap request and get status response
                    String response = sender.send(url);
//                    display status response
                    delegate.displayStatus(response);
//                    increment progress in progress bar
                    delegate.incrementProgressBar(++progress);
                }
            }
        }
    }

}
