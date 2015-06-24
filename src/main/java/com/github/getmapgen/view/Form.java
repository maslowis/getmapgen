package com.github.getmapgen.view;

import com.github.getmapgen.controller.ExitButtonListener;
import com.github.getmapgen.controller.FormDelegate;
import com.github.getmapgen.controller.RunButtonListener;
import com.github.getmapgen.controller.StopButtonListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.JTextComponent;
import java.awt.*;

/**
 * Graphics user interface
 *
 * @author maslowis
 */
public class Form extends JFrame {
    // fields of form for input values
    private JTextField storage;
    private JTextField coordinateSystem;
    private JTextField minX;
    private JTextField minY;
    private JTextField maxX;
    private JTextField maxY;
    private JTextField host;
    private JTextField patternRequest;
    private JTextArea zooms;
    private JTextArea layers;
    // other components of form
    private JTextArea status;
    private JProgressBar progressBar;
    private JPanel panelCenter;
    private JPanel panelSouth;
    private JPanel panelNord;
    private JPanel panelNordWest;
    private JPanel panelNordCenter;
    private JPanel panelNordEast;
    private JPanel panelCenterNord;
    private JPanel panelCenterSouth;
    private JButton buttonRun;
    private JButton buttonExit;
    private JButton buttonStop;
    private JScrollPane scrollStatus;
    private JScrollPane scrollZooms;
    private JScrollPane scrollLayers;

    public Form() {
        this.initializeComponents();
        this.setBorders();
        this.setLayoutManagers();
        this.setColors(Color.DARK_GRAY);
        this.setDefaultValues();
        this.setHelpers();
        this.setRelationships();
        this.setListeners();
        this.setOptionsFrame();
    }

    private void initializeComponents() {
        this.panelCenter = new JPanel();
        this.panelSouth = new JPanel();
        this.panelNord = new JPanel();
        this.panelNordWest = new JPanel();
        this.panelNordCenter = new JPanel();
        this.panelNordEast = new JPanel();
        this.panelCenterNord = new JPanel();
        this.panelCenterSouth = new JPanel();
        this.storage = new JTextField();
        this.coordinateSystem = new JTextField();
        this.minX = new JTextField();
        this.minY = new JTextField();
        this.maxX = new JTextField();
        this.maxY = new JTextField();
        this.host = new JTextField();
        this.patternRequest = new JTextField();
        this.zooms = new JTextArea();
        this.layers = new JTextArea();
        this.status = new JTextArea();
        this.status.setMinimumSize(this.status.getMaximumSize());
        this.status.setLineWrap(true);
        this.status.setEnabled(false);
        this.progressBar = new JProgressBar();
        this.progressBar.setStringPainted(true);
        this.buttonRun = new JButton("Run");
        this.buttonStop = new JButton("Stop");
        this.buttonExit = new JButton("Exit");
        this.scrollStatus = new JScrollPane(this.status, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.scrollZooms = new JScrollPane(this.zooms, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.scrollLayers = new JScrollPane(this.layers, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    }

    private void setBorders() {
        setBorder(this.panelNord);
        setBorder(this.panelCenter);
        setBorder(this.panelSouth);
        setBorder(this.panelNordWest);
        setBorder(this.panelNordCenter);
        setBorder(this.panelNordEast);
        setBorder(this.panelCenterNord);
        setBorder(this.panelCenterSouth);
        setBorder(this.storage, "Storage");
        setBorder(this.coordinateSystem, "CoordinateSystem");
        setBorder(this.minX, "minX");
        setBorder(this.minY, "minY");
        setBorder(this.maxX, "maxX");
        setBorder(this.maxY, "maxY");
        setBorder(this.host, "Host");
        setBorder(this.patternRequest, "PatternRequest");
        setBorder(this.status, "Status");
        setBorder(this.zooms, "Zooms");
        setBorder(this.layers, "Layers");
    }

    private void setBorder(JPanel panel) {
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    private void setBorder(JTextComponent field, String title) {
        field.setBorder(new TitledBorder(title));
    }

    public void setLayoutManagers() {
        this.panelNord.setLayout(new BoxLayout(this.panelNord, BoxLayout.LINE_AXIS));
        this.panelCenter.setLayout(new BoxLayout(this.panelCenter, BoxLayout.Y_AXIS));
        this.panelNordWest.setLayout(new BoxLayout(this.panelNordWest, BoxLayout.Y_AXIS));
        this.panelNordCenter.setLayout(new BorderLayout());
        this.panelNordEast.setLayout(new BorderLayout());
        this.panelCenterNord.setLayout(new BoxLayout(this.panelCenterNord, BoxLayout.Y_AXIS));
        this.panelCenterSouth.setLayout(new BorderLayout());
        this.panelSouth.setLayout(new FlowLayout());
    }

    public void setColors(Color color) {
        this.panelNord.setBackground(color);
        this.panelCenter.setBackground(color);
        this.panelSouth.setBackground(color);
        this.panelNordWest.setBackground(color);
        this.panelNordCenter.setBackground(color);
        this.panelNordEast.setBackground(color);
        this.panelCenterNord.setBackground(color);
        this.panelCenterSouth.setBackground(color);
    }

    private void setDefaultValues() {
        this.storage.setText("MEGION");
        this.coordinateSystem.setText("3857");
        this.zooms.setText("10000\n25000\n50000\n100000\n250000\n500000\n1000000");
        this.layers.setText("60712\n59144");
        this.host.setText("http://map1.admmegion.ru/");
        this.patternRequest.setText("CacheService/GetTile?FORMAT=&LAYERS=&SERVICE=&VERSION=&REQUEST=&STYLES=&SRS=&BBOX=&WIDTH=&HEIGHT=");
        this.maxX.setText("8481409.24530765");
        this.maxY.setText("8668214.40303203");
        this.minX.setText("8452441.87870273");
        this.minY.setText("8629333.48988297");
    }

    public void setHelpers() {
        this.storage.setToolTipText("ID is data storage");
        this.coordinateSystem.setToolTipText("Spatial Reference System for map. Value is in form EPSG:nnn (set only number).");
        this.zooms.setToolTipText("Zooms of map");
        this.layers.setToolTipText("IDs layers");
        this.host.setToolTipText("Address of host, for example http://map1.admmegion.ru/ of http://192.168.0.1/");
        this.patternRequest.setToolTipText("Pattern request, for example CacheService/GetTile?FORMAT=&LAYERS=&SERVICE=&VERSION=&REQUEST=&STYLES=&SRS=&BBOX=&WIDTH=&HEIGHT=");
    }

    private void setRelationships() {
        this.panelNordWest.add(this.storage);
        this.panelNordWest.add(this.coordinateSystem);
        this.panelNordWest.add(this.minX);
        this.panelNordWest.add(this.minY);
        this.panelNordWest.add(this.maxX);
        this.panelNordWest.add(this.maxY);
        this.panelNordCenter.add(this.scrollZooms);
        this.panelNordEast.add(this.scrollLayers);
        this.panelCenterNord.add(this.host);
        this.panelCenterNord.add(this.patternRequest);
        this.panelCenterSouth.add(BorderLayout.CENTER, this.scrollStatus);
        this.panelNord.add(this.panelNordWest);
        this.panelNord.add(this.panelNordCenter);
        this.panelNord.add(this.panelNordEast);
        this.panelCenter.add(this.panelCenterNord);
        this.panelCenter.add(this.panelCenterSouth);
        this.panelSouth.add(this.progressBar);
        this.panelSouth.add(this.buttonRun);
        this.panelSouth.add(this.buttonStop);
        this.panelSouth.add(this.buttonExit);
        this.getContentPane().add(BorderLayout.NORTH, this.panelNord);
        this.getContentPane().add(BorderLayout.CENTER, this.panelCenter);
        this.getContentPane().add(BorderLayout.SOUTH, this.panelSouth);
    }

    public void setListeners() {
        FormDelegate delegate = new FormDelegate(this);
        this.buttonRun.addActionListener(new RunButtonListener(delegate));
        this.buttonStop.addActionListener(new StopButtonListener(delegate));
        this.buttonExit.addActionListener(new ExitButtonListener(delegate));
    }

    private void setOptionsFrame() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(700, 500);
        this.setVisible(true);
    }

    /**
     * Set the limit values of the progress bar
     *
     * @param min initial value of progress bar
     * @param max end value of progress bar
     */
    public void initializeProgressBar(final int min, final int max) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Form.this.progressBar.setMinimum(min);
                Form.this.progressBar.setMaximum(max);
            }
        });
    }

    /**
     * Increment the progress of work
     *
     * @param increment value of progress
     */
    public void incrementProgressBar(final int increment) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Form.this.progressBar.setValue(increment);
            }
        });
    }

    /**
     * Add message to status field
     */
    public void displayStatus(final String msg) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Form.this.status.append(msg + "\n");
            }
        });
    }

    /**
     * Create and initialize the object {@link InputValues} that hold input values
     *
     * @return {@link InputValues}
     */
    public InputValues getInput() {
        InputValues input = new InputValues();
        input.setStorage(this.storage.getText());
        input.setCoordinateSystem(this.coordinateSystem.getText());
        input.setHost(this.host.getText());
        input.setPatternRequest(this.patternRequest.getText());
        input.setMaxX(this.maxX.getText());
        input.setMaxY(this.maxY.getText());
        input.setMinX(this.minX.getText());
        input.setMinY(this.minY.getText());
        input.setLayers(this.layers.getText());
        input.setZooms(this.zooms.getText());
        return input;
    }
}
