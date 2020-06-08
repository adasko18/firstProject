package pl.adam.firstProject.repository;

import pl.adam.firstProject.model.User;

import java.util.Optional;

public interface UserRepository {

    void save(User user);
    boolean hasEmail(String email);
    Optional<User> getBy(String email);
}
