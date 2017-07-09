package br.com.lunobatista.books.service;

import java.util.List;

import br.com.lunobatista.books.domain.Author;
import br.com.lunobatista.books.domain.Book;

public interface AuthorService {
	
	public List<Author> listAll();
	public Author save(Author author);
	public void delete(Long id);
	public List<Author> saveAuthors(List<Author> authors, Book book);

}
