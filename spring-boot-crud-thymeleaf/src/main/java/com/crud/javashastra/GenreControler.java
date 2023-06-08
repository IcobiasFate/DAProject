package com.crud.javashastra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.crud.javashastra.entity.Genre;
import com.crud.javashastra.service.GenreService;

@Controller
public class GenreControler {
	
@Autowired
	GenreService service;
@GetMapping("/index")
public String findAllGenre(Model model) {
	model.addAttribute("genres", service.findallGenres());
	return "all-genre";
}
@GetMapping("/addgenre")
public String lunchAddGenrePage(Model model) {
	model.addAttribute("genre", new Genre());
	return "add-genre";
}
@PostMapping("/create")
public String createGenre(Genre genre) {
	service.addGenre(genre);
	return "redirect:/index";
}
@GetMapping("/editgenre/{id}")
public String lunchEditPage(Model model,@PathVariable("id")int id) {
	model.addAttribute("genre", service.findGenreById(id));
	return "edit-genre";
}
@PostMapping("/updategenre")
public String updateGnere(Genre genre) {
	service.updateGenre(genre);
	return "redirect:/index";
}
@GetMapping("/deletegenre/{id}")
public String deleteGenre(@PathVariable("id")int id) {
	service.deleteById(id);
	return "redirect:/index";
	
}





}
