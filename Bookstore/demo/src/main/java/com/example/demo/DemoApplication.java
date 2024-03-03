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

    public CommandLineRunner initBookData(BookRepository bookRepository) {
        return (args) -> {
            Book a  = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997, "9780590353427", 13);
            Book b  = new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998, " 9780439064866", 15);

            bookRepository.save(a);
            bookRepository.save(b);

            System.out.println(a);
            System.out.println(b);
        };
	}

     @Bean
    public CommandLineRunner initCategoryData(CategoryRepository categoryRepository) {
        return (args) -> {
            Category a = new Category("Scifi");
            Category b = new Category("Comic");
            Category c = new Category("Thriller");

            categoryRepository.save(a);
            categoryRepository.save(b);
            categoryRepository.save(c);

            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        };
	}
}
