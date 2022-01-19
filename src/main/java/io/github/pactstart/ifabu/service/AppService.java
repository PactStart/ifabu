package io.github.pactstart.ifabu.service;

import io.github.pactstart.ifabu.dto.AppQueryDto;
import io.github.pactstart.ifabu.entity.App;
import io.github.pactstart.ifabu.entity.User;
import io.github.pactstart.ifabu.vo.PageResultVo;

import java.util.List;

public interface AppService {

    void add(App app);

    List<App> getAll();

    PageResultVo<App> query(AppQueryDto appQueryDto);
}
