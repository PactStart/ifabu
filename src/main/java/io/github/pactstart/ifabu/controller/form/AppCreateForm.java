package io.github.pactstart.ifabu.controller.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class AppCreateForm {

    @URL(message = "avatar must be a url format")
    private String avatar;

    @Length(max = 20,message = "app name length must be lower than 20 characters")
    @NotBlank(message = "app name cannot be blank")
    private String name;
}
