/*
 Navicat Premium Data Transfer

 Source Server         : .
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : social

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 31/12/2020 16:08:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_comment_write
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment_write`;
CREATE TABLE `tb_comment_write`  (
  `write_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(8) NOT NULL COMMENT '发布者',
  `friend_id` int(8) NOT NULL COMMENT '回复给谁',
  `comment_id` int(8) NOT NULL COMMENT '评论表id',
  `content_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '发布内容',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '发布时间',
  PRIMARY KEY (`write_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '评论回复表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_comment_write
-- ----------------------------

-- ----------------------------
-- Table structure for tb_comments
-- ----------------------------
DROP TABLE IF EXISTS `tb_comments`;
CREATE TABLE `tb_comments`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `new_id` int(8) NOT NULL COMMENT '动态表ID',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '评论的内容',
  `content_id` int(8) NOT NULL COMMENT '用户表ID',
  `create_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_comments
-- ----------------------------
INSERT INTO `tb_comments` VALUES (1, 1, '偷偷评论一下', 2, '2020-12-26 22:00:16');
INSERT INTO `tb_comments` VALUES (2, 1, 'KK想Test', 2, NULL);

-- ----------------------------
-- Table structure for tb_friends
-- ----------------------------
DROP TABLE IF EXISTS `tb_friends`;
CREATE TABLE `tb_friends`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '主用户id',
  `friend_id` int(11) NOT NULL COMMENT '好友id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '好友设计表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_friends
-- ----------------------------
INSERT INTO `tb_friends` VALUES (1, 1, 2);
INSERT INTO `tb_friends` VALUES (2, 2, 1);
INSERT INTO `tb_friends` VALUES (3, 1, 3);
INSERT INTO `tb_friends` VALUES (4, 3, 1);
INSERT INTO `tb_friends` VALUES (5, 2, 3);
INSERT INTO `tb_friends` VALUES (6, 3, 2);

-- ----------------------------
-- Table structure for tb_message
-- ----------------------------
DROP TABLE IF EXISTS `tb_message`;
CREATE TABLE `tb_message`  (
  `message_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `user_id` int(8) NOT NULL COMMENT '用户表id',
  `friend_id` int(8) NOT NULL COMMENT '好友表ID',
  `content` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '留言内容',
  `type` int(2) NOT NULL COMMENT '消息类别',
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '消息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_message
-- ----------------------------

-- ----------------------------
-- Table structure for tb_news
-- ----------------------------
DROP TABLE IF EXISTS `tb_news`;
CREATE TABLE `tb_news`  (
  `new_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `user_id` int(8) NOT NULL COMMENT '发布者ID',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `content_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `picture` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `comment_num` int(8) NULL DEFAULT 0,
  `share_num` int(8) NULL DEFAULT 0,
  `type` int(2) NOT NULL COMMENT '动态类型',
  `like` int(8) NULL DEFAULT 0,
  PRIMARY KEY (`new_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '动态表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_news
-- ----------------------------
INSERT INTO `tb_news` VALUES (1, 2, '2020-12-21 21:04:52', 'KK想Test', '', 1, 0, 0, 654);
INSERT INTO `tb_news` VALUES (2, 2, '2020-12-27 00:01:26', 'KKTest', '', 0, 0, 0, 19);
INSERT INTO `tb_news` VALUES (3, 1, '2020-12-08 14:53:16', 'Admin来Test一段吧', NULL, 0, 0, 0, 23);
INSERT INTO `tb_news` VALUES (4, 1, '2020-12-15 14:53:26', '今天心情很好', NULL, 0, 0, 0, 123);
INSERT INTO `tb_news` VALUES (5, 1, '2020-12-12 14:54:07', '幼稚园杀手', NULL, 0, 0, 0, 542);
INSERT INTO `tb_news` VALUES (6, 1, '2020-12-03 14:54:11', '幸存者联盟真的很叼', NULL, 0, 0, 0, 942);
INSERT INTO `tb_news` VALUES (7, 3, '2020-12-03 14:54:15', '雷姆好可爱QAQ', NULL, 0, 0, 0, 12);
INSERT INTO `tb_news` VALUES (8, 3, '2020-12-19 14:54:20', '这是一段测试', NULL, 0, 0, 0, 2);
INSERT INTO `tb_news` VALUES (9, 1, '2020-12-10 14:54:23', '二刺螈', NULL, 0, 0, 0, 231);
INSERT INTO `tb_news` VALUES (10, 1, '2020-12-06 14:54:27', '王者的标签 最强的厂牌 除了我之外还有谁敢认领', NULL, 0, 0, 0, 23);
INSERT INTO `tb_news` VALUES (11, 2, '2020-12-04 14:54:31', '收好你的虚情和假意 别来拍我马屁', NULL, 0, 0, 0, 23);
INSERT INTO `tb_news` VALUES (12, 2, '2020-12-10 14:54:35', '知道自己声音卡哇伊 任何beat都轻易地驾驭', NULL, 0, 0, 0, 112);
INSERT INTO `tb_news` VALUES (13, 2, '2020-12-19 14:54:39', '二刺螈', NULL, 0, 0, 0, 1);
INSERT INTO `tb_news` VALUES (14, 2, '2020-12-17 14:54:42', '我总是可以逢凶化吉 背后的小人我才不屑搭理', NULL, 0, 0, 0, 23);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '邮箱',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `gender` int(2) NULL DEFAULT 1 COMMENT '性别',
  `url` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'admin@admin.com', '123456', 'admin', 0, '/upload/admin@admin.com.jpg');
INSERT INTO `tb_user` VALUES (2, 'kk@kk.com', '123456', 'KK', 1, '/upload/kk@kk.com.jpg');
INSERT INTO `tb_user` VALUES (3, 'thy@thy.com', '123456', 'THY', 1, '/upload/thy@thy.com.jpg');

SET FOREIGN_KEY_CHECKS = 1;
