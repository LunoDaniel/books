package br.com.lunobatista.books.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.lunobatista.books.domain.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
 
}
