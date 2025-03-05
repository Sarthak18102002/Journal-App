package org.edigest.mysecondproject.Service;

import org.edigest.mysecondproject.Entity.User;
import org.edigest.mysecondproject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;  // Use instance variable correctly

    public void saveEntry(User user) {
        userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(String id) {
        return userRepository.findById(id);  // Use the instance variable
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);  // Use the instance variable
    }

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
