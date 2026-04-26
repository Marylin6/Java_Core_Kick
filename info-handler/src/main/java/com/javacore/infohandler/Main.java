package com.javacore.infohandler;

import com.javacore.infohandler.entity.*;
import com.javacore.infohandler.exception.TextParseException;
import com.javacore.infohandler.parser.*;
import com.javacore.infohandler.service.TextAnalysisService;
import com.javacore.infohandler.service.TextOperationService;
import com.javacore.infohandler.util.FileReaderUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        try {
            String text = FileReaderUtil.readFile("src/main/java/resources/text.txt");
            TextComponent root = new TextComposite(ComponentType.TEXT);

            Parser textParser = new TextParser();
            Parser sentenceParser = new SentenceParser();
            Parser lexemeParser = new LexemeParser();
            Parser symbolParser = new SymbolParser();

            textParser.setNext(sentenceParser);
            sentenceParser.setNext(lexemeParser);
            lexemeParser.setNext(symbolParser);

            textParser.parse(text, root);

            logger.info("Parsing completed");

            System.out.println("===== RESTORED TEXT =====");
            System.out.println(root.build());
            System.out.println();

            TextAnalysisService analysis = new TextAnalysisService();
            TextOperationService operations = new TextOperationService();

            int letters = analysis.countLetters(root);
            int symbols = analysis.countSymbols(root);

            System.out.println("===== ANALYSIS =====");
            System.out.println("Letters: " + letters);
            System.out.println("Symbols: " + symbols);
            System.out.println();

            int max = operations.maxSentencesWithSameWords(root);

            System.out.println("===== TASK 1 =====");
            System.out.println("Max sentences with same word: " + max);
            System.out.println();

            System.out.println("===== TASK 2 (sorted by 'a') =====");

            List<TextComponent> sorted = operations.sortSentencesByLetter(root, 'a');

            for (TextComponent s : sorted) {
                System.out.println(s.build());
            }

            System.out.println();

            operations.swapFirstLastLexemes(root);

            System.out.println("===== TASK 3 (swap lexemes) =====");
            System.out.println(root.build());

        } catch (TextParseException e) {
            logger.error("Application error", e);
        }
    }
}