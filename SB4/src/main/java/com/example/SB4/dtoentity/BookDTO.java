package com.example.SB4.dtoentity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.SB4.entity.Author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
	
	private Long bid;
	
	@Pattern(regexp = "^[A-Za-z0-9\\s]+$")
	@NotNull
	@Size(min = 3, max = 30)
	private String bname;
	
	private Author author;
	
	@Pattern(regexp = "\\d+")
	@NotEmpty
	@Size(min = 2,max = 4)
	private String price;
}
