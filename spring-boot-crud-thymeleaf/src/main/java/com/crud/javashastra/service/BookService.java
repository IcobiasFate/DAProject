package com.crud.javashastra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.javashastra.entity.Book;

import com.crud.javashastra.repository.BookRepository;
import com.crud.javashastra.repository.GenreRepository;


@Service
public class BookService {
	@Autowired
	GenreRepository genreRepository;
	@Autowired
 BookRepository repository;
	public List<Book> findallBooks(){
		return(List<Book>) repository.findAll();
	}
	public Book findBookById(int id) {
		Optional<Book> result= repository.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return new Book();
	}
	public Book addBook(Book book) {
		return repository.save(book);
	}
	public Book updateBook(Book book) {
		Optional<Book> result= repository.findById(book.getId());
		Book existing=result.get();
		existing.setAuthor(book.getAuthor());
		existing.setName(book.getName());
		existing.setBookPrice(book.getBookPrice());
		existing.setPublication(book.getPublication());
		existing.setBookDate(book.getBookDate());
		return repository.save(existing);
	}
	 public List<Book> searchBooksByName(String name) {
	        return repository.findByNameContainingIgnoreCase(name);
	    }
	public void deleteById(int id) {
		repository.deleteById(id);
	}
	
	

	
}
