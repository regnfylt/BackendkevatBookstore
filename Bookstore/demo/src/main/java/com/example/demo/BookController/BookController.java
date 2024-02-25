package com.example.demo.BookController;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;




@ControllerAdvice
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/booklist")
    public String showBookList(Model model) {
        Iterable<Book> books = bookRepository.findAll(); // Fetch all books from the database
        model.addAttribute("books", books); // Add books to the model
        return "booklist"; // Return the name of the Thymeleaf template
    }
    }
    
