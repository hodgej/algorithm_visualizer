package com.jackhodge;

import com.jackhodge.algorithms.BubbleSort;
import com.jackhodge.algorithms.SelectionSort;
import com.jackhodge.algorithms.StalinSort;
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

        int runs = 5000;

        while(runs != 0) {
            int algorithm = (int) (Math.random()*3);

            ArrayList<Integer> dummyData = new ArrayList<>();
            int qty = 50;
            for (int x = 0; x < qty; x++) {
                dummyData.add((int) (Math.random() * 500));
            }

            ArrayList<Integer> emphasizes = new ArrayList<>();
            emphasizes.add(2);

            Algo<Integer> myAlgorithm;
            if(algorithm == 0){
                myAlgorithm = new SelectionSort<>(dummyData);
            } else if (algorithm == 1){
                myAlgorithm = new StalinSort<Integer>(dummyData);
            } else{
                myAlgorithm = new BubbleSort<Integer>(dummyData);
            }

            AlgorithmViewer<Integer> myViewer = new AlgorithmViewer<>(myAlgorithm.getName(), dummyData, 1, emphasizes, temp_size);

            AlgorithmRunner<Integer> myRunner = new AlgorithmRunner<>(myAlgorithm);


            frame.add(myViewer);
            frame.pack();
            frame.setVisible(true);

            myAlgorithm.setViewer(myViewer);
            int debugTickCtr = 0;
            while (myAlgorithm.isRunning()) {
                System.out.println("\nTICK: " + debugTickCtr);
                myRunner.run();
                Thread.sleep(1);
                ArrayList<Integer> emphasis = new ArrayList<>();
                myViewer.updateData(dummyData, dummyData.size()-1, emphasis);
            }
            Thread.sleep(1000);
            frame.remove(myViewer);
            runs--;
        }

    }
}