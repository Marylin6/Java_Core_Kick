package com.javacore.infohandler.entity;

import java.util.List;

public interface TextComponent {

    void add(TextComponent component);

    List<TextComponent> getChildren();

    String build();

    ComponentType getType();
}