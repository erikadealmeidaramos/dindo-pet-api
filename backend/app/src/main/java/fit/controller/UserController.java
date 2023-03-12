package fit.controller;

import fit.config.JwtGeneratorInterface;
import fit.exception.UserNotFoundException;
import fit.exception.DuplicatedUserException;
import fit.model.User;
import fit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
@RequestMapping("api/v1/user")
public class UserController {
  private UserService userService;
  private JwtGeneratorInterface jwtGenerator;

  @Autowired
  public UserController(UserService userService, JwtGeneratorInterface jwtGenerator) {
    this.userService = userService;
    this.jwtGenerator = jwtGenerator;
  }

  @PostMapping("/register")
  public ResponseEntity<User> postUser(@RequestBody User user) throws DuplicatedUserException {

    if (userService.checkIfUserAlreadyExists(user.getEmail(), user.getCpf())) {
      throw new DuplicatedUserException("User already exists");
    }

    userService.saveUser(user);
    return new ResponseEntity<User>(user, HttpStatus.CREATED);
  }

  @PostMapping("/login")
  public ResponseEntity<Object> loginUser(@RequestBody User user) throws UserNotFoundException {
    if (user.getEmail() == null || user.getEmail() == "" || user.getPassword() == null
        || user.getPassword() == "") {
      throw new UserNotFoundException("Email or Password is Empty");
    }
    User userData = userService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
    if (userData == null) {
      throw new UserNotFoundException("Email or Password is Invalid");
    }
    return new ResponseEntity<Object>(jwtGenerator.generateToken(userData), HttpStatus.OK);
  }
}