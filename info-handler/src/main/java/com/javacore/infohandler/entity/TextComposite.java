package com.javacore.infohandler.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {

    private List<TextComponent> children = new ArrayList<>();
    private ComponentType type;

    public TextComposite(ComponentType type) {
        this.type = type;
    }

    @Override
    public void add(TextComponent component) {
        children.add(component);
    }

    @Override
    public List<TextComponent> getChildren() {
        return children;
    }

    @Override
    public ComponentType getType() {
        return type;
    }

    @Override
    public String build() {
        StringBuilder sb = new StringBuilder();

        for (TextComponent child : children) {
            sb.append(child.build());

            switch (type) {
                case TEXT -> sb.append("\n");
                case PARAGRAPH, SENTENCE -> sb.append(" ");
                case LEXEME -> {}
            }
        }

        return sb.toString().trim();
    }
}
