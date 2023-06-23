package com.example.SB4.dtoentity;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.SB4.entity.Book;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {
	
	private Long aid;
	
	@Pattern(regexp = "^[A-Za-z0-9\\s]+$")
	@NotEmpty
	@Size(min = 3, max = 30)
	private String aname;
	
	@Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
	@NotEmpty
	private String aemail;
	
	private List<Book> book;
}
