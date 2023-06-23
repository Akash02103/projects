package com.example.SB4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.SB4.converter.AuthorDtoConverter;
import com.example.SB4.dtoentity.AuthorDTO;
import com.example.SB4.entity.Author;
import com.example.SB4.entity.Book;
import com.example.SB4.exception.AuthorIsPresentAlready;
import com.example.SB4.exception.AuthorNotFound;
import com.example.SB4.exception.InsertingAuthorException;
import com.example.SB4.repo.AuthorRepo;
import com.example.SB4.repo.BookRepo;



@Service
public class AuthorService{
	@Autowired
	public AuthorRepo a;
	
	@Autowired
	public BookRepo b;

	//Getting Author details
	public ResponseEntity<List<AuthorDTO>> getAllAuthor(){
		
		if(a.findAll().size() <=0) {
			throw new AuthorNotFound();
		}else {
			AuthorDtoConverter dto=new AuthorDtoConverter();
			return ResponseEntity.ok(dto.EntitytoListDTO(a.findAll()));
		}
	}
	
	//Getting Author details based on id
	public ResponseEntity<AuthorDTO> getAuthor(Long aid){
		try {
			AuthorDtoConverter dto=new AuthorDtoConverter();
			return ResponseEntity.ok(dto.EntitytoDTO(a.findById(aid).get()));
		} catch (Exception e) {
			throw new AuthorNotFound();
		}
	}
	
	
	//Insert Author Details in table
	public ResponseEntity<String> addAuthor(AuthorDTO author){
		try {
			if(isAuthorPresent(author)==true) {
				throw new AuthorIsPresentAlready();
			}else {
				AuthorDtoConverter dto=new AuthorDtoConverter();
				a.save(dto.DtotoEntity(author));
				return ResponseEntity.ok("insert");
			}
			
		}catch(InsertingAuthorException e) {
			throw new InsertingAuthorException();
		}catch (AuthorIsPresentAlready e) {
			throw new AuthorIsPresentAlready();
		}
	}	
	
	//Update Author Details
	public ResponseEntity<String> updateAuthor(Long aid,AuthorDTO author){
		try {
			
		
			Author a1=a.findById(aid).get();
			a1.setAemail(author.getAemail());
			a1.setAname(author.getAname());
			a.save(a1);
			
			return ResponseEntity.ok("update");
		}catch (Exception e) {
			throw new AuthorNotFound();
		}
	}
	
	//delete Author Details
	public ResponseEntity<String> deleteAuthor(Long aid){
		try {
			Author a1=a.findById(aid).get();
			List<Book> b1=a1.getBook();
			if(b1!=null) {
				for(Book bb:b1) {
					bb.setAuthor(null);
				}
				b.deleteAll(b1);
			}
			a.deleteById(aid);
			return ResponseEntity.ok("delete");
		}catch(Exception e) {
			throw new AuthorNotFound();
		}
	}
	
	//check the given author is exist or not
	public boolean isAuthorPresent(AuthorDTO author){
		
		List<Author> li= a.findAll();
		for(Author b:li) {
			if(b.getAname().toLowerCase().equals(author.getAname().toLowerCase())) {
				return true;
			}
		}
		return false;
	}
	
}
