package com.crud.javashastra;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crud.javashastra.entity.Book;
import com.crud.javashastra.service.BookService;
import com.crud.javashastra.service.GenreService;

@Controller
public class BookControler {
	@Autowired
	BookService service;
	@Autowired
	GenreService genreService;
	
	@GetMapping("/")
	public String findAll(Model model) { 
		model.addAttribute("books", service.findallBooks());
		return "all-books";
		

	}
	@GetMapping("/add")
	public String lunchAddBookPage(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("genres", genreService.findallGenres());
		return "add-book";
	}
	@PostMapping("/addbook")
	public String createBook(Book book) {
		service.addBook(book);
		return "redirect:/";
		
	}
	@GetMapping("/edit/{id}")
	public String launchEditPage(Model model, @PathVariable("id") int id) {
	    Book book = service.findBookById(id);  
	    model.addAttribute("book", book);
	    model.addAttribute("genres",genreService.findallGenres());
	    return "edit-book";
	}
	@PostMapping("/updatebook")
	public String updateBook(Book book) {
		Book existingBook =service.findBookById(book.getId());
		existingBook.setName(book.getName());
		existingBook.setAuthor(book.getAuthor());
		existingBook.setBookPrice(book.getBookPrice());
		existingBook.setGenre(book.getGenre());
		existingBook.setPublication(book.getPublication());
		existingBook.setBookDate(book.getBookDate());
		service.updateBook(existingBook);
		return "redirect:/";
	}
	@GetMapping("/books/search")
	public String searchBooksByName(@RequestParam("search") String name, Model model) {
	    List<Book> filteredBooks = service.searchBooksByName(name);
	    model.addAttribute("books", filteredBooks);
	    return "books-list"; // Name of the Thymeleaf template to display the filtered books
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/";
		
	}
	
	

	
	
}
