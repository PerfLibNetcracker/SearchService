package com.perflibnetcracker.searchservice.service;

import com.perflibnetcracker.searchservice.exception.ServiceEmptyResultException;
import com.perflibnetcracker.searchservice.model.Book;

import java.util.List;

public interface RecommendService {
    List<Book> getPopularBooks(String amount) throws ServiceEmptyResultException;

    List<Book> getPopularBooks() throws ServiceEmptyResultException;

    List<Book> getUserBooks(String userId) throws ServiceEmptyResultException;
}
