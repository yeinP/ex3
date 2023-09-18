package org.zerock.ex3.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.ex3.web.dto.HelloResPonseDto;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResPonseDto helloDto (@RequestParam("name")String name, @RequestParam("amount") int amount) {
        return new HelloResPonseDto(name, amount);
    }
}
