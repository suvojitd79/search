package com.search.search.controller;

import com.search.search.SearchApplication;
import com.search.search.model.Text;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(path="/api/add")
public class AddController {

    private Map<String, Text> dbRef = SearchApplication.db;
    private Map<String, Set<String>> indexRef = SearchApplication.invertedIndex;

    @PostMapping(path = "/text")
    public Text addText(@RequestBody Text text){

          String[] words = text.getText().toLowerCase().trim().split("\\W+");

          dbRef.put(text.getLabel().toLowerCase().trim(), text);

          for (String word: words){

              if (!indexRef.containsKey(word))
                  indexRef.put(word, new HashSet<>());

              indexRef.get(word).add(text.getLabel());
          }
          return text;
    }

}
