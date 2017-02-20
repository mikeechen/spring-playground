package com.example;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

  @GetMapping("/")
  public String helloWorld() {
    return "Hello from Spring!";
  }

  @PostMapping("/hello")
  public String hello() {
    return "Posted!";
  }

  @PatchMapping("/hello")
  public String helloPatch() {
    return "Patched!";
  }

  @DeleteMapping("/hello")
  public String helloDelete() {
    return "Deleted!";
  }
}
