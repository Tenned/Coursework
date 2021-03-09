package com.gmail.starguest.TPR.TPR;

import java.util.ArrayList;

public class DominateMethod {

    private static int dominantOption = 0;
    private static boolean optionChoosed = false;
    private static boolean readyToReturn = false;

    /**
     * calculates option that by dominate method
     */
    static void calculate(ArrayList<ArrayList<Integer>> mat){
        dominantOption = 0;
        readyToReturn = false;

        //iterate through BR, going line by line
        for (int optionToCheck = 0; optionToCheck < mat.size(); optionToCheck++){
            int checker = 0;
            optionChoosed = false;
            //iterate through row to compare option with alternatives
            for (int optionToCompare = 0; optionToCompare < mat.get(optionToCheck).size(); optionToCompare++) {
                //we don`t have to compare option with itself
                if (optionToCheck == optionToCompare) {
                    doNothing();
                } else {
                    //if checker is not 0 then go to the next option(row)
                    if (checker > 0) {
                        break;
                    }
                    //if option that is checking dominates on option to compare, then signal that option still ok
                    if (mat.get(optionToCheck).get(optionToCompare) == 1){
                        optionChoosed = true;
                    } else {
                        //if option that is checking not dominates on option to compare, then increase checker and reset flag
                        checker++;
                        optionChoosed = false;
                    }
                }
            }
            //if we choose option, then signal about readiness to return result and break from loop
            if (optionChoosed){
                readyToReturn = true;
                dominantOption = optionToCheck;
                break;
            }

        }
    }

    /**
     * returns !!!dominant option +1!!!
     */
    protected static int getResult(){
        //if option was choose return option number
        if (readyToReturn) {
            return dominantOption + 1;
        } else {
            //if in BR wasn`t dominant option return 0
            return 0;
        }
    }

    private static void doNothing(){
    }
}
