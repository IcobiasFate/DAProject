package com.crud.javashastra.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.crud.javashastra.entity.Book;

public interface BookRepository extends CrudRepository<Book,Integer> {

	List<Book> findByNameContainingIgnoreCase(String name);

}