package io.github.pactstart.ifabu.service.impl;

import io.github.pactstart.ifabu.service.UserService;
import io.github.pactstart.ifabu.dao.UserMapper;
import io.github.pactstart.ifabu.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public User getByEmail(String email) {
        return userMapper.selectOneByEmail(email);
    }

    @Override
    public void add(User user) {
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
        userMapper.insert(user);
    }
}
