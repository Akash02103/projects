package com.example.SB4.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SB4.entity.Book;


@Repository
public interface BookRepo extends JpaRepository<Book, Long> {	
}
