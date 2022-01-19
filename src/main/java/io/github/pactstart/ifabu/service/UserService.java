package io.github.pactstart.ifabu.service;

import io.github.pactstart.ifabu.entity.User;

public interface UserService {

    User getByEmail(String email);

    void add(User user);
}
