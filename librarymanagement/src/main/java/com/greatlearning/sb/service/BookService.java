package com.greatlearning.sb.service;

import java.util.List;

import com.greatlearning.sb.entity.Book;

public interface BookService {
	public List<Book> getAllBooks();
	public void save(Book book);
	public void deleteById(int id);
	public List<Book> search(String bookName, String author);
	public Book getBookById(int id);
	

}
