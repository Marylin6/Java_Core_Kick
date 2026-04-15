package main.java.com.javacore.arrays.validator;

public class ArrayValidator {

    private static final String SPLIT_REGEX = "[,;\\s-]+";
    private static final String NUMBER_REGEX = "-?\\d+(\\.\\d+)?";

    public boolean isValidArray(String line) {
        if (line == null || line.isBlank()) {
            return false;
        }

        String[] parts = line.split(SPLIT_REGEX);

        for (String part : parts) {
            if (!part.matches(NUMBER_REGEX)) {
                return false;
            }
        }

        return true;
    }
}