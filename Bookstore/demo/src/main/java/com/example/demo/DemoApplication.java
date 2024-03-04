package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;
import com.example.demo.domain.Category;
import com.example.demo.domain.CategoryRepository;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner initData(BookRepository bookRepository, CategoryRepository categoryRepository) {
        return (args) -> {
            Category scifi = new Category("Scifi");
            Category comic = new Category("Comic");
            Category thriller = new Category("Thriller");
            Category fantasy = new Category("Fantasy");

            categoryRepository.save(scifi);
            categoryRepository.save(comic);
            categoryRepository.save(thriller);
            categoryRepository.save(fantasy);

            Book a = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997, "9780590353427", 13, fantasy);
            Book b = new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998, "9780439064866", 15, fantasy);

            bookRepository.save(a);
            bookRepository.save(b);
        };
    }

}
