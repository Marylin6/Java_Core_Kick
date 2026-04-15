package main.java.com.javacore.arrays.warehouse;

import main.java.com.javacore.arrays.entity.ArrayParameters;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Warehouse {

    private static final Logger logger = Logger.getLogger(Warehouse.class.getName());

    private static Warehouse instance;

    private Map<Integer, ArrayParameters> storage = new HashMap<>();

    private Warehouse() {}

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
            logger.info("Warehouse instance created");
        }
        return instance;
    }

    public void put(int id, ArrayParameters parameters) {
        storage.put(id, parameters);
        logger.info("Stored parameters for id=" + id + ": " + parameters);
    }

    public ArrayParameters get(int id) {
        ArrayParameters params = storage.get(id);

        if (params == null) {
            logger.warning("No parameters found for id=" + id);
        } else {
            logger.info("Retrieved parameters for id=" + id + ": " + params);
        }

        return params;
    }

    public void remove(int id) {
        storage.remove(id);
        logger.info("Removed parameters for id=" + id);
    }
}