package main.java.com.javacore.arrays.specification;

import main.java.com.javacore.arrays.entity.DoubleArrayEntity;

import java.util.logging.Logger;

public class FindByIdSpecification implements Specification {

    private static final Logger logger = Logger.getLogger(FindByIdSpecification.class.getName());

    private int id;

    public FindByIdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specify(DoubleArrayEntity entity) {
        boolean result = entity.getId() == id;

        if (result) {
            logger.info("Entity matched by id=" + id);
        }

        return result;
    }
}