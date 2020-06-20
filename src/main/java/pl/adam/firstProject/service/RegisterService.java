package pl.adam.firstProject.service;

import org.springframework.stereotype.Service;
import pl.adam.firstProject.dto.RegisterRequest;
import pl.adam.firstProject.model.User;
import pl.adam.firstProject.repository.UserRepository;

import javax.annotation.PostConstruct;

@Service
public class RegisterService {

    private UserRepository userRepository;

    public RegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    private void addTestUser() {
        User user = new User("trainer11@gmail.com","123");
        userRepository.save(user);
    }

    public void addUser(RegisterRequest registerRequest) {
        validateUnique(registerRequest.getEmail());
        User user = new User(registerRequest.getEmail(), registerRequest.getPassword());
        userRepository.save(user);
    }

    private void validateUnique(String email) {
        if(userRepository.hasEmail(email)) {
            throw new RegisterServiceException("This email exists in db");
        }
    }
}
