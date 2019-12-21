package com.search.search.model;

public class Text {

    private final String text, label;

    public Text(String text, String label) {
        this.text = text;
        this.label = label;
    }

    public String getText() {
        return text;
    }

    public String getLabel() {
        return label;
    }
}
