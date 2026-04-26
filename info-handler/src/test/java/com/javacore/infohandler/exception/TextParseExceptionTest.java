package com.javacore.infohandler.exception;

import com.javacore.infohandler.entity.*;
import com.javacore.infohandler.parser.Parser;
import com.javacore.infohandler.parser.TextParser;

import com.javacore.infohandler.util.FileReaderUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TextParseExceptionTest {

    @Test
    void shouldThrowTextParseException() {

        Parser parser = new TextParser();
        TextComponent root = new TextComposite(ComponentType.TEXT);

        TextParseException ex = assertThrows(
                TextParseException.class,
                () -> parser.parse(null, root)
        );

        assertNotNull(ex.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenFileNotFound() {

        assertThrows(TextParseException.class, () -> {
            FileReaderUtil.readFile("non_existing_file.txt");
        });
    }

    @Test
    void shouldClassifySymbolCorrectly() {

        Symbol letter = new Symbol('A');
        Symbol punctuation = new Symbol('.');

        assertEquals(ComponentType.LETTER, letter.getType());
        assertEquals(ComponentType.PUNCTUATION, punctuation.getType());
    }
}
