package br.com.lunobatista.books.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity	
public class Comment {
	
	private Long id;
	private String name;
	private String review;
	private Book book;
	
	@Id @GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="review")
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
	@ManyToOne
	@JoinColumn(name = "book")
	@JsonIgnore
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}	

}
