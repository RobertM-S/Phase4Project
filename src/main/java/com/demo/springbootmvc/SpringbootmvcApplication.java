package com.demo.springbootmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.demo.springbootmvc.entity.Book;
import com.demo.springbootmvc.service.BookServiceRepo;

@SpringBootApplication
public class SpringbootmvcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootmvcApplication.class, args);
		BookServiceRepo bsr = context.getBean(BookServiceRepo.class);
		Book b1 = new Book("Java", "Shalin", "Learn java ", 230);
		bsr.addNewBook(b1);	

	}

}
