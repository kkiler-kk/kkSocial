/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : social

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 31/05/2021 22:45:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_comm_like
-- ----------------------------
DROP TABLE IF EXISTS `tb_comm_like`;
CREATE TABLE `tb_comm_like`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int NOT NULL COMMENT '用户id',
  `comm_id` int NOT NULL COMMENT '评论id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`, `comm_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户评论like表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_comments
-- ----------------------------
DROP TABLE IF EXISTS `tb_comments`;
CREATE TABLE `tb_comments`  (
  `comment_id` int NOT NULL AUTO_INCREMENT,
  `new_id` int NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '评论的内容',
  `content_id` int NOT NULL COMMENT '用户表ID',
  `create_date` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `like` int NULL DEFAULT 0,
  `write_id` int NULL DEFAULT NULL COMMENT '父级评论id',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '评论表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_fans
-- ----------------------------
DROP TABLE IF EXISTS `tb_fans`;
CREATE TABLE `tb_fans`  (
  `fans_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int NOT NULL COMMENT '用户id',
  `fan_id` int NOT NULL COMMENT '粉丝id',
  PRIMARY KEY (`fans_id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`, `fan_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '粉丝表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_friends
-- ----------------------------
DROP TABLE IF EXISTS `tb_friends`;
CREATE TABLE `tb_friends`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int NOT NULL COMMENT '主用户id',
  `friend_id` int NOT NULL COMMENT '好友id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`, `friend_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '好友设计表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_group_chat
-- ----------------------------
DROP TABLE IF EXISTS `tb_group_chat`;
CREATE TABLE `tb_group_chat`  (
  `chat_id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '群聊昵称',
  `count` int NULL DEFAULT 0 COMMENT '群聊总数',
  `create_date` date NULL DEFAULT NULL COMMENT '创群时间',
  `user_id` int NOT NULL COMMENT '创群人ID',
  `url` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name_id` int NOT NULL,
  PRIMARY KEY (`chat_id`) USING BTREE,
  UNIQUE INDEX `name_id`(`name_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '分组群聊' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_group_members
-- ----------------------------
DROP TABLE IF EXISTS `tb_group_members`;
CREATE TABLE `tb_group_members`  (
  `members_id` int NOT NULL AUTO_INCREMENT COMMENT '群成员id',
  `group_id` int NOT NULL COMMENT '分群ID',
  `user_id` int NOT NULL COMMENT '用户id',
  `create_date` date NULL DEFAULT NULL COMMENT '加群时间',
  PRIMARY KEY (`members_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '群员表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_like
-- ----------------------------
DROP TABLE IF EXISTS `tb_like`;
CREATE TABLE `tb_like`  (
  `like_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int NOT NULL COMMENT '用户id',
  `new_id` int NOT NULL COMMENT '动态ID',
  PRIMARY KEY (`like_id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`, `new_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户点赞表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_message
-- ----------------------------
DROP TABLE IF EXISTS `tb_message`;
CREATE TABLE `tb_message`  (
  `message_id` int NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `user_id` int NOT NULL COMMENT '用户表id',
  `friend_id` int NOT NULL COMMENT '好友表ID',
  `content` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '留言内容',
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '消息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_msg
-- ----------------------------
DROP TABLE IF EXISTS `tb_msg`;
CREATE TABLE `tb_msg`  (
  `msg_id` int NOT NULL AUTO_INCREMENT COMMENT '聊天ID',
  `reception_id` int NOT NULL COMMENT '接收者_id',
  `user_id` int NOT NULL COMMENT '发送者Id',
  `content_text` varchar(551) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '发送内容',
  `type` int NULL DEFAULT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`msg_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '消息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_news
-- ----------------------------
DROP TABLE IF EXISTS `tb_news`;
CREATE TABLE `tb_news`  (
  `new_id` int NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `user_id` int NOT NULL COMMENT '发布者ID',
  `create_date` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `content_text` varchar(555) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `picture` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `comment_num` int NULL DEFAULT 0,
  `share_num` int NULL DEFAULT 0,
  `like` int NULL DEFAULT 0,
  `tag` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`new_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '动态表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '邮箱',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `gender` int NULL DEFAULT 1 COMMENT '性别',
  `url` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `personal_signature` varchar(125) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '个性签名',
  `create_date` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE,
  UNIQUE INDEX `name_2`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
