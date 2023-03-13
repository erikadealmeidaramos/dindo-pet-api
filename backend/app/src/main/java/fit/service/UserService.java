package fit.service;

import fit.exception.DuplicatedUserException;
import fit.exception.UserNotFoundException;
import fit.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
  public void saveUser(User user) throws DuplicatedUserException;

  public User getUserByEmailAndPassword(String email, String password) throws UserNotFoundException;

  public Boolean checkIfUserAlreadyExists(String email, String cpf);
}