package pers.jamie.test;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;

public class test {


    @Test
    void test01(){
        System.out.println(LocalDateTime.now());
        System.out.println(new Date());
    }
}
