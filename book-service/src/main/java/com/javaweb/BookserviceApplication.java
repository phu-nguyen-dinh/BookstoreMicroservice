package com.javaweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BookServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);

    }

    // 👇 Controller test API
    @RestController
    public static class HelloController {

        @GetMapping("/books/hello")
        public String hello() {
            return "📚 Hello from Book Service!";
        }
    }
}
