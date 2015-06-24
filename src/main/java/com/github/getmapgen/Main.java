package com.github.getmapgen;

import com.github.getmapgen.view.Form;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Initializer for application
 *
 * @author maslowis
 */
public class Main {

    static {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        System.setProperty("current.date", dateFormat.format(new Date()));
    }

    public static void main(String[] args) {
        Form gui = new Form();
    }
}
