/*
Navicat MySQL Data Transfer

Source Server         : zhs
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : zhs-dev

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-08-12 22:31:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_zhs_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_zhs_user_info`;
CREATE TABLE `t_zhs_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '用户名称（昵称）',
  `user_type` varchar(255) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '用户类型',
  `sex` varchar(10) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT 'sex',
  `account` varchar(255) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '登陆账号',
  `password` varchar(255) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '登陆密码',
  `security` varchar(255) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '盐值',
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '邮箱',
  `phone` varchar(11) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '手机号码',
  `address` varchar(255) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '住址',
  `last_login_time` datetime DEFAULT NULL COMMENT '最近一次登陆时间',
  `is_admin` char(1) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '是否是管理员',
  `is_lock` char(1) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '账号是否锁定',
  `lock_time` datetime DEFAULT NULL COMMENT '账号锁定时间',
  `log_out` char(1) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '账号是否已注销',
  `log_out_time` datetime DEFAULT NULL COMMENT '账号注销时间',
  PRIMARY KEY (`id`),
  KEY `account_index` (`account`),
  KEY `email_index` (`email`),
  KEY `phone_index` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户信息表';
