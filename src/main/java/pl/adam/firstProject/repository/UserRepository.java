package pl.adam.firstProject.repository;

import pl.adam.firstProject.model.User;

public interface UserRepository {

    void save(User user);
    boolean hasEmail(String email);
}
