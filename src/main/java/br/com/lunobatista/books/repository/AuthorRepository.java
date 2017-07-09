package br.com.lunobatista.books.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.lunobatista.books.domain.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>{

}
