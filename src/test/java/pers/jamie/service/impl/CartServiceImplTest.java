package pers.jamie.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.jamie.service.CartService;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CartServiceImplTest {
    @Autowired
    private CartService service;


    @Test
    void findByUserid() {
        service.findByUserid(43).forEach(System.out::println);
    }
}