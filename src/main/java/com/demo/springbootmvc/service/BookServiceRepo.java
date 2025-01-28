package com.demo.springbootmvc.service;
import com.demo.springbootmvc.entity.Book;
import com.demo.springbootmvc.repo.BookRepo;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BookServiceRepo {
	@Autowired
	private BookRepo bookRepo;
	public long getTotalBookCount(){
		return bookRepo.count();
	}
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	public Book addNewBook(Book book){
		if(bookRepo.existsById(book.getBookid()))
			throw new EntityExistsException("Cannot add "+book.getBookid()+" already exists");
		return bookRepo.save(book);
	}
	public Book updateBook(Book book){
		if(!bookRepo.existsById(book.getBookid()))
			throw new EntityNotFoundException("cannot update "+book.getBookid()+" does not exist");
		return bookRepo.save(book);
	}
	public boolean deleteBook(int id){
		if(!bookRepo.existsById(id))
			throw new EntityNotFoundException("cannot delete "+id+" does not exist");
		bookRepo.deleteById(id);
		return true;
	}
	public List<Book> getBooksByAuthor(String author){
		return bookRepo.findByAuthor(author);
	}
	public Book getBookById(int id){
		if(!bookRepo.existsById(id))
			throw new EntityNotFoundException(id+" not found");
		return bookRepo.findById(id).get();
	}
}
