package com.crud.javashastra.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.crud.javashastra.entity.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer>{
	List<Movie> findByMovieNameContainingIgnoreCase(String movieName);

}
