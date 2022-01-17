package io.pactstart.ifabu.controller;

import io.pactstart.ifabu.entity.User;
import io.pactstart.ifabu.errorcode.ResponseCode;
import io.pactstart.ifabu.form.UserAddForm;
import io.pactstart.ifabu.form.UserLoginForm;
import io.pactstart.ifabu.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseBody
    @RequestMapping("/add")
    public ResponseCode add(@Valid @RequestBody UserAddForm userAddForm, BindingResult br) {
        User user = userService.getByEmail(userAddForm.getEmail());
        if(user != null) {
            return ResponseCode.EMAIL_EXIST;
        }
        user = new User();
        user.setEmail(userAddForm.getEmail());
        user.setPassword(userAddForm.getPassword());
        userService.add(user);

        return ResponseCode.SUCCESS;
    }

    @ResponseBody
    @RequestMapping("/login")
    public ResponseCode login(@Valid @RequestBody UserLoginForm userLoginForm, BindingResult br) {
        log.info("request data: {}",userLoginForm);
        User user = userService.getByEmail(userLoginForm.getEmail());
        if(user == null) {
            return ResponseCode.EMAIL_NOT_EXIST;
        }
        if(!user.getPassword().equals(userLoginForm.getPassword())) {
            return ResponseCode.PASSWORD_ERROR;
        }
        return ResponseCode.SUCCESS;
    }

}
