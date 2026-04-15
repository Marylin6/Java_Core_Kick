package main.java.com.javacore.arrays.observer;

import main.java.com.javacore.arrays.entity.ArrayParameters;
import main.java.com.javacore.arrays.entity.DoubleArrayEntity;
import main.java.com.javacore.arrays.warehouse.Warehouse;

public class ArrayObserver implements Observer {

    private Warehouse warehouse;

    public ArrayObserver(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void update(DoubleArrayEntity entity) {
        ArrayParameters params = calculate(entity.getArray());
        warehouse.put(entity.getId(), params);
    }

    private ArrayParameters calculate(double[] arr) {
        double sum = 0;
        double min = arr[0];
        double max = arr[0];

        for (double d : arr) {
            sum += d;
            if (d < min) min = d;
            if (d > max) max = d;
        }

        ArrayParameters p = new ArrayParameters();
        p.setSum(sum);
        p.setMin(min);
        p.setMax(max);
        p.setAverage(sum / arr.length);

        return p;
    }
}
