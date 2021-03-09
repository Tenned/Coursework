package com.gmail.starguest.TPR.method;

import java.util.ArrayList;


public class Main {

    public final static double C = 0.54;
    public final static String FIRST_PATH = "data/solutionmat1.txt";
    public final static String SECOND_PATH = "data/solutionmat2.txt";
    public final static String PROP_PATH = "data/propabilities1.txt";
    public final static String WW1_PATH = "data/WWmat1.txt";
    public final static String WW2_PATH = "data/WWmat2.txt";
    public final static String WW1PROP_PATH = "data/propabilities2.txt";
    public final static String WW2PROP_PATH = "data/propabilities3.txt";

    public static void main(String[] args) {
        ArrayList<ArrayList<Double>> mat1 = new ArrayList<>();
        ArrayList<ArrayList<Double>> mat2 = new ArrayList<>();
        ArrayList<ArrayList<Double>> WWmat1 = new ArrayList<>();
        ArrayList<ArrayList<Double>> WWmat2 = new ArrayList<>();
        ArrayList<Double> props = new ArrayList<Double>();
        ArrayList<Double> WW1props = new ArrayList<Double>();
        ArrayList<Double> WW2props = new ArrayList<Double>();

        mat1 = InOut.ListInit(FIRST_PATH);
        mat2 = InOut.ListInit(SECOND_PATH);
        props = InOut.PropInit(PROP_PATH);
        WWmat1 = InOut.ListInit(WW1_PATH);
        WWmat2 = InOut.ListInit(WW2_PATH);
        WW1props = InOut.PropInit(WW1PROP_PATH);
        WW2props = InOut.PropInit(WW2PROP_PATH);

        BayesLaplas.Calculate(WWmat1, WWmat2, WW1props, WW2props);

        //MiniMax.Calculate(mat1);
        //Savidge.Calculate(mat1);
        //Gurvits.Calculate(mat1);
        //BayesLaplas.Calculate(mat2, props);

    }
}
