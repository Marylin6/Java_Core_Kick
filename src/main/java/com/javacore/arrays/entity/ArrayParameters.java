package main.java.com.javacore.arrays.entity;

public class ArrayParameters {

    private double sum;
    private double min;
    private double max;
    private double average;

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "sum=" + sum +
                ", min=" + min +
                ", max=" + max +
                ", avg=" + average;
    }
}
