package com.greatlearning.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greatlearning.sb.entity.Book;
import com.greatlearning.sb.service.BookService;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
	@Autowired
	BookService bookService;

	@RequestMapping("/list")
	public String getAllBooks(Model model) {
		List<Book> books = bookService.getAllBooks();
		model.addAttribute("Books", books);
		return "list-Books";

	}

	@RequestMapping("/showFormForAdd")
	public String formForAdd(Model model) {
		Book book = new Book();
		model.addAttribute("Book", book);
		return "Book-form";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String formForUpdate(Model model,@RequestParam("bookId") int bookId) {
		Book book = new Book();
		model.addAttribute("Book", book);
		return "Book-form";
	}
	

	@RequestMapping("/delete")
	public String deleteBook(@RequestParam("bookId") int bookId) {
		bookService.deleteById(bookId);
		return "redirect:/books/list";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("Book") Book book) {
		bookService.save(book);
		return "redirect:/books/list";
	}
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam("name") String name, @RequestParam("author") String author,Model model) {
		if(!name.isBlank() || !author.isBlank()) {
			List<Book> books = bookService.search(name, author);
			model.addAttribute("Books", books);
			return "list-Books";
		}
		return "redirect:/books/list";
	}
	
}
