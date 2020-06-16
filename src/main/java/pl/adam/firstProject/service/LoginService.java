package pl.adam.firstProject.service;

import org.springframework.stereotype.Service;
import pl.adam.firstProject.dto.LoginRequest;
import pl.adam.firstProject.model.User;
import pl.adam.firstProject.repository.UserRepository;

import java.util.Optional;

@Service
public class LoginService {

    private UserRepository userRepository;

    private User loggedUser;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void logIn(LoginRequest loginRequest) {
        Optional<User> userOptional = userRepository.getBy(loginRequest.getEmail());

        if(userOptional.isEmpty()) {
            throw new LoginServiceException("This email doesn't exists in db","email");
        }
        if(!userOptional.get().getPassword().equals(loginRequest.getPassword())) {
            throw new LoginServiceException("This password doesn't pass to email","password");
        }

        loggedUser = userOptional.get();
        System.out.println("you are logged");
    }

    public User getLoggedUser() {
        if(loggedUser == null) {
            throw new LoginServiceException("This user doesn't exist","password");
        }
        return loggedUser;
    }
}
