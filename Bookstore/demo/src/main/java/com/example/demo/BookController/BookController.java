package com.example.demo.bookcontroller;

import org.springframework.ui.Model;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;

import io.micrometer.common.lang.NonNull;





@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/booklist")
    public String showBookList(Model model) {
        Iterable<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "booklist";
    }
    @GetMapping("/addbook")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @SuppressWarnings("null")
    @PostMapping("/addbook")
    public String addBook(@ModelAttribute Book newBook) {
        bookRepository.save(newBook);
        return "redirect:/booklist";
    }

    @SuppressWarnings("null")
    @GetMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable @NonNull Long id) {
        
            bookRepository.deleteById(id);
        return "redirect:/booklist";
    }

    @SuppressWarnings("null")
    @GetMapping("/editbook/{id}")
    public String showEditBookForm(@PathVariable Long id, Model model) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            model.addAttribute("book", optionalBook.get());
            return "editbook";
        } else {
            return "redirect:/booklist";
        }
    }

    @PostMapping("/updatebook")
    public String updateBook(@ModelAttribute Book updatedBook) {
        bookRepository.save(updatedBook);
        return "redirect:/booklist";
    }
    
    
    }
    
