package br.com.lunobatista.books.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.lunobatista.books.domain.Book;
import br.com.lunobatista.books.service.BookService;

@RestController
@RequestMapping("api/books")
public class BookController {
	
	private BookService bookService;
	
	@Autowired 
	public BookController(BookService bookService){ this.bookService = bookService; }
	
	@GetMapping(value={"", "/"})
	public List<Book> listOfBooks(){
		return bookService.listAll();
	}
	
	@RequestMapping(value="api/add", method = RequestMethod.POST)
	public ModelAndView saveBook(@Valid Book book, BindingResult result, RedirectAttributes attributes){
		
		bookService.save(book);
		attributes.addFlashAttribute("menssagem", "Vinho Salvo com Sucesso!");
		return new ModelAndView("redirect:/");
		
	}
}
