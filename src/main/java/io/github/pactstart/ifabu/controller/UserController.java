package io.github.pactstart.ifabu.controller;

import io.github.pactstart.ifabu.component.UserTokenManager;
import io.github.pactstart.ifabu.controller.form.UserAddForm;
import io.github.pactstart.ifabu.controller.form.UserLoginForm;
import io.github.pactstart.ifabu.entity.User;
import io.github.pactstart.ifabu.errorcode.ResponseCode;
import io.github.pactstart.ifabu.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    private final UserTokenManager userTokenManager;

    @ResponseBody
    @RequestMapping("/add")
    public ResponseCode add(@Valid @RequestBody UserAddForm userAddForm) {
        User user = userService.getByEmail(userAddForm.getEmail());
        if(user != null) {
            return ResponseCode.EMAIL_EXIST;
        }
        user = new User();
        user.setEmail(userAddForm.getEmail());
        user.setPassword(passwordEncoder.encode(userAddForm.getPassword()));
        userService.add(user);

        return ResponseCode.SUCCESS;
    }

    @ResponseBody
    @RequestMapping("/login")
    public ResponseCode login(@Valid @RequestBody UserLoginForm userLoginForm) {
        log.info("request data: {}",userLoginForm);
        User user = userService.getByEmail(userLoginForm.getEmail());
        if(user == null) {
            return ResponseCode.EMAIL_NOT_EXIST;
        }
        if(!passwordEncoder.matches(userLoginForm.getPassword(),user.getPassword())) {
            return ResponseCode.PASSWORD_ERROR;
        }
        Map<String,Object> data = new HashMap<>();
        data.put("token",userTokenManager.generateToken(user));
        return ResponseCode.build(data);
    }

}
