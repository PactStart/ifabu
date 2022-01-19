package io.github.pactstart.ifabu.controller.form;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageForm {

    private int pageNum = 1;

    private int pageSize = 10;

}
