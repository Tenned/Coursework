package com.gmail.starguest.TPR.TPR;

import com.gmail.starguest.TPR.method.InOut;

import java.util.ArrayList;

/**
 * Created by isv on 03.12.16.
 */
public class Main {

    private final static String BR1_PATH = "data/BO1.txt";
    private final static String BR2_PATH = "data/BO2.txt";
    private final static String BR3_PATH = "data/BO3.txt";
    private final static String BR4_PATH = "data/BO4.txt";
    private final static String BR5_PATH = "data/BO5.txt";
    private final static int BR_NUM = 5;
    private final static String OPTION_VALUE_PATH = "data/optVal.txt";

    //key node of the program starts here
    public static void main(String[] args) {

        summarize();

    }

    //display results of calculations, big enough, but it ONLY displaying
    private static void summarize(){

        //read option values, PropInit returns one-dimensional double array, so it goes on :)
        ArrayList<Double> optVals = InOut.PropInit(OPTION_VALUE_PATH);

        //initialize all binary relation matrices
        ArrayList<ArrayList<ArrayList<Integer>>> brList = new ArrayList<ArrayList<ArrayList<Integer>>>();
        brList.add(InOut.readBinaryRelation(BR1_PATH));
        brList.add(InOut.readBinaryRelation(BR2_PATH));
        brList.add(InOut.readBinaryRelation(BR3_PATH));
        brList.add(InOut.readBinaryRelation(BR4_PATH));
        brList.add(InOut.readBinaryRelation(BR5_PATH));

        //display results for blocking method
        //iterate through BR list
        System.out.println("Blocking method:");
        for (int brIdx = 0; brIdx < BR_NUM; brIdx++){
            //make calculations for BR
            BlockingMethod.calculate(brList.get(brIdx));
            //display result
            System.out.println("For " + (brIdx + 1) + " binary relation: " + BlockingMethod.getResult());
        }

        System.out.println();
        //display results for dominate method
        //iterate through BR list
        System.out.println("Dominate method:");
        for (int brIdx = 0; brIdx < BR_NUM; brIdx++){
            //make calculations for BR
            DominateMethod.calculate(brList.get(brIdx));
            //display result
            System.out.println("For " + (brIdx + 1) + " binary relation: " + DominateMethod.getResult());
        }


        System.out.println();
        ArrayList<ArrayList<Double>> weightCoefs = new ArrayList<ArrayList<Double>>();
        ArrayList<Double> weightSum = new ArrayList<Double>();
        //initialize weight sum
        for (int brIdx = 0; brIdx < BR_NUM; brIdx++){
            weightSum.add(0.0);
        }
        //display results for tournament method
        //iterate through BR list
        System.out.println("Tournament method:");
        for (int brIdx = 0; brIdx < BR_NUM; brIdx++){
            //make calculations for BR
            TournamentMethod.calculate(brList.get(brIdx));
            //add weight coef to the list
            weightCoefs.add(TournamentMethod.getWeightVec());
            //display weight vector for every BR
            System.out.println("For " + (brIdx + 1) + " binary relation (option value cefficient: " + optVals.get(brIdx) + "): ");
            for (int idx = 0; idx < TournamentMethod.getWeightVec().size(); idx++){
                System.out.println(TournamentMethod.getWeightVec().get(idx) + " (" +
                        (TournamentMethod.getWeightVec().get(idx) * optVals.get(brIdx) + " with option value coefficient)"));
            }
        }
        System.out.println("Total:");
        //calculate weight sum for every binary relation
        for (int brIdx = 0; brIdx < BR_NUM; brIdx++){
            //iterate through every BR weight coef
            for (int weightIdx = 0; weightIdx < weightCoefs.get(brIdx).size(); weightIdx++){
                double coef = weightCoefs.get(weightIdx).get(brIdx) * optVals.get(weightIdx),
                lastVal = weightSum.get(brIdx);
                //compose weight sum for every option
                weightSum.set(brIdx, lastVal + coef);
            }
        }
        int idx = 0;
        //display weight sum calculated by tournament method
        for (double value : weightSum){
            System.out.println("For " + (++idx) + " binary relation: " + value);
        }

        System.out.println();
        //display results of KMax coefs
        for (int brIdx = 0; brIdx < BR_NUM; brIdx++){
            //make calculations for BR
            KMaxMethod.calculate(brList.get(brIdx));
            //display k-max vectors for every binary relation
            System.out.println("For " + (brIdx + 1) + " binary relation: ");
            KMaxMethod.display();
        }

    }


}
