package br.com.lunobatista.books.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lunobatista.books.domain.Comment;
import br.com.lunobatista.books.repository.CommentRepository;

@Service
public class CommentServiceImp implements CommentService{
	
	private CommentRepository commentRepository;
	
	@Override
	public List<Comment> listAll() {
		return (List<Comment>) commentRepository.findAll();
	}

	@Override
	public Comment save(Comment comment) {
		return commentRepository.save(comment);
	}

	@Override
	public void delete(Comment comment) {
		commentRepository.delete(comment.getId());;
	}
}
