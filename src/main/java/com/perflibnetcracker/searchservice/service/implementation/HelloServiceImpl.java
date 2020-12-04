package com.perflibnetcracker.searchservice.service.implementation;

import com.perflibnetcracker.searchservice.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String getHello() {
        return "Добавили";
    }
}
