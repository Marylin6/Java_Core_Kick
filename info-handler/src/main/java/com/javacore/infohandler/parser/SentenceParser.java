package com.javacore.infohandler.parser;

import com.javacore.infohandler.entity.*;
import com.javacore.infohandler.exception.TextParseException;
import com.javacore.infohandler.util.Regex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.*;

public class SentenceParser extends AbstractParser {

    private static final Logger logger = LogManager.getLogger(SentenceParser.class);

    @Override
    public void parse(String text, TextComponent parent) throws TextParseException {

        logger.debug("Parsing sentences");

        try {
            Pattern pattern = Pattern.compile(Regex.SENTENCE);
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {

                String sentenceText = matcher.group();
                TextComponent sentence = new TextComposite(ComponentType.SENTENCE);
                parent.add(sentence);

                if (next != null) {
                    next.parse(sentenceText.trim(), sentence);
                }
            }

        } catch (Exception e) {
            logger.error("Sentence parsing failed", e);

            throw new TextParseException("Text parsing error", e, ComponentType.SENTENCE, text);
        }
    }
}
