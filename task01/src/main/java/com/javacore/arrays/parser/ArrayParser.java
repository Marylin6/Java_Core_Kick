package main.java.com.javacore.arrays.parser;

import main.java.com.javacore.arrays.exception.InvalidDataException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayParser {

    private static final String NUMBER_REGEX = "-?\\d+(\\.\\d+)?";
    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_REGEX);

    public double[] parse(String line) throws InvalidDataException {
        if (line == null || line.isBlank()) {
            throw new InvalidDataException("Empty line");
        }

        Matcher matcher = NUMBER_PATTERN.matcher(line);

        List<Double> numbers = new ArrayList<>();

        while (matcher.find()) {
            try {
                numbers.add(Double.parseDouble(matcher.group()));
            } catch (NumberFormatException e) {
                throw new InvalidDataException("Invalid number in line: " + line, e);
            }
        }

        if (numbers.isEmpty()) {
            throw new InvalidDataException("No valid numbers in line: " + line);
        }

        // convert List -> array
        double[] result = new double[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            result[i] = numbers.get(i);
        }

        return result;
    }
}
