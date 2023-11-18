package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Book;
import com.example.demo.model.Librarian;
import com.example.demo.service.LibrarianService;

@RestController
@RequestMapping("/librarianService")
public class LibrarianController {

	@Autowired
	private LibrarianService librarianService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/addLibrarian")
	public String registerLibrarian(@RequestBody Librarian librarian) {		
		String result = librarianService.addLibrarian(librarian);		
		return result;
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public String delelteBookById(@PathVariable int id) {
		restTemplate.delete("http://bookservice/bookService/deleteBook/{id}", id);
		return "Deleted book succesfully";
	}	
	
	@DeleteMapping("/deleteStudentById/{id}") 
	public String deleteStringById(@PathVariable int id) {
		restTemplate.delete("http://studentservice/studentService/deleteStudentById/{id}",id);
		return "student deleted succesfully";
	}
	
	@PostMapping("/addBook1")
	public String registerBook(@RequestBody Book book) {
		String result = restTemplate.postForObject("http://bookservice/bookService/addBook", book, String.class);
		return result ;
	}
	
}
