package com.jackhodge.algorithms;

import com.jackhodge.Algo;
import com.jackhodge.visualizer.AlgorithmViewer;

import java.util.ArrayList;
import java.util.Collections;

public class StalinSort<T extends Number> implements Algo<T> {

    AlgorithmViewer<T> viewer;
    private ArrayList<T> data;

    private int currentIndex;
    private boolean running;


    public StalinSort(ArrayList<T> data) {
        this.data = data;

        currentIndex = 0;
        running = true;
    }

    @Override
    public ArrayList<T> runStep() {
        if(currentIndex < data.size()-1){
            if(data.get(currentIndex).doubleValue() > data.get(currentIndex+1).doubleValue()){
                data.remove(currentIndex+1);
            } else{
                currentIndex++;
            }
            ArrayList<Integer> emphasis = new ArrayList<>();
            emphasis.add(currentIndex+1);
            viewer.updateData(data, currentIndex, emphasis);
        } else {
            running = false;
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
        return "Stalin Sort";
    }
}
