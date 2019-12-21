package com.search.search.model;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {

    private List<Text> texts;

    public SearchResult() {
    }

    public List<Text> getTexts() {
        return texts;
    }

    public void setTexts(List<Text> texts) {
        this.texts = texts;
    }
}
