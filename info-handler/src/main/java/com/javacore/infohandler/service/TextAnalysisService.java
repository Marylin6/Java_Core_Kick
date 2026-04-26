package com.javacore.infohandler.service;

import com.javacore.infohandler.entity.*;

public class TextAnalysisService {

    public int countLetters(TextComponent component) {
        int count = 0;

        if (component.getType() == ComponentType.LETTER) {
            return 1;
        }
        else if (component.getType() == ComponentType.PUNCTUATION) {
            return 0;
        }

        for (TextComponent child : component.getChildren()) {
            count += countLetters(child);
        }

        return count;
    }

    public int countSymbols(TextComponent component) {
        int count = 0;

        if (component.getType() == ComponentType.LETTER
                || component.getType() == ComponentType.PUNCTUATION) {
            return 1;
        }

        for (TextComponent child : component.getChildren()) {
            count += countSymbols(child);
        }

        return count;
    }
}
