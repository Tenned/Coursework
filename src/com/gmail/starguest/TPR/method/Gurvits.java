package com.gmail.starguest.TPR.method;

import java.util.ArrayList;

/**
 * Created by isv on 13.09.16.
 */
public class Gurvits {
    public static void Calculate(ArrayList<ArrayList<Double>> mat){

        //Я ХЗ КАК ЗАПОМНИТЬ ЗНАЧЕНИЕ И ПОЗИЦИЮ ОДНОВРЕМЕННО С ПОМОЩЬЮ COLLECTIONS ИДИТЕ НА ХУЙ

        int index = 0;
        ValueAndIndex Outmax = new ValueAndIndex();
        Outmax.setColPosition(0);
        Outmax.setRowPosition(0);

        for (int i = 0; i < mat.size(); i++){
            ValueAndIndex max = new ValueAndIndex();
            max.setValue(mat.get(i).get(0));
            max.setColPosition(0);
            max.setRowPosition(i);
            ValueAndIndex min = new ValueAndIndex();
            min.setValue(mat.get(i).get(0));
            min.setColPosition(0);
            min.setRowPosition(i);
            for (int j = 0; j < mat.get(i).size(); j++){
                //if value is greater than max
                if (mat.get(i).get(j) > max.getValue()){
                    max.setValue(mat.get(i).get(j));
                    max.setColPosition(j);
                    max.setRowPosition(i);
                }
                //if value is less than min
                if (mat.get(i).get(j) < min.getValue()){
                    min.setValue(mat.get(i).get(j));
                    min.setColPosition(j);
                    min.setRowPosition(i);
                }
            }
            //find maximum by Gurvits function
            if (i == 0)
                Outmax.setValue(Main.C * min.getValue() + (1 - Main.C) * max.getValue());
            else if (Outmax.getValue() < Main.C * min.getValue() + (1 - Main.C) * max.getValue()) {
                Outmax = min;
                Outmax.setValue(Main.C * min.getValue() + (1 - Main.C) * max.getValue());
            }
        }

        System.out.println("Gurvits value: " + Outmax.getValue() + " Position: " + Outmax.getRowPosition() + ", C = " + Main.C);

    }
}
