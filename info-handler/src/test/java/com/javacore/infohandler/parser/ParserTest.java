package com.javacore.infohandler.parser;

import com.javacore.infohandler.entity.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    @Test
    void shouldParseIntoSentencesAndLexemes() throws Exception {

        String text = "Hello world. Bye.";

        TextComponent root = new TextComposite(ComponentType.TEXT);

        Parser textParser = new TextParser();
        Parser sentenceParser = new SentenceParser();
        Parser lexemeParser = new LexemeParser();
        Parser symbolParser = new SymbolParser();

        textParser.setNext(sentenceParser);
        sentenceParser.setNext(lexemeParser);
        lexemeParser.setNext(symbolParser);

        textParser.parse(text, root);

        assertEquals(1, root.getChildren().size());

        TextComponent paragraph = root.getChildren().get(0);

        assertEquals(2, paragraph.getChildren().size());

        TextComponent sentence = paragraph.getChildren().get(0);

        assertFalse(sentence.getChildren().isEmpty());
    }

    @Test
    void shouldRestoreText() throws Exception {

        String text = "Hello world.";

        TextComponent root = new TextComposite(ComponentType.TEXT);

        Parser textParser = new TextParser();
        Parser sentenceParser = new SentenceParser();
        Parser lexemeParser = new LexemeParser();
        Parser symbolParser = new SymbolParser();

        textParser.setNext(sentenceParser);
        sentenceParser.setNext(lexemeParser);
        lexemeParser.setNext(symbolParser);

        textParser.parse(text, root);

        String restored = root.build();

        assertTrue(restored.contains("Hello"));
        assertTrue(restored.contains("world"));
    }
}
