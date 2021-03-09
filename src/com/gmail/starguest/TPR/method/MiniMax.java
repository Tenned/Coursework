package com.gmail.starguest.TPR.method;

import java.util.ArrayList;

/**
 * Created by isv on 13.09.16.
 */
public class MiniMax {

    public static void Calculate(ArrayList<ArrayList<Double>> mat){

        ValueAndIndex max = new ValueAndIndex();

        for (int i = 0; i < mat.size(); i++){
            ValueAndIndex min = new ValueAndIndex();
            min.setValue(mat.get(i).get(0));
            min.setColPosition(0);
            min.setRowPosition(i);
            for (int j = 0; j < mat.get(i).size(); j++){
                //if value is less than min
                if (mat.get(i).get(j) < min.getValue()){
                    min.setValue(mat.get(i).get(j));
                    min.setColPosition(j);
                    min.setRowPosition(i);
                }
            }
            //initialize max
            if (i == 0)
                max = min;
            //if min greater than max, then
            if (max.getValue() < min.getValue())
                max = min;

        }

        System.out.println("Minimax value: " + max.getValue() + " Position: " + max.getRowPosition());

    }

}
