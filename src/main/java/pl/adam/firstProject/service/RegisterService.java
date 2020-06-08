package pl.adam.firstProject.service;

import org.springframework.stereotype.Service;
import pl.adam.firstProject.dto.Register;
import pl.adam.firstProject.model.User;
import pl.adam.firstProject.repository.UserRepository;

@Service
public class RegisterService {

    private UserRepository userRepository;

    public RegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(Register register) {
        validateUnique(register.getEmail());
        User user = new User(register.getEmail(),register.getPassword());
        userRepository.save(user);
    }

    private void validateUnique(String email) {
        if(userRepository.hasEmail(email)) {
            throw new RegisterServiceException("This email exists in db");
        }
    }
}
