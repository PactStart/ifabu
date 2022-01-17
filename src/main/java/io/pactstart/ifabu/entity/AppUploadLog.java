package io.pactstart.ifabu.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "app_upload_log")
public class AppUploadLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 应用id
     */
    @Column(name = "app_id")
    private Integer appId;

    /**
     * 平台：1：Android，2：iOS
     */
    private Integer platform;

    /**
     * 序号
     */
    private Integer seq;

    /**
     * 版本号
     */
    private String version;

    /**
     * 内部版本号
     */
    @Column(name = "innner_version")
    private String innnerVersion;

    /**
     * 文件大小，单位：字节
     */
    @Column(name = "file_size")
    private Long fileSize;

    /**
     * 文件地址
     */
    @Column(name = "file_url")
    private String fileUrl;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建者id
     */
    @Column(name = "user_id")
    private Integer userId;

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