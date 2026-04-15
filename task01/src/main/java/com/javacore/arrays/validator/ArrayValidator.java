package main.java.com.javacore.arrays.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayValidator {

    private static final String NUMBER_REGEX = "-?\\d+(\\.\\d+)?";
    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_REGEX);

    public boolean isValidArray(String line) {
        if (line == null || line.isBlank()) {
            return false;
        }

        Matcher matcher = NUMBER_PATTERN.matcher(line);

        return matcher.find();
    }
}