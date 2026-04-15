package main.java.com.javacore.arrays.factory;

import main.java.com.javacore.arrays.entity.DoubleArrayEntity;

public class DoubleArrayFactory {
    private int currentId = 1;

    public DoubleArrayEntity create(double[] array) {
        return new DoubleArrayEntity(currentId++, array);
    }
}