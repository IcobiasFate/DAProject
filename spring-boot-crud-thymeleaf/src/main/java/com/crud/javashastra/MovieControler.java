package com.crud.javashastra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crud.javashastra.entity.Movie;
import com.crud.javashastra.service.GenreService;
import com.crud.javashastra.service.MovieService;

@Controller
public class MovieControler {
	
@Autowired
	MovieService service;
@Autowired
GenreService genreService;

@GetMapping("/index2")
public String findAllMovie(Model model) {
	model.addAttribute("movies", service.findallMovies());
	return "all-movies";
}
@GetMapping("/addmovie")
public String lunchAddMoviePage(Model model) {
	model.addAttribute("movie", new Movie());
	model.addAttribute("genres", genreService.findallGenres());
	return "add-movie";
}
@PostMapping("/createmovie")
public String createMovie(Movie movie) {
	service.addMovie(movie);
	return "redirect:/index2";
}
@GetMapping("/editmovie/{id}")
public String lunchEditPage(Model model,@PathVariable("id")int id) {
	Movie movie = service.findMovieById(id);
	model.addAttribute("movie", movie);
	model.addAttribute("genres", genreService.findallGenres());
	return "edit-movie";
}
@PostMapping("/updatemovie")
public String updateMovie(Movie movie) {
	Movie existingMovie = service.findMovieById(movie.getId());
	existingMovie.setMovieName(movie.getMovieName());
	existingMovie.setMoviePrice(movie.getMoviePrice());
	existingMovie.setGenre(movie.getGenre());
	existingMovie.setMovieAuthor(movie.getMovieAuthor());
	existingMovie.setMovieDate(movie.getMovieDate());
	existingMovie.setMoviePublication(movie.getMoviePublication());
	existingMovie.setMovieConsole(movie.getMovieConsole());
	service.updateMovie(movie);
	return "redirect:/index2";
}
@GetMapping("/movies/search")
public String searchMoviesByName(@RequestParam("movieName") String movieName, Model model) {
    List<Movie> movies = service.searchMoviesByName(movieName);
    model.addAttribute("movies", movies);
    return "movies-list"; // Create a corresponding view for displaying search results
}
@GetMapping("/deletemovie/{id}")
public String deleteMovie(@PathVariable("id")int id) {
	service.deleteById(id);
	return "redirect:/index2";
	
}





}
