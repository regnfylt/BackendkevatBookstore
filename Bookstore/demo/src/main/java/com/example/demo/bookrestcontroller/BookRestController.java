package com.example.demo.bookrestcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;

@CrossOrigin
@Controller
public class BookRestController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> getBooksRest() {
        return (List<Book>) bookRepository.findAll();
    }

    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> getBookByIdRest(@PathVariable("id") Long bookId) {
        return bookRepository.findById(bookId);
    }
}
