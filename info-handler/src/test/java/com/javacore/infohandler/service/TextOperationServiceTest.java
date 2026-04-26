package com.javacore.infohandler.service;

import com.javacore.infohandler.BaseTest;

import com.javacore.infohandler.entity.ComponentType;
import com.javacore.infohandler.entity.Symbol;
import com.javacore.infohandler.entity.TextComponent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TextOperationServiceTest extends BaseTest {
    @Test
    void shouldFindMaxSentencesWithSameWord() throws Exception {

        String text = "Hello world. Hello Java. World Java.";
        TextComponent root = parse(text);
        TextOperationService service = new TextOperationService();

        int result = service.maxSentencesWithSameWords(root);

        assertEquals(2, result);
    }

    @ParameterizedTest
    @ValueSource(chars = {'a', 'o'})
    void shouldSortSentencesByLetter(char letter) throws Exception {

        String text = "aaa. b. cc.";
        TextComponent root = parse(text);

        TextOperationService service = new TextOperationService();
        var sorted = service.sortSentencesByLetter(root, letter);

        int first = count(sorted.get(0), letter);
        int last = count(sorted.get(sorted.size() - 1), letter);

        assertTrue(first <= last);
    }

    @Test
    void shouldSwapFirstAndLastLexeme() throws Exception {

        String text = "Бесцветные зеленые идеи яростно спят.";
        TextComponent root = parse(text);
        TextOperationService service = new TextOperationService();
        service.swapFirstLastLexemes(root);
        String result = root.build();
        assertTrue(result.startsWith("спят"));
    }

    private int count(TextComponent sentence, char letter) {

        int count = 0;

        for (TextComponent lex : sentence.getChildren()) {
            for (TextComponent sym : lex.getChildren()) {
                Symbol s = (Symbol) sym;

                if (s.getType() == ComponentType.LETTER && Character.toLowerCase(s.getValue()) == letter) {
                    count++;
                }
            }
        }

        return count;
    }
}
