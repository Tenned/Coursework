package com.gmail.starguest.TPR.TPR;

import java.util.ArrayList;

public class BlockingMethod {

    private static ArrayList<Integer> zeroCols = new ArrayList<Integer>();

    static void calculate(ArrayList<ArrayList<Integer>> mat){

        zeroCols = new ArrayList<Integer>();

        //iterate through cols of BR
        for (int colIdx = 0; colIdx < mat.get(0).size(); colIdx++){
            int checker = 0;
            //iterate through rows to detect 0
            for (int rowIdx = 0; rowIdx < mat.size(); rowIdx++){
                //if checker value is not zero, then go out from loop
                if (checker > 0){
                    break;
                }
                //if element is 0, then do nothing
                if (mat.get(rowIdx).get(colIdx) == 0){
                  doNothing();
                } else {
                    //if element is not 0, then increase checker
                    checker++;
                }
            }
            //if checker is ok, then remember column with zeros
            if (checker == 0){
                zeroCols.add(colIdx);
            }
        }

    }

    /**
     * method returns !!!column index +1!!!
     */
    protected static ArrayList<Integer> getResult(){
        ArrayList<Integer> returnArr = new ArrayList<Integer>();
        //iterate through zero column indexes
        for (int idx = 0; idx < zeroCols.size(); idx++){
            //convert indexes to column numbers
            returnArr.add(zeroCols.get(idx) + 1);
        }
        return returnArr;
    }

    private static void doNothing(){

    }

}
