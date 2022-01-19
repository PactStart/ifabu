package io.github.pactstart.ifabu.component;

import io.github.pactstart.ifabu.entity.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class UserTokenManager {

    private Map<String, User> tokenUserMap = new HashMap<>();

    public String generateToken(User user) {
        String token = UUID.randomUUID().toString();
        tokenUserMap.put(token,user);
        return token;
    }

    public User getUserByToken(String token) {
        return tokenUserMap.get(token);
    }
}
