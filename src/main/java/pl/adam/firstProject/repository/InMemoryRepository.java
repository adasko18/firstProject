package pl.adam.firstProject.repository;

import org.springframework.stereotype.Component;
import pl.adam.firstProject.model.User;

import java.util.HashMap;
import java.util.Map;

@Component
public class InMemoryRepository implements UserRepository {

    private Map<String,User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getEmail(),user);
        System.out.println(users);
    }

    @Override
    public boolean hasEmail(String email) {
        return users.containsKey(email);
    }
}
