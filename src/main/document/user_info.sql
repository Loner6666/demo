/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : 127.0.0.1:3306
 Source Schema         : gmall

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : 65001

 Date: 14/03/2020 12:31:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
	`id` BIGINT ( 20 ) NOT NULL AUTO_INCREMENT COMMENT '编号',
	`login_name` VARCHAR ( 200 ) DEFAULT NULL COMMENT '用户名称',
	`nick_name` VARCHAR ( 200 ) DEFAULT NULL COMMENT '用户昵称',
	`passwd` VARCHAR ( 200 ) DEFAULT NULL COMMENT '用户密码',
	`name` VARCHAR ( 200 ) DEFAULT NULL COMMENT '用户姓名',
	`phone_num` VARCHAR ( 200 ) DEFAULT NULL COMMENT '手机号',
	`email` VARCHAR ( 200 ) DEFAULT NULL COMMENT '邮箱',
	`head_img` VARCHAR ( 200 ) DEFAULT NULL COMMENT '头像',
	`user_level` VARCHAR ( 200 ) DEFAULT NULL COMMENT '用户级别',
PRIMARY KEY ( `id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '用户表';

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'atguigu', 'Atguigu', '202cb962ac59075b964b07152d234b70', '尚硅谷', '11111', 'atguigu.com', '1', '1');
INSERT INTO `user_info` VALUES (2, 'admin', 'Administrator', '202cb962ac59075b964b07152d234b70', 'Admin', '2222', 'upd@qq.com', '2', '2');
INSERT INTO `user_info` VALUES (3, 'zhangsan', '张三', '202cb962ac59075b964b07152d234b70', '张三', '333', 'atguigu.com', '3', '3');
INSERT INTO `user_info` VALUES (7, '用户3', '昵称1', '202cb962ac59075b964b07152d234b70', '张三123', '44444', 'atguigu.com', '4', '4');
INSERT INTO `user_info` VALUES (8, '用户4', '昵称2', '202cb962ac59075b964b07152d234b70', '张三124', '44445', 'upd@qq.com', '5', '5');
INSERT INTO `user_info` VALUES (9, '用户5', '昵称3', '202cb962ac59075b964b07152d234b70', '张三125', '44446', 'atguigu.com', '6', '6');

SET FOREIGN_KEY_CHECKS = 1;
