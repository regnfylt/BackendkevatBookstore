package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.bookcontroller.BookController;
import com.example.demo.bookrestcontroller.BookRestController;
import com.example.demo.categorycontroller.CategoryController;
import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;
import com.example.demo.domain.Category;
import com.example.demo.domain.CategoryRepository;
import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private BookController controllerbook;

	@Autowired
	private BookRestController controllerbookrest;

	@Autowired
	private CategoryController controllercategory;

	@Autowired
	private BookRepository repositorybook;

	@Autowired
	private CategoryRepository repositorycategory;

	@Autowired
	private UserRepository repositoryuser;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controllerbook).isNotNull();
	}

	@Test
	public void contextLoads2() throws Exception {
		assertThat(controllerbookrest).isNotNull();
	}

	@Test
	public void contextLoads3() throws Exception {
		assertThat(controllercategory).isNotNull();
	}
	
	@Test
	 public void findByAuthorShouldReturnBook() {
		List<Book> books = repositorybook.findByAuthor("J.K. Rowling");
		assertThat(books).hasSize(2);
		assertThat(books.get(0).getAuthor()).isEqualTo("J.K. Rowling");
	 }

	 @Test
	  public void createNewBook() {
		Book book = new Book("Koiran ulkoilutus", "Pertti", 1990, "1239812490", 15, null);
		repositorybook.save(book);
		assertThat(book.getId()).isNotNull();
	  }

	@Test
	 public void doesCategoryExistById() {
		Optional<Category> categories = repositorycategory.findById(1L);
		assertThat(categories).isPresent();
	 }

	 

	@Test
	 public void createNewUser() {
		User user = new User("jonihauki", "pietari123", "USER");
		repositoryuser.save(user);
		assertThat(user.getId()).isNotNull();		
	 }

}
