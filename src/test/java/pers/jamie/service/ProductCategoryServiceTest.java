package pers.jamie.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductCategoryServiceTest {

    @Autowired
    private ProductCategoryService service;

    @Test
    void getall() {
        service.getall();
    }
}