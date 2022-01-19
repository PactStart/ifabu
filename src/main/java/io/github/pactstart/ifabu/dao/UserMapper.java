package io.github.pactstart.ifabu.dao;

import io.github.pactstart.ifabu.base.MyMapper;
import io.github.pactstart.ifabu.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends MyMapper<User> {

    @Select("select * from user where email = #{email}")
    User selectOneByEmail(@Param("email") String email);
}