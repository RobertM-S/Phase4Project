package com.demo.springbootmvc.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.springbootmvc.entity.Book;
import com.demo.springbootmvc.service.BookServiceRepo;

@Controller
public class BookController {
	
	@Autowired
	private BookServiceRepo bookDatabase;
	
	@GetMapping("/book")
	public String handler(Model model) {
		List<Book> book = new ArrayList<>();
		book = bookDatabase.getAllBooks();
		System.out.println(book);
//		Book book = new Book("Banana", "Cavendish", "Gros Michel", 0.99);
		model.addAttribute("book", book);
		return "book";
	}
	
	@GetMapping("/add")
	public String getBookForm() {
		return "bookform";
	}	
	
	@PostMapping("/add")
	public String addNewBook(@ModelAttribute Book book) {
		System.out.println(book);
		try {
			bookDatabase.addNewBook(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:book";
	}
	
	@GetMapping("/edit")
	  public String getBookById(@RequestParam("bookid") Integer bookid, Model model) {
		System.out.println(bookid + " ===================================");
	    System.out.println("Id to edit"+bookid); 
	    Book book =  bookDatabase.getBookById(bookid); 
	    model.addAttribute("book", book); 
	   return "editform"; 
	   
	  } 
	
	@PostMapping("/edit") 
	  public String updateBooks(@ModelAttribute Book book) { 
		System.out.println(book + "¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
	   System.out.println("Edit Book "+book); 
	   try {
		   bookDatabase.updateBook(book);
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
	   return "redirect:book";  
	  } 
	
	@GetMapping("/delete/{bookid}") 
	public String getBookById(@PathVariable("bookid") String id) { 
		System.out.println("Id to delete "+id); 
		   try {
			   bookDatabase.deleteBook(Integer.parseInt(id));
		   } catch (Exception e) {
			   e.printStackTrace();
		   }
		   return "redirect:/book";  
		  } 
	
	@GetMapping("/search")
	public String searchByTitle(@RequestParam("author") String author, Model model) {
		List<Book> book = new ArrayList<>();
		book = bookDatabase.getBooksByAuthor(author);
		System.out.println(book);
//		Book book = new Book("Banana", "Cavendish", "Gros Michel", 0.99);
		model.addAttribute("book", book);
		return "book";
	}
	
}

