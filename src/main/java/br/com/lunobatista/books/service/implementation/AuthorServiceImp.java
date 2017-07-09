package br.com.lunobatista.books.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lunobatista.books.domain.Author;
import br.com.lunobatista.books.domain.Book;
import br.com.lunobatista.books.repository.AuthorRepository;
import br.com.lunobatista.books.service.AuthorService;

@Service
public class AuthorServiceImp implements AuthorService{

	@Autowired
	private AuthorRepository authorRepository;
	
	
	@Override
	public List<Author> listAll() {
		return (List<Author>) this.authorRepository.findAll();
	}

	@Override
	public Author save(Author author) {
		return this.authorRepository.save(author);
	}

	@Override
	public void delete(Long id) {
		this.authorRepository.delete(id);
	}
	
	public List<Author> saveAuthors(List<Author> authors, Book book){
		
		authors.forEach(a -> {
			a.setBooks(new ArrayList<Book>());
			if ( a != null )
				a.getBooks().add(book);
		});
		
		return (List<Author>) this.authorRepository.save(authors);
	}

}
