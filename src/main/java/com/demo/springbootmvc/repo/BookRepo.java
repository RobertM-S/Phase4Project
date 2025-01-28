package com.demo.springbootmvc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springbootmvc.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {
	
	List<Book> findByAuthor(String author);
	
}
