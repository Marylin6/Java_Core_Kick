package com.javacore.infohandler.parser;

import com.javacore.infohandler.entity.TextComponent;
import com.javacore.infohandler.exception.TextParseException;

public interface Parser {

    void setNext(Parser next);

    void parse(String text, TextComponent parent) throws TextParseException;
}
