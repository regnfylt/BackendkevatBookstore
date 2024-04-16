package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;
import com.example.demo.domain.Category;
import com.example.demo.domain.CategoryRepository;
import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;

@DataJpaTest
class DemoApplicationTests2 {

	@Autowired
	private BookRepository repositorybook;

	@Autowired
	private CategoryRepository repositorycategory;

	@Autowired
	private UserRepository repositoryuser;

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
