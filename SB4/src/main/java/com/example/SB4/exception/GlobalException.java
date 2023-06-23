package com.example.SB4.exception;




import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalException {
	
	//this Exception handling for book
	@ExceptionHandler(value = BookNotFound.class)
	public ResponseEntity<?> BookNotFoundException(){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@ExceptionHandler(value = InsertingBookException.class)
	public ResponseEntity<?> AddBookException(){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
	}
	
	//this for Exception handling for author
	@ExceptionHandler(value = AuthorNotFound.class)
	public ResponseEntity<?> AuthorNotFoundException(){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	//this for Exception handling for try to inserting author into database
	@ExceptionHandler(value = InsertingAuthorException.class)
	public ResponseEntity<?> AddAuthorException(){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
	}
	
	
	//this for Exception handling for book is present already
	@ExceptionHandler(value = BookIsPresentAlready.class)
	public ResponseEntity<?> BookAlreadyPresent(){
		return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).build();
	}
	
	//this for Exception handling for book is present already
	@ExceptionHandler(value = AuthorIsPresentAlready.class)
	public ResponseEntity<?> AuthorAlreadyPresent(){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

}
