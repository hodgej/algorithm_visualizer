package com.jackhodge;

import com.jackhodge.algorithms.SelectionSort;
import com.jackhodge.visualizer.AlgorithmViewer;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int temp_size = 500;
        JFrame frame = new JFrame();
        frame.setTitle("Algorithm Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(temp_size, temp_size);

        int runs = 5;
        while(runs != 0) {
            ArrayList<Integer> dummyData = new ArrayList<>();
            int qty = 50;
            for (int x = 0; x < qty; x++) {
                dummyData.add((int) (Math.random() * 500));
            }

            ArrayList<Integer> emphasizes = new ArrayList<>();
            emphasizes.add(2);

            AlgorithmViewer<Integer> myViewer = new AlgorithmViewer<>(dummyData, 1, emphasizes, temp_size);
            SelectionSort<Integer> myAlgorithm = new SelectionSort<Integer>(dummyData);
            AlgorithmRunner<Integer> myRunner = new AlgorithmRunner<>(myAlgorithm);


            frame.add(myViewer);
            frame.pack();
            frame.setVisible(true);

            myAlgorithm.setViewer(myViewer);
            int debugTickCtr = 0;
            while (myAlgorithm.isRunning()) {
                System.out.println("\nTICK: " + debugTickCtr);
                myViewer.updateData(dummyData, 0, new ArrayList<>());
                myRunner.run();
                Thread.sleep(1);
            }
            frame.remove(myViewer);
            runs--;
        }

    }
}