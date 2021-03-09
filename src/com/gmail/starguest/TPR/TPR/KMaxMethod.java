package com.gmail.starguest.TPR.TPR;

import java.util.ArrayList;

public class KMaxMethod {

    //weight vector to return
    private static ArrayList<ArrayList<Integer>> vecOfKMaxForBR = new ArrayList<ArrayList<Integer>>();

    //return KMax result
    static ArrayList<ArrayList<Integer>> getResult(){
        return vecOfKMaxForBR;
    }

    //display KMax result
    static void display(){
        for (ArrayList<Integer> row : vecOfKMaxForBR){
            System.out.println(row);
        }
    }

    static void calculate(ArrayList<ArrayList<Integer>> mat){

        vecOfKMaxForBR = new ArrayList<ArrayList<Integer>>();

        //iterate through matrix
        for (int optionToCheck = 0; optionToCheck < mat.size(); optionToCheck++){
            //initialize KMax coefs
            int hr = 0, er = 0, nr = 0;
            //start from first column
            for (int optionToCompare = 0; optionToCompare < mat.get(optionToCheck).size(); optionToCompare++){
                //no need compare option with itself
                if (optionToCheck == optionToCompare){
                    doNothing();
                } else {
                    //if option dominate on another option, increase hr coef
                    if (mat.get(optionToCheck).get(optionToCompare) == 1) {
                        hr++;
                        //if that option equals to another, it belongs to er (increase), decrease hr because wrong condition was entered
                        if (mat.get(optionToCompare).get(optionToCheck) == 1) {
                            er++;
                            hr--;
                        }
                    } else {
                        //else, option not dominate
                        //if that option equals to another, it belongs to nr (increase), when x and y are not in relation
                        if (mat.get(optionToCompare).get(optionToCheck) == 0) {
                            nr++;
                        }
                    }
                }
            }
            //call function to calculate KMax vector for option
            addOptionKMax(hr, er, nr);

        }

    }

    private static void addOptionKMax(int hr, int er, int nr){
        //calculate alternative subset
        int s1 = hr + er + nr;
        int s2 = hr + nr;
        int s3 = hr + er;
        int s4 = hr;

        //initialize coefs list for an option
        ArrayList<Integer> optionKMax = new ArrayList<Integer>();

        optionKMax.add(s1);
        optionKMax.add(s2);
        optionKMax.add(s3);
        optionKMax.add(s4);

        //add coefs to a BR KMax result list
        vecOfKMaxForBR.add(optionKMax);

    }

    private static void doNothing(){}
}
