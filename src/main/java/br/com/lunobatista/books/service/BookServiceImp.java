package br.com.lunobatista.books.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lunobatista.books.domain.Book;
import br.com.lunobatista.books.repository.BookRepository;

@Service
public class BookServiceImp implements BookService{

	private BookRepository bookRepository;
	
	@Override
	public List<Book> listOfbooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book save() {
		// TODO Auto-generated method stub
		return null;
	}

}
