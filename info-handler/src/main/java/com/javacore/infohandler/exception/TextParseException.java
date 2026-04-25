package com.javacore.infohandler.exception;

import com.javacore.infohandler.entity.ComponentType;

public class TextParseException extends Exception {

    private ComponentType componentType;
    private String inputFragment;

    public TextParseException(String message) {
        super(message);
    }

    public TextParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public TextParseException(String message, ComponentType componentType, String inputFragment) {
        super(message);
        this.componentType = componentType;
        this.inputFragment = inputFragment;
    }

    public TextParseException(String message,
                              Throwable cause,
                              ComponentType componentType,
                              String inputFragment) {
        super(message, cause);
        this.componentType = componentType;
        this.inputFragment = inputFragment;
    }

    public ComponentType getComponentType() {
        return componentType;
    }

    public String getInputFragment() {
        return inputFragment;
    }

    @Override
    public String getMessage() {
        String base = super.getMessage();

        if (componentType != null || inputFragment != null) {
            StringBuilder sb = new StringBuilder(base);

            if (componentType != null) {
                sb.append(" [component=").append(componentType).append("]");
            }

            if (inputFragment != null) {
                sb.append(" [fragment=").append(inputFragment).append("]");
            }

            return sb.toString();
        }

        return base;
    }
}