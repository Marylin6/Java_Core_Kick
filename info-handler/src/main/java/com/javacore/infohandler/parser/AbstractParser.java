package com.javacore.infohandler.parser;

public abstract class AbstractParser implements Parser {

    protected Parser next;

    @Override
    public void setNext(Parser next) {
        this.next = next;
    }
}