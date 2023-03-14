package fit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
@RequestMapping("api/v1/pet")
public class PetController {

  @PostMapping("/")
  public ResponseEntity<?> postUser() {

    return new ResponseEntity<>("restricted message", HttpStatus.CREATED);
  }

}