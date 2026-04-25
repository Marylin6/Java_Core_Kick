package com.javacore.infohandler;

import com.javacore.infohandler.entity.*;
import com.javacore.infohandler.exception.TextParseException;
import com.javacore.infohandler.parser.*;
import com.javacore.infohandler.util.FileReaderUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger =
            LogManager.getLogger(Main.class);

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

            String restored = root.build();

            System.out.println("==== RESTORED TEXT ====");
            System.out.println(restored);

        } catch (TextParseException e) {
            logger.error("Application error", e);
        }
    }
}