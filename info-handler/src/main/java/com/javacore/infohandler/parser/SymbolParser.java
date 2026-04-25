package com.javacore.infohandler.parser;

import com.javacore.infohandler.entity.*;
import com.javacore.infohandler.exception.TextParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SymbolParser extends AbstractParser {

    private static final Logger logger =
            LogManager.getLogger(SymbolParser.class);

    @Override
    public void parse(String text, TextComponent parent)
            throws TextParseException {

        try {
            for (char c : text.toCharArray()) {
                parent.add(new Symbol(c));
            }

        } catch (Exception e) {
            logger.error("Symbol parsing failed", e);

            throw new TextParseException("Symbol parsing error", e, ComponentType.SYMBOL, text);
        }
    }
}
