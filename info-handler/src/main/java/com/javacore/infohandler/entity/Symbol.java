package com.javacore.infohandler.entity;

import java.util.List;

public class Symbol implements TextComponent {

    private char value;

    public Symbol(char value) {
        this.value = value;
    }

    @Override
    public void add(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TextComponent> getChildren() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String build() {
        return String.valueOf(value);
    }

    @Override
    public ComponentType getType() {
        return ComponentType.SYMBOL;
    }
}
