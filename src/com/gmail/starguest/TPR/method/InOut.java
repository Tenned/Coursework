package com.gmail.starguest.TPR.method;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by isv on 13.09.16.
 */
public class InOut {

    public static ArrayList<ArrayList<Double>> ListInit(String path){
        ArrayList<ArrayList<Double>> outList = new ArrayList<ArrayList<Double>> ();
        List<String> lines = new ArrayList<String>();
        try {
            //read file from path
            lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //for every line
        for (String line : lines){
            ArrayList<Double> row = new ArrayList<Double>();
            String number = "";
            for (int i = 0; i < line.length(); i++){
                char symb = line.charAt(i);
                //if this is not space
                if ((int) symb != 32){
                    number += symb;
                    //if this is last symbol
                    if (i + 1 == line.length()){
                        row.add(Double.valueOf(number));
                        number = "";
                    }
                } else if ((int) symb == 32){
                    row.add(Double.valueOf(number));
                    number = "";
                }
            }
            outList.add(row);
        }
        return outList;
    }

    public static ArrayList<ArrayList<Integer>> readBinaryRelation(String path){
        ArrayList<ArrayList<Integer>> outList = new ArrayList<ArrayList<Integer>> ();
        List<String> lines = new ArrayList<String>();
        try {
            //read file from path
            lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //for every line
        for (String line : lines){
            ArrayList<Integer> row = new ArrayList<Integer>();
            String number = "";
            for (int i = 0; i < line.length(); i++){
                char symb = line.charAt(i);
                //if this is not space
                if ((int) symb != 32){
                    number += symb;
                    //if this is last symbol
                    if (i + 1 == line.length()){
                            row.add(Integer.valueOf(number));
                        number = "";
                    }
                } else if ((int) symb == 32){
                    row.add(Integer.valueOf(number));
                    number = "";
                }
            }
            outList.add(row);
        }
        return outList;
    }



    public static ArrayList<Double> PropInit(String path){
        ArrayList<Double> outList = new ArrayList<Double>();
        List<String> line = new ArrayList<String>();
        try {
            //read file from path
            line = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String number = "";
        for (int i = 0; i < line.get(0).length(); i++) {
            char symb = line.get(0).charAt(i);
            //if this is not space
            if ((int) symb != 32) {
                number += symb;
                //if this is last symbol
                if (i + 1 == line.get(0).length()) {
                    outList.add(Double.valueOf(number));
                    number = "";
                }
            } else if ((int) symb == 32) {
                outList.add(Double.valueOf(number));
                number = "";
            }
        }
        return outList;
    }

}
