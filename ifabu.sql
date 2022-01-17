/*
Navicat MySQL Data Transfer

Source Server         : dm-test
Source Server Version : 50734
Source Host           : dm-uat.cmvyzw29ey0p.ap-southeast-1.rds.amazonaws.com:3306
Source Database       : ifabu

Target Server Type    : MYSQL
Target Server Version : 50734
File Encoding         : 65001

Date: 2022-01-17 08:02:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for app
-- ----------------------------
DROP TABLE IF EXISTS `app`;
CREATE TABLE `app` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_key` varchar(8) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '应用key',
  `avatar` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '应用图标',
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '应用名称',
  `create_at` bigint(20) NOT NULL COMMENT '创建时间',
  `update_at` bigint(20) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='应用';

-- ----------------------------
-- Table structure for app_upload_log
-- ----------------------------
DROP TABLE IF EXISTS `app_upload_log`;
CREATE TABLE `app_upload_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_id` int(11) NOT NULL COMMENT '应用id',
  `platform` int(11) NOT NULL COMMENT '平台：1：Android，2：iOS',
  `seq` int(11) NOT NULL COMMENT '序号',
  `version` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '版本号',
  `innner_version` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '内部版本号',
  `file_size` bigint(20) NOT NULL COMMENT '文件大小，单位：字节',
  `file_url` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '文件地址',
  `remark` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '备注',
  `user_id` int(11) NOT NULL COMMENT '创建者id',
  `create_at` bigint(20) NOT NULL COMMENT '创建时间',
  `update_at` bigint(20) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='应用';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '邮箱',
  `password` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码，加盐',
  `create_at` bigint(20) NOT NULL COMMENT '创建时间',
  `update_at` bigint(20) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户';
