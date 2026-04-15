package com.javacore.arrays.validator;

import com.javacore.arrays.validator.ArrayValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ArrayValidatorTest {

    private final ArrayValidator validator = new ArrayValidator();

    @ParameterizedTest
    @ValueSource(strings = {
            "1, 2, 3",
            "1 - 2 - 3",
            "3 4 7",
            "abc 123",
            "6..5"
    })
    void shouldReturnTrueForValidLines(String line) {
        // when
        boolean result = validator.isValidArray(line);

        // then
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "",
            "   "
    })
    void shouldReturnFalseForInvalidLines(String line) {
        // when
        boolean result = validator.isValidArray(line);

        // then
        assertFalse(result);
    }
}