package io.github.pactstart.ifabu.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageQueryDto{

    private int pageNum = 1;

    private int pageSize = 10;
}
