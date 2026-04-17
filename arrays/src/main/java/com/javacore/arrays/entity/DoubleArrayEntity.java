package com.javacore.arrays.entity;

import java.util.Arrays;

import com.javacore.arrays.observer.Observer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DoubleArrayEntity {

    private static final Logger logger = LogManager.getLogger();

    private int id;
    private double[] array;

    private Observer observer;

    public DoubleArrayEntity(int id, double[] array, Observer observer) {
        this.id = id;
        this.array = array;
        this.observer = observer;
        logger.info("Entity created with id={}", id);
    }

    public int getId() {
        return id;
    }

    public double[] getArray() {
        return array;
    }

    public int size() {
        return array.length;
    }

    public double getElement(int index) {
        return array[index];
    }

    public void setElement(int index, double value) {
        logger.info("Updating element at index={} to value={} for id={}", index, value, id);
        array[index] = value;
        notifyObserver();
    }

    public void notifyObserver() {
        if (observer != null) {
            logger.info("Notifying observer for entity id={}", id);
            observer.update(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DoubleArrayEntity that = (DoubleArrayEntity) o;

        if (id != that.id) return false;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(id);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        return "DoubleArrayEntity{id=" + id + ", array=" + Arrays.toString(array) + '}';
    }
}