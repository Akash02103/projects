package com.example.SB4.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Author")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long aid;
	
	@Pattern(regexp = "^[A-Za-z\\s]+$")
	@NotNull
	@Size(min = 3, max = 30)
	private String aname;
	
	@Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
	@NotNull
	private String aemail;
	
	@OneToMany(mappedBy = "author")
	@JsonManagedReference
	private List<Book> book;
	
}
