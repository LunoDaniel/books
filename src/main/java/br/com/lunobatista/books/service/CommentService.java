package br.com.lunobatista.books.service;

import java.util.List;

import br.com.lunobatista.books.domain.Comment;

public interface CommentService {
	public List<Comment> listAll();
	public Comment save(Comment comment);
	public void delete(Comment comment);
}
