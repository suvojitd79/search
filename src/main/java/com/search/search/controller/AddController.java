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

    private Map<String, Set<String>> dbRef = SearchApplication.db;

    @PostMapping(path = "/text")
    public void addText(@RequestBody Text text){

          String[] words = text.getText().split("\\W+");
          for (String word: words){

              if (!dbRef.containsKey(word))
                  dbRef.put(word, new HashSet<>());

              dbRef.get(word).add(text.getLabel());
          }

    }

}
