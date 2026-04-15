package main.java.com.javacore.arrays.service;

import main.java.com.javacore.arrays.entity.DoubleArrayEntity;

import java.util.Optional;

public class ArrayMaths {

    public Optional<Double> findMin(DoubleArrayEntity entity) {
        double[] arr = entity.getArray();

        if (arr.length == 0) {
            return Optional.empty();
        }

        double min = arr[0];
        for (double num : arr) {
            if (num < min) {
                min = num;
            }
        }

        return Optional.of(min);
    }

    public Optional<Double> findMax(DoubleArrayEntity entity) {
        double[] arr = entity.getArray();

        if (arr.length == 0) {
            return Optional.empty();
        }

        double max = arr[0];
        for (double num : arr) {
            if (num > max) {
                max = num;
            }
        }

        return Optional.of(max);
    }

    public Optional<Double> sum(DoubleArrayEntity entity) {
        double[] arr = entity.getArray();

        if (arr.length == 0) {
            return Optional.empty();
        }

        double sum = 0;
        for (double num : arr) {
            sum += num;
        }

        return Optional.of(sum);
    }

    public Optional<Double> average(DoubleArrayEntity entity) {
        double[] arr = entity.getArray();

        if (arr.length == 0) {
            return Optional.empty();
        }

        double sum = 0;
        for (double num : arr) {
            sum += num;
        }

        return Optional.of((double) sum / arr.length);
    }
}
