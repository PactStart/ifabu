package io.pactstart.ifabu.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class App {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 应用key
     */
    @Column(name = "app_key")
    private String appKey;

    /**
     * 应用图标
     */
    private String avatar;

    /**
     * 应用名称
     */
    private String name;

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