package io.pactstart.ifabu.service;

import io.pactstart.ifabu.entity.User;

public interface UserService {

    User getByEmail(String email);

    void add(User user);
}
