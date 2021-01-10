package com.perflibnetcracker.searchservice.controller;

import com.perflibnetcracker.searchservice.model.Book;
import com.perflibnetcracker.searchservice.model.Genre;
import com.perflibnetcracker.searchservice.service.BookService;
import com.perflibnetcracker.searchservice.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins = "${spring.frontend.url}")
public class SearchController {

    private final BookService bookService;
    private final GenreService genreService;

    @Autowired
    public SearchController(BookService bookService, GenreService genreService) {
        this.genreService = genreService;
        this.bookService = bookService;
    }

    @GetMapping("${spring.urlmap}/find-all")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("${spring.urlmap}/find-all-genres")
    public List<Genre> findAllGenres() {
        return genreService.findAll();
    }

    @GetMapping("${spring.urlmap}/book-create")
    public String createBookForm(Book book) {
        return "new_book";
    }

    @PostMapping("${spring.urlmap}/book-create")
    public String createBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/api/service/search/find-all";
    }

    @GetMapping("${spring.urlmap}/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable("id") Long id) {
        Book book = bookService.findById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("${spring.urlmap}/book-delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return "redirect:/api/service/search/find-all";
    }

    @GetMapping("${spring.urlmap}/book-update/{id}")
    public String updateBookForm(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book-update";
    }

    @PostMapping("${spring.urlmap}/book-update")
    public String updateBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/api/service/search/find-all";
    }
}
