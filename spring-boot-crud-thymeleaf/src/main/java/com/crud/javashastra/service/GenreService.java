package com.crud.javashastra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.javashastra.entity.Genre;
import com.crud.javashastra.repository.GenreRepository;

@Service
public class GenreService {
	@Autowired
	GenreRepository repository;
	public List<Genre> findallGenres(){
		return(List<Genre>) repository.findAll();
		
	}
	public Genre findGenreById(int id) {
		Optional<Genre> result= repository.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return new Genre();
	}
	public Genre addGenre(Genre genre) {
		return repository.save(genre);
	}
	public Genre updateGenre(Genre genre) {
		Optional<Genre> result= repository.findById(genre.getId());
		Genre existing=result.get();
		existing.setGenreName(genre.getGenreName());
		return repository.save(existing);
		
	}
	public void deleteById(int id) {
		repository.deleteById(id);
	}
	

}
