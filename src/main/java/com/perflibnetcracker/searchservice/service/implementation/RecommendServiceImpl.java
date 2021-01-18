package com.perflibnetcracker.searchservice.service.implementation;

import com.perflibnetcracker.searchservice.dto.RecommendReceivingItemDTO;
import com.perflibnetcracker.searchservice.exception.ServiceEmptyResultException;
import com.perflibnetcracker.searchservice.model.Book;
import com.perflibnetcracker.searchservice.repository.BookRepository;
import com.perflibnetcracker.searchservice.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
public class RecommendServiceImpl implements RecommendService {
    @Value("${spring.recommend.url}")
    private String recommendServiceUrl;

    private final RestTemplate restTemplate;
    private final BookRepository bookRepository;

    @Autowired
    public RecommendServiceImpl(RestTemplate restTemplate, BookRepository bookRepository) {
        this.restTemplate = restTemplate;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getPopularBooks() throws ServiceEmptyResultException {
        ResponseEntity<List<RecommendReceivingItemDTO>> response =
                restTemplate.exchange(
                        recommendServiceUrl + "/popular",
                        HttpMethod.GET,
                        null,
                        createParameterizedTypeReference());
        return getBooksByResponseDtos(response);
    }

    @Override
    public List<Book> getUserBooks(String userId) throws ServiceEmptyResultException {
        ResponseEntity<List<RecommendReceivingItemDTO>> response =
                restTemplate.exchange(
                        recommendServiceUrl + "/recommends/" + userId,
                        HttpMethod.GET,
                        null,
                        createParameterizedTypeReference());
        return getBooksByResponseDtos(response);
    }

    @Override
    public List<Book> getPopularBooks(String amount) throws ServiceEmptyResultException {
        ResponseEntity<List<RecommendReceivingItemDTO>> response =
                restTemplate.exchange(
                        recommendServiceUrl + "/popular?number={number}",
                        HttpMethod.GET,
                        null,
                        createParameterizedTypeReference(),
                        amount);
        return getBooksByResponseDtos(response);
    }

    private List<Book> getBooksByResponseDtos(ResponseEntity<List<RecommendReceivingItemDTO>> response) throws ServiceEmptyResultException {
        List<RecommendReceivingItemDTO> result = response.getBody();
        if (isNull(result)) {
            throw new ServiceEmptyResultException("Recommend service didn't return body");
        }
        List<Long> bookIds = result
                .stream()
                .map(dto -> Long.parseLong(dto.getItemId()))
                .collect(Collectors.toList());
        return bookRepository.findBookByIdIn(bookIds);
    }

    // На Windows проект не соберётся без этого, на Linux всё нормально (прод на docker linux)
    private ParameterizedTypeReference<List<RecommendReceivingItemDTO>> createParameterizedTypeReference() {
        return new ParameterizedTypeReference<>() {
        };
    }
}
