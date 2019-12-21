package com.search.search.model;

public class Text {

    private String text, label;

    public Text() {
    }

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

    public void setText(String text) {
        this.text = text;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
