package com.jackhodge;

import com.jackhodge.visualizer.AlgorithmViewer;

import java.util.ArrayList;

public interface Algo<T extends Number> {
    public ArrayList<T> runStep();

    public boolean isRunning();

    public ArrayList<T> getData();


    public void setViewer(AlgorithmViewer viewer);

}
