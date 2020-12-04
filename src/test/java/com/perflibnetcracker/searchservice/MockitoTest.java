package com.perflibnetcracker.searchservice;

import com.perflibnetcracker.searchservice.service.implementation.HelloServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {
    private final String testHello = "WorldHello!";
    @Mock
    private HelloServiceImpl helloService;

    @Test
    public void test() {
        Mockito.when(helloService.getHello()).thenReturn(testHello);
        assertEquals(testHello, helloService.getHello());
    }
}
