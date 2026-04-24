package com.javacore.infohandler.parser;

import com.javacore.infohandler.entity.*;
import com.javacore.infohandler.exception.TextParseException;
import com.javacore.infohandler.util.Regex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextParser extends AbstractParser {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void parse(String text, TextComponent parent)
            throws TextParseException {

        logger.info("Start parsing text");

        try {
            String[] paragraphs = text.split(Regex.PARAGRAPH);

            for (String p : paragraphs) {

                TextComponent paragraph = new TextComposite(ComponentType.PARAGRAPH);
                parent.add(paragraph);

                if (next != null) {
                    next.parse(p.trim(), paragraph);
                }
            }

        } catch (Exception e) {
            logger.error("Text parsing failed", e);

            throw new TextParseException(
                    "Text parsing error",
                    e,
                    ComponentType.TEXT,
                    text
            );
        }
    }
}
