package com.perflibnetcracker.searchservice.service.implementation;

import com.perflibnetcracker.searchservice.model.Author;
import com.perflibnetcracker.searchservice.model.Book;
import com.perflibnetcracker.searchservice.model.Genre;
import com.perflibnetcracker.searchservice.repository.AuthorRepository;
import com.perflibnetcracker.searchservice.repository.BookRepository;
import com.perflibnetcracker.searchservice.repository.GenreRepository;
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
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
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
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Author> findAllAuthors() {
        List<Book> books = bookRepository.findAll();
        Set<Author> setOfGenres = new HashSet<>();

        for (Book book : books) {
            setOfGenres.add(book.getAuthor());
        }

        return new ArrayList<>(List.copyOf(setOfGenres));
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findAllByAuthor(String authorName) {
        Author author = authorRepository.findOneByFullName(authorName);
        return bookRepository.findAllByAuthor(author);
    }

    @Override
    public List<Book> findAllByGenre(String genreName) {
        Genre genre = genreRepository.findOneByName(genreName);
        return bookRepository.findAllByGenre(genre);
    }

    @Override
    public void addViewToBook(Book book) {
        book.setTotalViews(book.getTotalViews() + 1);
        bookRepository.save(book);
    }
}
