package com.bookapp.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private final Map<Integer, String> bookStore = new HashMap<>();
    private int currentId = 1;

    @PostMapping("/add")
    public String addBook(@RequestParam String title) {
        bookStore.put(currentId, title);
        return "Book added with ID: " + (currentId++);
    }

    @GetMapping
    public Map<Integer, String> listBooks() {
        return bookStore;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        if (bookStore.containsKey(id)) {
            bookStore.remove(id);
            return "Book with ID " + id + " deleted.";
        } else {
            return "Book not found.";
        }
    }
}
