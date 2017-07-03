package br.com.lunobatista.books.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lunobatista.books.domain.Book;
import br.com.lunobatista.books.service.BookService;

@RestController
@RequestMapping("api/books")
public class BookController {

	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping(value = { "", "/" })
	public List<Book> listOfBooks() {
		return bookService.listAll();
	}

	@RequestMapping(value = { "", "/" }, method = RequestMethod.POST)
	@Transactional
	public Book saveBook(@RequestBody @Valid Book book, HttpServletRequest request) {
		try { 
			book = bookService.save(book);
			
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
		}
		return book;
	}

	@PutMapping(value = { "", "/" })
	public ResponseEntity<Book> updateArticle(@RequestBody Book book) {
		bookService.save(book);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@DeleteMapping(value = { "", "/" })
	public ResponseEntity<Void> deleteArticle(@RequestParam("id") Long id) {
		bookService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
