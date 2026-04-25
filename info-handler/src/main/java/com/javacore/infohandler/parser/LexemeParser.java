package com.javacore.infohandler.parser;

import com.javacore.infohandler.entity.*;
import com.javacore.infohandler.exception.TextParseException;
import com.javacore.infohandler.util.Regex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LexemeParser extends AbstractParser {

    private static final Logger logger = LogManager.getLogger(LexemeParser.class);

    @Override
    public void parse(String text, TextComponent parent) throws TextParseException {

        try {
            String[] lexemes = text.split(Regex.SPACE);
            for (String lex : lexemes) {

                TextComponent lexeme = new TextComposite(ComponentType.LEXEME);
                parent.add(lexeme);

                if (next != null) {
                    next.parse(lex, lexeme);
                }
            }
        } catch (Exception e) {
            logger.error("Lexeme parsing failed", e);

            throw new TextParseException("Text parsing error", e, ComponentType.TEXT, text);
        }
    }
}
