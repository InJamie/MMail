package pers.jamie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("pers.jamie.mapper")
public class MmaildemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MmaildemoApplication.class, args);
    }

}
