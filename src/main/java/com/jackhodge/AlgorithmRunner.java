package com.jackhodge;

import com.jackhodge.visualizer.AlgorithmViewer;

import java.util.ArrayList;


public class AlgorithmRunner<T extends Number> {
    Algo<T> myAlgo;

    public AlgorithmRunner(Algo<T> myAlgo) {
        this.myAlgo = myAlgo;
    }

    public ArrayList<T> run() throws InterruptedException {
        return myAlgo.runStep();
    }
}
