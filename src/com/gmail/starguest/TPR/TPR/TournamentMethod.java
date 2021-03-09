package com.gmail.starguest.TPR.TPR;

import java.util.ArrayList;

/**
 * Created by isv on 03.12.16.
 * calculates weight vector using tournament method
 */
public class TournamentMethod {

    //weight vector to return
    private static ArrayList<Double> weightVec = new ArrayList<Double>();

    static ArrayList<Double> getWeightVec(){
        return weightVec;
    }

    static void calculate(ArrayList<ArrayList<Integer>> mat){

        weightVec = new ArrayList<Double>();

        double weight = 0;

        //iterate through input matrix
        for (int optionToCheck = 0; optionToCheck < mat.size(); optionToCheck++) {
            //initialize variable to accumulate option weight
            weight = 0;
            //start from first col, then go ahead till end col
            for (int optionToCompare = 0; optionToCompare < mat.get(optionToCheck).size(); optionToCompare++) {
                //if we compare option with itself then skip it
                if (optionToCheck == optionToCompare){
                    doNothing();
                } else {
                    //if option dominate on another option, weight coef +1
                    if (mat.get(optionToCheck).get(optionToCompare) == 1) {
                        weight++;
                        //if that option equals to another, it belongs to special condition => decrease weight coef -1/2
                        if (mat.get(optionToCompare).get(optionToCheck) == 1){
                            weight -= 0.5;
                        }
                    } else {
                        //else, option not dominate
                        //if that option equals to another, it belongs to special condition => increase weight coef +1/2
                        if (mat.get(optionToCompare).get(optionToCheck) == 0){
                            weight += 0.5;
                        }
                    }
                }
            }
            //add weight of option to weight vector
            weightVec.add(weight);
        }

    }

    //return option calculated by tournament method, !!!returns option row index +1!!!
    static int getResult(){
        //variable to return
        int maxIndex = 0;
        //find index of max value
        for (int i = 0; i < weightVec.size(); i++){
            //if element is bigger, then remember its position
            if (weightVec.get(i) > weightVec.get(maxIndex)){
                maxIndex = i;
            }
        }

        return maxIndex + 1;
    }

    private static void doNothing(){
    }


}
