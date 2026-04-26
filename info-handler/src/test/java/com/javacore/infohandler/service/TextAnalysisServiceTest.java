package com.javacore.infohandler.service;

import com.javacore.infohandler.BaseTest;
import com.javacore.infohandler.entity.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextAnalysisServiceTest extends BaseTest {

    @Test
    void shouldCountLetters() throws Exception {
        TextComponent root = parse("Hello!");

        TextAnalysisService service = new TextAnalysisService();

        assertEquals(5, service.countLetters(root));
    }

    @Test
    void shouldCountSymbols() throws Exception {
        TextComponent root = parse("Hi!");

        TextAnalysisService service = new TextAnalysisService();

        assertEquals(3, service.countSymbols(root));
    }
}