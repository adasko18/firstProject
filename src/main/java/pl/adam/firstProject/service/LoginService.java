package pl.adam.firstProject.service;

import org.springframework.stereotype.Service;
import pl.adam.firstProject.dto.Login;
import pl.adam.firstProject.dto.Register;
import pl.adam.firstProject.model.User;
import pl.adam.firstProject.repository.UserRepository;

import java.util.Optional;

@Service
public class LoginService {

    private UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void logIn(Login login) {
        Optional<User> userOptional = userRepository.getBy(login.getEmail());

        if(userOptional.isEmpty()) {
            throw new LoginServiceException("This email doesn't exists in db","email");
        }
        if(!userOptional.get().getPassword().equals(login.getPassword())) {
            throw new LoginServiceException("This password doesn't pass to email","password");
        }
        System.out.println("you are logged");
    }
}
