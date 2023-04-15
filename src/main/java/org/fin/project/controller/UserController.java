package org.fin.project.controller;

import org.fin.project.entity.User;
import org.fin.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> users() {
        return userService.userList();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable(name = "id") int id) {
        try {
            return userService.getUser(id);
        } catch (IllegalArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getLocalizedMessage());
        }

    }
    @PostMapping
    public User create(@RequestBody User user) {
        try {
            return userService.create(user);
        } catch (IllegalArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getLocalizedMessage());
        }

    }

    @PutMapping
    public User update(@RequestBody User user) {
        try {
            return userService.update(user);
        } catch (IllegalArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, exception.getLocalizedMessage());
        }

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") int id) {
        try {
            userService.delete(id);
        } catch (IllegalArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getLocalizedMessage());
        }
    }
}
