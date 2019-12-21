package com.search.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SpringBootApplication
public class SearchApplication {

    public static Map<String, Set<String>> db;

    public static void main(String[] args) {

        db = new HashMap<>();
        SpringApplication.run(SearchApplication.class, args);

    }

}
