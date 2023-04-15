package org.fin.project.service;

import org.fin.project.entity.User;

import java.util.List;

public interface UserService {
    List<User> userList();

    User getUser(int id);

    User create(User user);

    User update(User user);

    void delete(int id);


}
