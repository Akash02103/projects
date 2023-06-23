package com.example.SB4.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.example.SB4.dtoentity.AuthorDTO;
import com.example.SB4.entity.Author;


public class AuthorDtoConverter {
	public Author DtotoEntity(AuthorDTO dto) {
		Author b=new Author();
		if(dto!=null) {
			BeanUtils.copyProperties(dto, b);
		}
		
		return b;
	}
	
	public AuthorDTO EntitytoDTO(Author b) {
		AuthorDTO dto=new AuthorDTO();
		if(b!=null) {
			BeanUtils.copyProperties(b, dto);
		}
		return dto;
	}
	
	public List<AuthorDTO> EntitytoListDTO(List<Author> b){
		return b.stream().map(x -> EntitytoDTO(x)).collect(Collectors.toList());
	}
}
