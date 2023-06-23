package com.example.SB4.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SB4.entity.Author;


@Repository
public interface AuthorRepo extends JpaRepository<Author, Long>{
}
