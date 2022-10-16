package com.greatlearning.sb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.sb.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	public List<Book>findByBookNameContainsAndAuthorContainsAllIgnoreCase(String bookname,String author);
	

}
