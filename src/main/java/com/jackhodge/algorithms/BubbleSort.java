package com.jackhodge.algorithms;

import com.jackhodge.Algo;
import com.jackhodge.visualizer.AlgorithmViewer;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort<T extends Number> implements Algo<T> {

    AlgorithmViewer<T> viewer;
    private ArrayList<T> data;

    private int currentIndex;
    private boolean running;

    boolean swapsMade;

    public BubbleSort(ArrayList<T> data) {
        this.data = data;

        currentIndex = 0;
        running = true;
    }

    @Override
    public ArrayList<T> runStep() {
        if(currentIndex < data.size()-1){
            if(data.get(currentIndex).doubleValue() > data.get(currentIndex+1).doubleValue()){
                T temp = data.get(currentIndex+1);
                data.set(currentIndex+1, data.get(currentIndex));
                data.set(currentIndex, temp);
                swapsMade = true;
            }

            currentIndex++;

            ArrayList<Integer> emphasis = new ArrayList<>();
            emphasis.add(currentIndex+1);
            viewer.updateData(data, currentIndex, emphasis);
        } else {
            if(swapsMade){
                currentIndex = 0;
                swapsMade = false;
            } else {
                running = false;
            }
        }
        return data;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public ArrayList<T> getData() {
        return data;
    }

    @Override
    public void setViewer(AlgorithmViewer viewer) {
        this.viewer = viewer;
    }

    @Override
    public String getName() {
        return "Bubble Sort";
    }
}
