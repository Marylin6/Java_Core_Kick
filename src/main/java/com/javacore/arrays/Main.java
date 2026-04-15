package main.java.com.javacore.arrays;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        System.out.println("Программа запущена!");
        logger.info("Логгер работает!");
    }
}