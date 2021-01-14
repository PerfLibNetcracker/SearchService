package com.perflibnetcracker.searchservice.controller;

import com.perflibnetcracker.searchservice.exception.ServiceEmptyResultException;
import com.perflibnetcracker.searchservice.model.Book;
import com.perflibnetcracker.searchservice.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Objects.nonNull;

@RestController
@CrossOrigin
public class RecommendResolverController {
    private final RecommendService recommendService;

    @Autowired
    public RecommendResolverController(RecommendService recommendService) {
        this.recommendService = recommendService;
    }

    @GetMapping("${spring.urlmap}/recommend/popular")
    public List<Book> getPopularBooks(@RequestParam(required = false) String number) throws ServiceEmptyResultException {
        return nonNull(number)
                ? recommendService.getPopularBooks(number)
                : recommendService.getPopularBooks();
    }

    @GetMapping("${spring.urlmap}/recommend/{userId}")
    public List<Book> getRecommends(@PathVariable String userId) throws ServiceEmptyResultException {
        return recommendService.getUserBooks(userId);
    }
}
