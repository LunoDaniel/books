package br.com.lunobatista.books.service;

import java.util.List;

import br.com.lunobatista.books.domain.Book;

public interface BookService {
	
	public List<Book> listAll();
	public Book save(Book book);
	public void delete(Book book);

}
