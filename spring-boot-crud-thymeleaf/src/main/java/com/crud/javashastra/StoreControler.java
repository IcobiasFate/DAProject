package com.crud.javashastra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.crud.javashastra.entity.Store;
import com.crud.javashastra.service.BookService;
import com.crud.javashastra.service.MovieService;
import com.crud.javashastra.service.StoreService;

@Controller
public class StoreControler {
	@Autowired
	StoreService service;
	@Autowired
	BookService bookService;
	@Autowired 
	MovieService movieService;
	
	@GetMapping("/index3")
	public String findAllStore(Model model) {
		model.addAttribute("stores", service.findallStores());
		return "all-stores";
	}
	@GetMapping("/addstore")
	public String lunchAddStorePage(Model model) {
		model.addAttribute("store",  new Store());
		model.addAttribute("movies", movieService.findallMovies());
		model.addAttribute("books", bookService.findallBooks());

		
		return "add-store";
	}
	@PostMapping("/createstore")
	public String createStore(Store store) {
		service.addStore(store);
		return"redirect:/index3";
	}
	@GetMapping("/editstore/{id}")
	public String lunchEditPage(Model model,@PathVariable("id")int id) {
		Store store = service.findStoreById(id);
		model.addAttribute("store", store);
		model.addAttribute("books", bookService.findallBooks());
		model.addAttribute("movies", movieService.findallMovies());
		
		return "edit-store";
	}
	@PostMapping("/updatestore")
	public String updateStore(Store store) {
		Store existingStore = service.findStoreById(store.getId());
		existingStore.setStoreName(store.getStoreName());
		existingStore.setBook(store.getBook());
		existingStore.setMovie(store.getMovie());
		
		
		
		service.updateStore(store);
		return "redirect:/index3";
	}
	@GetMapping("/deletestore/{id}")
	public String deleteStore(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/index3";
	
	}
}
