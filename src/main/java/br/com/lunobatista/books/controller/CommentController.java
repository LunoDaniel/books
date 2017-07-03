package br.com.lunobatista.books.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lunobatista.books.service.CommentService;


@RestController
@RequestMapping("api/books")
public class CommentController {
	private CommentService commentService;
	
	public CommentController(CommentService commentService){ this.commentService = commentService; }
}
