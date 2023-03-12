package fit.service;

import fit.exception.UserNotFoundException;
import fit.model.User;
import fit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  private UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void saveUser(User user) {
    userRepository.save(user);
  }

  @Override
  public User getUserByEmailAndPassword(String email, String password) throws UserNotFoundException {
    User user = userRepository.findByUserEmailAndPassword(email, password);
    if (user == null) {
      throw new UserNotFoundException("Invalid email and password");
    }
    return user;
  }

  @Override
  public Boolean checkIfUserAlreadyExists(String email, String cpf) {
    return userRepository.checkIfUserAlreadyExists(email, cpf);
  }
}