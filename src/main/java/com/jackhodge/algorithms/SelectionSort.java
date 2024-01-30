package com.jackhodge.algorithms;

import com.jackhodge.Algo;
import com.jackhodge.visualizer.AlgorithmViewer;

import java.sql.Array;
import java.util.ArrayList;

public class SelectionSort<T extends Number> implements Algo<T> {

    AlgorithmViewer<T> viewer;
    private ArrayList<T> data;

    private int currentIndex;
    private boolean running;

    public SelectionSort(ArrayList<T> data) {
        this.data = data;

        currentIndex = 0;
        running = true;
    }


    public ArrayList<T> getData() {
        return data;
    }


    @Override
    public void setViewer(AlgorithmViewer viewer) {
        this.viewer = viewer;
    }

    public boolean isRunning() {
        return running;
    }


    @Override
    public ArrayList<T> runStep() {
        if(currentIndex < data.size()) {
            System.out.print("\nAlg; cI: " + currentIndex);
            int bestIndex = currentIndex;
            for (int indx = currentIndex + 1; indx < data.size(); indx++) {

                ArrayList<Integer> emphasis = new ArrayList<>();
                emphasis.add(indx);

                viewer.updateData(data, currentIndex, emphasis);

                if (data.get(indx).doubleValue() < data.get(bestIndex).doubleValue()) {
                    bestIndex = indx;
                    System.out.print(indx + "<" + bestIndex + "; ");
                } else {System.out.print(indx + ">" + bestIndex + "; ");}
            }
            System.out.println("\nUpdate indx " + bestIndex);
            T temp = data.get(bestIndex);
            data.set(bestIndex, data.get(currentIndex));
            data.set(currentIndex, temp);

            currentIndex++;



            return data;
        }
        running = false;
        return data;
    }
}
