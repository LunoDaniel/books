package br.com.lunobatista.books.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

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

import br.com.lunobatista.books.domain.Author;
import br.com.lunobatista.books.domain.Book;
import br.com.lunobatista.books.domain.Comment;
import br.com.lunobatista.books.service.AuthorService;
import br.com.lunobatista.books.service.BookService;
import br.com.lunobatista.books.service.CommentService;

@RestController
@RequestMapping("api/books")
public class BookController {

	private BookService bookService;
	private AuthorService authorService;
	private CommentService commentService;

	@Autowired
	public BookController(BookService bookService, AuthorService authorService, CommentService commentService) {
		this.bookService = bookService;
		this.authorService = authorService;
		this.commentService = commentService;
	}

	@GetMapping(value = { "", "/" })
	public List<Book> listOfBooks() {
		return bookService.listAll();
	}

	@RequestMapping(value = { "", "/" }, method = RequestMethod.POST)
	@Transactional
	public Book saveBook(@RequestBody Book book, HttpServletRequest request) {
			
			List<Author> savedAuthors = authorService.saveAuthors(book.getAuthors(), book);
			List<Comment> savedComments = commentService.saveComments(book.getComments());
			
			book.setAuthors(savedAuthors);
			
			if( savedComments!= null ){
				book.setComments(savedComments);
			}
			
			book = bookService.save(book);
		
		return book;
	}

	@PutMapping(value = { "", "/{id}"} )
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		bookService.save(book);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@DeleteMapping(value = { "", "/{id}" })
	public ResponseEntity<Void> deleteBook(@RequestParam("id") Long id) {
		bookService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
