package com.gmail.starguest.TPR.method;

/**
 * Created by isv on 13.09.16.
 */
public class ValueAndIndex {
    private double value = 0;
    private int rowPosition;
    private int colPosition;

    public int getColPosition() {
        return colPosition + 1;
    }

    public void setColPosition(int colPosition) {
        this.colPosition = colPosition;
    }

    public int getRowPosition() {
        return rowPosition + 1;
    }

    public void setRowPosition(int rowPosition) {
        this.rowPosition = rowPosition;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
