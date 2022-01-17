package io.pactstart.ifabu.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@ToString
@Setter
@Getter
public class UserLoginForm {

    @Email(message = "invalid email format")
    private String email;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(.{8,20})$",message = "invalid password")
    private String password;
}
