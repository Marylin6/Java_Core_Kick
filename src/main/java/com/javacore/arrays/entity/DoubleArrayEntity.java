package main.java.com.javacore.arrays.entity;

import main.java.com.javacore.arrays.observer.Observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class DoubleArrayEntity implements Observable {

    private static final Logger logger = Logger.getLogger(DoubleArrayEntity.class.getName());

    private int id;
    private double[] array;

    private List<Observer> observers = new ArrayList<>();

    public DoubleArrayEntity(int id, double[] array) {
        this.id = id;
        this.array = array;
        logger.info("Entity created with id=" + id);
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
        logger.info("Updating element at index=" + index + " to value=" + value + " for id=" + id);
        array[index] = value;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
        logger.info("Observer added to entity id=" + id);
    }

    @Override
    public void notifyObservers() {
        logger.info("Notifying observers for entity id=" + id);
        for (Observer observer : observers) {
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