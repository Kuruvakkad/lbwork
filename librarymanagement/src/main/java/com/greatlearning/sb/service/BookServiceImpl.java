package com.greatlearning.sb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.greatlearning.sb.entity.Book;
import com.greatlearning.sb.repository.BookRepository;

public class BookServiceImpl implements BookService{
	@Autowired
	BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public void save(Book book) {
		bookRepository.save(book);
		
	}

	@Override
	public void deleteById(int id) {
		Book book=getBookById(id);
		bookRepository.delete(book);
		
	}

	@Override
	public List<Book> search(String bookName, String author) {
		// TODO Auto-generated method stub
		return bookRepository.findByBookNameContainsAndAuthorContainsAllIgnoreCase(bookName, author);
	}

	@Override
	public Book getBookById(int id) {
		Optional<Book> optBook= bookRepository.findById(id);
		if(optBook.isPresent()) {
			return optBook.get();
		}
		return null;
		
		
		
	}

}
