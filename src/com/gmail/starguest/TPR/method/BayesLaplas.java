package com.gmail.starguest.TPR.method;

import java.util.ArrayList;

/**
 * Created by isv on 14.09.16.
 */
public class BayesLaplas {

    public static void Calculate(ArrayList<ArrayList<Double>> mat, ArrayList<Double> props){

        ValueAndIndex max = new ValueAndIndex();
        boolean changed = false;
        int counter = 0;

        for (ArrayList<Double> row : mat){
            double temp = 0;
            //B-L coef for calculating
            for (int i = 0; i < row.size(); i++)
                temp += row.get(i) * props.get(i);
            if (!changed) {
                max.setValue(temp);
                max.setRowPosition(0);
                changed = true;
            }//if calculated value bigger than last max then change it
            else if (max.getValue() < temp) {
                max.setValue(temp);
                max.setRowPosition(counter);
            }
            counter++;
        }

        System.out.println("Bayes-Laplas value(expecting income): " + max.getValue() + " Strategy: " + max.getRowPosition());

    }

    public static void Calculate(ArrayList<ArrayList<Double>> matFY, ArrayList<ArrayList<Double>> matSY, ArrayList<Double> propsFY, ArrayList<Double> propsSY) {

        ValueAndIndex max = new ValueAndIndex();
        boolean changed = false;
        int counter = 0;
        ArrayList<Double> S = new ArrayList<Double>();

        for (int i = 0; i < matSY.size(); i++){//calculate S matrix
            double temp = 0;
            for (double e : matSY.get(i))
                temp += e;
            S.add(temp);
        }

        for (int i = 0; i < matFY.size(); i++){
            double FYrowSum = 0, result = 0, SYrowSum = 0;
            //B-L coef for calculating
            for (int j = 0; j < matFY.get(i).size(); j++)
                FYrowSum += matFY.get(i).get(j) * propsFY.get(j);
            for (int j = 0; j < i; j++)
                SYrowSum += S.get(j) * propsSY.get(j);
            result = FYrowSum + SYrowSum;
            if (!changed) {
                max.setValue(result);
                max.setRowPosition(0);
                changed = true;
            }//if calculated value bigger than last max then change it
            else if (max.getValue() < result) {
                max.setValue(result);
                max.setRowPosition(counter);
            }
            counter++;
        }

        System.out.println("Bayes-Laplas value(expecting income): " + max.getValue() + " Strategy: " + max.getRowPosition());

    }

}
