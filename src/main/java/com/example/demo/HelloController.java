package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private List<String> values = new ArrayList<>();

    @GetMapping("/get")
    public List<String> getValues() {
        return values;
    }

    @PostMapping("/post/{value}")
    public String postHello(@PathVariable String value) {
        values.add(value);
        return "Value added: " + value;
    }

    @PutMapping("/put")
    public String putHello() {
        return "Put Hello!";
    }

    @DeleteMapping("/delete")
    public String deleteHello() {
        return "Delete Hello!";
    }
}