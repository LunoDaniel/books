package br.com.lunobatista.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lunobatista.books.domain.Book;
import br.com.lunobatista.books.repository.BookRepository;

@Service
public class BookServiceImp implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> listAll() {
		return (List<Book>) bookRepository.findAll();
	}

	@Override
	public Book save(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public void delete(Book book) {
		bookRepository.delete(book.getId());;
	}
}
