package com.jackhodge.visualizer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class AlgorithmViewer<T extends Number> extends JPanel {
    private final double DEFAULT_SCALING = .05;

    int windowSize;
    double graphSideMargins;

    double spaceBetweenBars;

    private ArrayList<T> data;
    private int mainIndex;
    private ArrayList<Integer> emphasizedIndexes;


    public AlgorithmViewer(ArrayList<T> data, Integer mainIndex, ArrayList<Integer> emphasizedIndexes,
                           int windowSize
    ){
        updateData(data, mainIndex, emphasizedIndexes);

        this.windowSize = windowSize;

        int scaleFactor = windowSize/data.size();
        this.graphSideMargins = DEFAULT_SCALING*scaleFactor;
        this.spaceBetweenBars = DEFAULT_SCALING*scaleFactor;

        System.out.println("Algorithm Viewer Init Done:\n" +
                "Scale Factor: " + scaleFactor + "\n" +
                "Graph Side Margins: " + graphSideMargins + "\n" +
                "Space Between Bars: " + spaceBetweenBars + "\n" +
                "Start Data qty: " + data.size() + "\n" +
                "Window Size: " + windowSize + "\n"
                );

        setPreferredSize(new Dimension(windowSize, windowSize));
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int dataLength = this.data.size();

        int barWidth = (int) ((windowSize -  (graphSideMargins*2 + ( spaceBetweenBars*(dataLength-1)) )) / dataLength);

        for(Integer index = 0; index < dataLength; index++){

            // if current index is the main index (red)
            if(index.equals(this.mainIndex)){
                //.out.print("RED, ");
                g.setColor(Color.RED);
            } else {
                // if current index is within the list of emphasized indexes
                Integer finalIndex = index;
                if(this.emphasizedIndexes.stream().anyMatch(x -> x.equals(finalIndex))){
                    //System.out.print("BLUE, ");
                    g.setColor(Color.BLUE);
                } else{
                    // else, color black.
                    //System.out.print("BLACK, ");
                    g.setColor(Color.BLACK);
                }
            }

            // draw bar
            // x,y are top left of rectangle
            int xLocation = (int) (graphSideMargins + (spaceBetweenBars + barWidth)*index);
            // windowSize - height
            int height = (int) this.data.get(index).doubleValue();
            int yLocation = windowSize - height;
            //System.out.println("Update fill rect: " );
            g2d.fillRect(xLocation, yLocation, barWidth, height);

        }

    }
    public void updateData(ArrayList<T> data, Integer mainIndex, ArrayList<Integer> emphasizedIndexes){
        this.data = data;
        this.mainIndex = mainIndex;
        this.emphasizedIndexes = emphasizedIndexes;
        paintImmediately(0, 0, getWidth(), getHeight());

    }
}
