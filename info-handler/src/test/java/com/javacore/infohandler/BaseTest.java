package com.javacore.infohandler;

import com.javacore.infohandler.entity.*;
import com.javacore.infohandler.parser.*;

public abstract class BaseTest {

    protected TextComponent parse(String text) throws Exception {

        TextComponent root = new TextComposite(ComponentType.TEXT);

        Parser textParser = new TextParser();
        Parser sentenceParser = new SentenceParser();
        Parser lexemeParser = new LexemeParser();
        Parser symbolParser = new SymbolParser();

        textParser.setNext(sentenceParser);
        sentenceParser.setNext(lexemeParser);
        lexemeParser.setNext(symbolParser);

        textParser.parse(text, root);

        return root;
    }
}