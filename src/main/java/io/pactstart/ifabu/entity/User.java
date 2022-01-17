package io.pactstart.ifabu.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码，加盐
     */
    private String password;

    /**
     * 创建时间
     */
    @Column(name = "create_at")
    private Long createAt;

    /**
     * 更新时间
     */
    @Column(name = "update_at")
    private Long updateAt;
}