package com.javacore.arrays.parser;

import com.javacore.arrays.exception.InvalidDataException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayParserTest {

    private final ArrayParser parser = new ArrayParser();

    static Stream<TestData> validData() {
        return Stream.of(
                new TestData("1, 2, 3", new double[]{1, 2, 3}),
                new TestData("1 - 2 - 3", new double[]{1, 2, 3}),
                new TestData("1, 2, x3, 6..5, 77", new double[]{1, 2, 3, 6, 5, 77}),
                new TestData("11- 2 – 42-", new double[]{11, 2, 42})
        );
    }

    @ParameterizedTest
    @MethodSource("validData")
    void shouldParseCorrectly(TestData data) throws InvalidDataException {
        // when
        double[] result = parser.parse(data.input);

        // then
        assertArrayEquals(data.expected, result);
    }

    static Stream<String> invalidData() {
        return Stream.of(
                "",
                "   ",
                "abc"
        );
    }

    @ParameterizedTest
    @MethodSource("invalidData")
    void shouldThrowException(String input) {
        assertThrows(InvalidDataException.class,
                () -> parser.parse(input));
    }

    // helper class
    static class TestData {
        String input;
        double[] expected;

        TestData(String input, double[] expected) {
            this.input = input;
            this.expected = expected;
        }
    }
}