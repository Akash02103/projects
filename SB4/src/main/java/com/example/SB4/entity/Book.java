package com.example.SB4.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long bid;
	
	@Pattern(regexp = "^[A-Za-z0-9\\s]+$")
	@NotNull
	@Size(min = 3, max = 30)
	private String bname;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private Author author;
	
	@Pattern(regexp = "\\d+")
	@Size(min = 2,max = 4)
	private String price;
}
