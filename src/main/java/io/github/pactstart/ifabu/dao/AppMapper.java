package io.github.pactstart.ifabu.dao;

import io.github.pactstart.ifabu.base.MyMapper;
import io.github.pactstart.ifabu.entity.App;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppMapper extends MyMapper<App> {

    List<App> query(@Param("name") String name);
}