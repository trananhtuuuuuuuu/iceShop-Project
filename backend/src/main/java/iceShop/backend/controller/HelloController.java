package iceShop.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/hello")
public class HelloController {
  @GetMapping
  public ResponseEntity<Object> hello(){
    return ResponseEntity.ok("Hello from hello controller");
  }
}
