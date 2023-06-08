package com.crud.javashastra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.javashastra.entity.Movie;
import com.crud.javashastra.repository.GenreRepository;
import com.crud.javashastra.repository.MovieRepository;

@Service
public class MovieService {
	@Autowired
	GenreRepository genreRepository;
	@Autowired
	MovieRepository repository;
	public List<Movie> findallMovies(){
		return(List<Movie>) repository.findAll();
		
	}
	public Movie findMovieById(int id) {
		Optional<Movie> result= repository.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return new Movie();
	}
	public Movie addMovie(Movie movie) {
		return repository.save(movie);
	}
	public Movie updateMovie(Movie movie) {
		Optional<Movie> result= repository.findById(movie.getId());
		Movie existing=result.get();
		existing.setMovieName(movie.getMovieName());
		existing.setMoviePrice(movie.getMoviePrice());
		existing.setMovieAuthor(movie.getMovieAuthor());
		existing.setMovieDate(movie.getMovieDate());
		existing.setMoviePublication(movie.getMoviePublication());
		existing.setMovieConsole(movie.getMovieConsole());
		return repository.save(existing);
		
	}
	public List<Movie> searchMoviesByName(String movieName) {
        return repository.findByMovieNameContainingIgnoreCase(movieName);
    }
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}

}
