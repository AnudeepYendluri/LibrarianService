package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Librarian;
import com.example.demo.repository.LibrarianRepository;

@Service
public class LibrarianService {

	@Autowired
	private LibrarianRepository librarianRepo;
	
	public String addLibrarian(Librarian librarian) {
		Librarian librarian1 = librarianRepo.save(librarian);
		if(librarian1 != null) {
			return "Librarian added succesfully";
		}
		return "Something went wrong";
	}
	
	
	
	
}
