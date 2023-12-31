package com.example.SB4.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SB4.dtoentity.AuthorDTO;
import com.example.SB4.service.AuthorService;


@RestController
@RequestMapping("/author")
public class AuthorController {
	
	@Autowired
	AuthorService a;
	
	//Controller for Getting Author Details
	@GetMapping("/getAllAuthor")
	public ResponseEntity<List<AuthorDTO>> getAllAuthor(){
		return a.getAllAuthor();
	}
	
	//by Author ID
	@GetMapping("/getAuthor/{aid}")
	public ResponseEntity<AuthorDTO> getAuthor(@PathVariable("aid") Long aid){
		return a.getAuthor(aid);
	}
		
	
	//Controller for Adding the Author details in table
	@PostMapping("/addAuthor")
	public ResponseEntity<String> addAuthor(@RequestBody @Valid AuthorDTO author){
		return a.addAuthor(author);
	}
	
	//Controller for Update the Author Details
	@PutMapping("/updateAuthor/{aid}")
	public ResponseEntity<String> updateAuthor(@PathVariable("aid") Long aid,@RequestBody @Valid AuthorDTO author){
		return a.updateAuthor(aid, author);
	}
	
	//controller for delete the Author Details
	@DeleteMapping("/deleteAuthor/{aid}")
	public ResponseEntity<String> deleteAuthor(@PathVariable("aid") Long aid){
		return a.deleteAuthor(aid);
	}
}
