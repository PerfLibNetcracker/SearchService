package com.perflibnetcracker.searchservice.service.implementation;

import com.perflibnetcracker.searchservice.model.Author;
import com.perflibnetcracker.searchservice.model.Book;
import com.perflibnetcracker.searchservice.model.Genre;
import com.perflibnetcracker.searchservice.repository.BookRepository;
import com.perflibnetcracker.searchservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {


    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Author> findAllAuthors() {
        List<Book> books = bookRepository.findAll();
        Set<Author> setOfGenres = new HashSet<>();

        for(Book book: books)
            setOfGenres.add(book.getAuthor());

        return new ArrayList<>(List.copyOf(setOfGenres));
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

}
