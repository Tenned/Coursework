package com.gmail.starguest.TPR.method;

import java.util.ArrayList;

/**
 * Created by isv on 13.09.16.
 */
public class Savidge {

    public static void Calculate(ArrayList<ArrayList<Double>> mat){

        ValueAndIndex min = new ValueAndIndex();
        mat = Convert(mat);

        for (int i = 0; i < mat.size(); i++){
            ValueAndIndex max = new ValueAndIndex();
            max.setValue(mat.get(i).get(0));
            max.setColPosition(0);
            max.setRowPosition(i);
            for (int j = 0; j < mat.get(i).size(); j++){
                //if value is greater than max
                if (mat.get(i).get(j) > max.getValue()){
                    max.setValue(mat.get(i).get(j));
                    max.setColPosition(j);
                    max.setRowPosition(i);
                }
            }
            //initialize min
            if (i == 0)
                min = max;
            //if max lesser than min, then
            if (max.getValue() < min.getValue())
                min = max;

        }

        System.out.println("Savidge value: " + min.getValue() + " Position: " + min.getRowPosition());

    }

    private static ArrayList<ArrayList<Double>> Convert(ArrayList<ArrayList<Double>> mat){
        ArrayList<ArrayList<Double>> outMat = new ArrayList<ArrayList<Double>>();

        ArrayList<Double> maximums = new ArrayList<Double>();

        //find maximums for every column
        for (int j = 0; j < mat.get(0).size(); j++){
            maximums.add(mat.get(0).get(j));
            for (int i = 0; i < mat.size(); i++){
                if (maximums.get(j) < mat.get(i).get(j)){
                    maximums.set(j, mat.get(i).get(j));
                }
            }
        }

        //substract maximum from input matrix
        for (int i = 0; i < mat.size(); i++){
            ArrayList<Double> row  = new ArrayList<Double>();
            for (int j = 0; j < mat.get(i).size(); j++){
                row.add(maximums.get(j) - mat.get(i).get(j));
            }
            outMat.add(row);
        }

        return outMat;
    }
}
