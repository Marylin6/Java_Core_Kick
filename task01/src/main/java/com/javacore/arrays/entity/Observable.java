package main.java.com.javacore.arrays.entity;

import main.java.com.javacore.arrays.observer.Observer;

public interface Observable {
    void addObserver(Observer observer);
    void notifyObservers();
}
