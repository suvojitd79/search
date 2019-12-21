package com.search.search;

import com.search.search.model.Text;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.TabExpander;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SpringBootApplication
public class SearchApplication {

    public static Map<String, Set<String>> invertedIndex;
    public static Map<String, Text> db;

    public static void main(String[] args) {
        invertedIndex = new HashMap<>();
        db = new HashMap<>();
        SpringApplication.run(SearchApplication.class, args);

    }


}
