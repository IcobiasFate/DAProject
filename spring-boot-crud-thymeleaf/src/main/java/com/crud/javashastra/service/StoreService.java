package com.crud.javashastra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.javashastra.entity.Store;
import com.crud.javashastra.repository.BookRepository;
import com.crud.javashastra.repository.MovieRepository;
import com.crud.javashastra.repository.StoreRepository;

@Service
public class StoreService {
	@Autowired
	BookRepository bookRepository;
	@Autowired
	MovieRepository movieRepository;
	@Autowired
	StoreRepository repository;
	public List<Store> findallStores(){
		return(List<Store>)repository.findAll();
	}
	public Store findStoreById(int id) {
		Optional<Store> result = repository.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return new Store();
	}
	public Store addStore(Store store) {
		return repository.save(store);
	}
	public Store updateStore(Store store) {
		Optional<Store> result = repository.findById(store.getId());
		Store existing = result.get();
		existing.setStoreName(store.getStoreName());
		return repository.save(existing);
	}
	public void deleteById(int id) {
		repository.deleteById(id);
	}
	
	
	
	

}
