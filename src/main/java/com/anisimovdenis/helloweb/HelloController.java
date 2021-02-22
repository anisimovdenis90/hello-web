package com.anisimovdenis.helloweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String getHello() {
        return "FROM HELLO GET";
    }

    @PostMapping
    public String postHello() {
        return "FROM HELLO POST";
    }
}
