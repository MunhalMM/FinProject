package org.fin.project.service;

import org.fin.project.entity.User;
import org.fin.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> userList() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Incorrect Id");
        }
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User create(User user) {
        if (user.getName().isEmpty() || user.getLogin().isEmpty() ||
                userRepository.findById(user.getId()).isPresent()) {
            throw new IllegalArgumentException("Entered data ist incorrect");
        }
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        if (userRepository.findById(user.getId()).isEmpty()) {
            throw new IllegalArgumentException("You entered incorrect Id");
        }
        int userId = user.getId();
        User entity = userRepository.findById(userId).orElse(null);
        if (entity != null) {
            entity.setName(entity.getName());
            entity.setLogin(entity.getLogin());
            entity.setPassword(entity.getPassword());
            userRepository.save(entity);
        }
        return entity;
    }

    @Override
    public void delete(int id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("You entered incorrect Id");
        }
        userRepository.deleteById(id);
    }
}
