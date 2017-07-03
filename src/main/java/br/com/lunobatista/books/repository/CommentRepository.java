package br.com.lunobatista.books.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.lunobatista.books.domain.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{

}
