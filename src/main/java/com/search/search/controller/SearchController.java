package com.search.search.controller;


import com.search.search.SearchApplication;
import com.search.search.model.SearchResult;
import com.search.search.model.Text;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class SearchController {

    private Map<String, Text> dbRef = SearchApplication.db;

    private Map<String, Set<String>> indexRef = SearchApplication.invertedIndex;

    @GetMapping(path = "/api/search")
    public ResponseEntity<SearchResult> search(@RequestParam("q") String query){

        SearchResult sr =  new SearchResult();

        if (query == null || query.length() == 0)
            return new ResponseEntity<>(sr, HttpStatus.OK);

        List<Text> texts = new ArrayList<>();
        String[] words = query.toLowerCase().trim().split("\\W+");
        for (String word: words){
              if (indexRef.containsKey(word))
                  indexRef.get(word).forEach(x -> texts.add(dbRef.get(x)));
        }
        sr.setTexts(texts);
        return new ResponseEntity<>(sr, HttpStatus.OK);
    }

}
