/*
 Navicat Premium Data Transfer

 Source Server         : Injamie·`mysql
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : mmail

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 08/08/2021 16:01:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NULL DEFAULT NULL,
  `quantity` int(11) NULL DEFAULT NULL,
  `cost` float NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `productId`(`product_id`) USING BTREE,
  INDEX `userId`(`user_id`) USING BTREE,
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 423 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (418, 733, 10, 1520, 46, '2020-09-18 12:10:17', '2020-09-18 12:10:17');
INSERT INTO `cart` VALUES (422, 735, 1, 152, 46, '2020-11-08 03:17:02', '2020-11-08 03:17:02');

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_id` int(11) NOT NULL COMMENT '订单主键',
  `product_id` int(11) NOT NULL COMMENT '商品主键',
  `quantity` int(11) NOT NULL COMMENT '数量',
  `cost` float NOT NULL COMMENT '消费',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `PK__EASYBUY___66E1BD8E2F10007B`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 160 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES (146, 147, 743, 1, 589);
INSERT INTO `order_detail` VALUES (147, 148, 743, 1, 589);
INSERT INTO `order_detail` VALUES (148, 149, 734, 6, 912);
INSERT INTO `order_detail` VALUES (149, 150, 763, 15, 128940);
INSERT INTO `order_detail` VALUES (150, 151, 749, 50, 293300);
INSERT INTO `order_detail` VALUES (151, 152, 749, 1, 5866);
INSERT INTO `order_detail` VALUES (152, 153, 733, 7, 1064);
INSERT INTO `order_detail` VALUES (153, 154, 745, 7, 4123);
INSERT INTO `order_detail` VALUES (154, 155, 733, 7, 1064);
INSERT INTO `order_detail` VALUES (155, 156, 734, 1, 152.5);
INSERT INTO `order_detail` VALUES (156, 156, 735, 51, 7752);
INSERT INTO `order_detail` VALUES (157, 157, 752, 1, 589);
INSERT INTO `order_detail` VALUES (158, 157, 738, 1, 45);
INSERT INTO `order_detail` VALUES (159, 157, 735, 1, 152);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户主键',
  `login_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户地址',
  `cost` float NULL DEFAULT NULL COMMENT '总金额',
  `serialnumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 158 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (147, 43, 'jq', '科技路', 589, 'f48d201bfd8fd5c3c8b48b9a41868516', '2020-07-29 10:45:02', '2020-07-29 10:45:02');
INSERT INTO `orders` VALUES (148, 43, 'jq', '科技路', 589, '7fe40a20fe839329a1e16a81531cec43', '2020-07-29 10:46:27', '2020-07-29 10:46:27');
INSERT INTO `orders` VALUES (149, 43, 'jq', '科技路', 912, '48c0d852002101fd70cd2d4f0fdf9fed', '2020-07-29 11:01:49', '2020-07-29 11:01:49');
INSERT INTO `orders` VALUES (150, 43, 'jq', '软件园', 128940, '2744f9b3e01f45eda1076a0ad8cb1d99', '2020-07-29 11:11:01', '2020-07-29 11:11:01');
INSERT INTO `orders` VALUES (151, 43, 'jq', '科技路', 293300, '5b495244c0721d55d74797d8bb5da208', '2020-07-29 11:13:20', '2020-07-29 11:13:20');
INSERT INTO `orders` VALUES (152, 43, 'jq', '科技路', 5866, '9a6cecb4269de8d29e611167956cd9cc', '2020-08-04 02:48:58', '2020-08-04 02:48:58');
INSERT INTO `orders` VALUES (153, 43, 'jq', '科技路', 1064, '25ca040157798749314992089354c1c3', '2020-08-04 02:49:16', '2020-08-04 02:49:16');
INSERT INTO `orders` VALUES (154, 43, 'jq', '科技路', 4123, 'fdaf9ff502cbbc0b423e71293c93c56f', '2020-08-09 01:47:26', '2020-08-09 01:47:26');
INSERT INTO `orders` VALUES (155, 45, 'injamie', '三亚', 1064, 'd66cd932c8af2351bb3f92be7857c479', '2020-08-10 10:54:52', '2020-08-10 10:54:52');
INSERT INTO `orders` VALUES (156, 43, 'jq', '如果好几个饭', 7904, '71198f7b9b0b7ddc5f42e1764f8d0060', '2020-09-18 12:01:52', '2020-09-18 12:01:52');
INSERT INTO `orders` VALUES (157, 43, 'jq', '花旗', 786, 'de41d5301f6ee4d61db304db3e399893', '2020-11-08 03:13:05', '2020-11-08 03:13:05');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `description` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `price` float NOT NULL COMMENT '价格',
  `stock` int(11) NOT NULL COMMENT '库存',
  `categorylevelone_id` int(11) NULL DEFAULT NULL COMMENT '分类1',
  `categoryleveltwo_id` int(11) NULL DEFAULT NULL COMMENT '分类2',
  `categorylevelthree_id` int(11) NULL DEFAULT NULL COMMENT '分类3',
  `file_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名称',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `PK__EASYBUY___94F6E55132E0915F`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 777 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (733, '香奈儿', '好闻的香水！！！', 152, 842, 548, 654, 655, 'baby_1.jpg');
INSERT INTO `product` VALUES (734, '洗面奶', '', 152.5, 0, 548, 654, 655, 'baby_2.jpg');
INSERT INTO `product` VALUES (735, '啫喱水', '', 152, 906, 548, 654, 655, 'baby_3.jpg');
INSERT INTO `product` VALUES (736, '香水', '', 152, 999, 548, 654, 655, 'baby_4.jpg');
INSERT INTO `product` VALUES (737, '香水', '', 152, 111, 548, 654, 655, 'baby_5.jpg');
INSERT INTO `product` VALUES (738, '润肤露', '', 45, 98, 548, 654, 655, 'baby_6.jpg');
INSERT INTO `product` VALUES (739, '洁面装', '', 156, 33, 548, 654, 655, 'bk_2.jpg');
INSERT INTO `product` VALUES (740, '电饭锅', '', 158, 76, 628, 656, 659, 'bk_1.jpg');
INSERT INTO `product` VALUES (741, '婴儿喂奶装', '', 569, 100, 632, 637, 653, 'bk_3.jpg');
INSERT INTO `product` VALUES (742, '坚果套餐', '', 158, 1000, 660, 661, 662, 'bk_4.jpg');
INSERT INTO `product` VALUES (743, '超甜蜜崭', '', 589, 993, 660, 661, 663, 'bk_5.jpg');
INSERT INTO `product` VALUES (744, '华为2566', '', 589, 1000, 670, 671, 672, 'de1.jpg');
INSERT INTO `product` VALUES (745, '荣耀3C', '', 589, 73, 670, 671, 672, 'de2.jpg');
INSERT INTO `product` VALUES (746, '小米手环', '', 963, 98, 670, 674, 675, 'de3.jpg');
INSERT INTO `product` VALUES (747, '华为2265', '', 896, 1000, 670, 671, 673, 'de4.jpg');
INSERT INTO `product` VALUES (748, '越南坚果', '', 520, 0, 660, 661, 662, 'de5.jpg');
INSERT INTO `product` VALUES (749, '日本进口马桶', '', 5866, 43, 628, 657, 0, 'food_1.jpg');
INSERT INTO `product` VALUES (750, '联想Y系列', '', 569, 894, 670, 690, 691, 'food_2.jpg');
INSERT INTO `product` VALUES (751, '脑白金1号', '', 589, 999, 676, 677, 680, 'food_3.jpg');
INSERT INTO `product` VALUES (752, '莫里斯按', '', 589, 992, 676, 678, 0, 'food_4.jpg');
INSERT INTO `product` VALUES (753, '三鹿好奶粉', '', 859, 86, 676, 679, 0, 'food_5.jpg');
INSERT INTO `product` VALUES (754, '儿童牛奶', '', 5896, 89, 676, 679, 0, 'food_6.jpg');
INSERT INTO `product` VALUES (755, '软沙发', '', 8596, 99, 628, 696, 0, 'food_b1.jpg');
INSERT INTO `product` VALUES (756, '收纳盒', '', 5966, 100, 628, 696, 0, 'food_b2.jpg');
INSERT INTO `product` VALUES (757, '洗衣液', '', 58, 1000, 628, 696, 0, 'food_r.jpg');
INSERT INTO `product` VALUES (758, '红短沙发', '', 596, 113, 628, 696, 0, 'fre_1.jpg');
INSERT INTO `product` VALUES (759, '新西兰奶粉', '', 5896, 100, 676, 679, 0, 'fre_2.jpg');
INSERT INTO `product` VALUES (760, '婴儿车', '', 11000, 100, 681, 682, 687, 'fre_3.jpg');
INSERT INTO `product` VALUES (761, '夏款婴儿车', '', 963, 95, 681, 682, 688, 'fre_4.jpg');
INSERT INTO `product` VALUES (762, '抗压旅行箱', '', 569, 1000, 681, 683, 685, 'fre_5.jpg');
INSERT INTO `product` VALUES (763, '透明手提箱', '', 8596, 1027, 681, 683, 684, 'fre_6.jpg');
INSERT INTO `product` VALUES (764, '婴儿果粉', '', 5896, 999, 660, 661, 662, 'milk_1.jpg');
INSERT INTO `product` VALUES (765, '椰子粉', '', 5963, 1000, 660, 661, 662, 'milk_2.jpg');
INSERT INTO `product` VALUES (766, '坚果蛋糕', '', 200, 94, 660, 661, 663, 'milk_3.jpg');
INSERT INTO `product` VALUES (767, '编制手提箱', '', 5896, 1000, 681, 682, 688, 'milk_4.jpg');
INSERT INTO `product` VALUES (768, '纸箱', '', 5896, 3, 681, 682, 687, 'milk_5.jpg');
INSERT INTO `product` VALUES (769, '健胃液', '', 152, 1000, 676, 679, 0, 'milk_6.jpg');
INSERT INTO `product` VALUES (770, '联想NTC', '', 8596, 100, 670, 671, 673, 'milk_7.jpg');
INSERT INTO `product` VALUES (771, '香水1', NULL, 100, 100, 548, 654, 655, 'milk_8.jpg');
INSERT INTO `product` VALUES (772, '香水2', NULL, 100, 100, 548, 654, 655, 'pro1.jpg');
INSERT INTO `product` VALUES (773, '香水3', NULL, 100, 100, 548, 654, 655, 'pro2.jpg');
INSERT INTO `product` VALUES (774, '香水4', NULL, 100, 100, 548, 654, 655, 'pro3.jpg');
INSERT INTO `product` VALUES (775, '香水5', NULL, 100, 100, 548, 654, 655, 'pro4.jpg');
INSERT INTO `product` VALUES (776, '香水6', NULL, 1, 1, 548, 654, 655, 'pro5.jpg');

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `parent_id` int(11) NOT NULL COMMENT '父级目录id',
  `type` int(11) NULL DEFAULT NULL COMMENT '级别(1:一级 2：二级 3：三级)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `PK__EASYBUY___9EC2A4E236B12243`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 697 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES (548, '化妆品', 0, 1);
INSERT INTO `product_category` VALUES (628, '家用商品', 0, 1);
INSERT INTO `product_category` VALUES (654, '面部护理', 548, 2);
INSERT INTO `product_category` VALUES (655, '少女派', 654, 3);
INSERT INTO `product_category` VALUES (656, '餐具', 628, 2);
INSERT INTO `product_category` VALUES (657, '卫具', 628, 2);
INSERT INTO `product_category` VALUES (658, '叉子', 656, 3);
INSERT INTO `product_category` VALUES (659, '锅', 656, 3);
INSERT INTO `product_category` VALUES (660, '进口食品', 0, 1);
INSERT INTO `product_category` VALUES (661, '零食/糖果/巧克力', 660, 2);
INSERT INTO `product_category` VALUES (662, '坚果', 661, 3);
INSERT INTO `product_category` VALUES (663, '蜜饯', 661, 3);
INSERT INTO `product_category` VALUES (669, '孕期教育', 546, 3);
INSERT INTO `product_category` VALUES (670, '电子商品', 0, 1);
INSERT INTO `product_category` VALUES (671, '手机', 670, 2);
INSERT INTO `product_category` VALUES (672, '华为手机', 671, 3);
INSERT INTO `product_category` VALUES (673, '联想手机', 671, 3);
INSERT INTO `product_category` VALUES (674, '手环', 670, 2);
INSERT INTO `product_category` VALUES (675, '小米手环', 674, 3);
INSERT INTO `product_category` VALUES (676, '保健食品', 0, 1);
INSERT INTO `product_category` VALUES (677, '老年保健品', 676, 2);
INSERT INTO `product_category` VALUES (678, '中年营养品', 676, 2);
INSERT INTO `product_category` VALUES (679, '儿童保健品', 676, 2);
INSERT INTO `product_category` VALUES (680, '脑白金', 677, 3);
INSERT INTO `product_category` VALUES (681, '箱包', 0, 1);
INSERT INTO `product_category` VALUES (682, '旅行箱', 681, 2);
INSERT INTO `product_category` VALUES (683, '手提箱', 681, 2);
INSERT INTO `product_category` VALUES (684, '大型', 683, 3);
INSERT INTO `product_category` VALUES (685, '小型', 683, 3);
INSERT INTO `product_category` VALUES (686, '中型', 683, 3);
INSERT INTO `product_category` VALUES (687, '大型', 682, 3);
INSERT INTO `product_category` VALUES (688, '中型', 682, 3);
INSERT INTO `product_category` VALUES (689, '小型', 682, 3);
INSERT INTO `product_category` VALUES (690, '电脑', 670, 2);
INSERT INTO `product_category` VALUES (691, '联想电脑', 690, 3);
INSERT INTO `product_category` VALUES (692, '刀叉', 656, 3);
INSERT INTO `product_category` VALUES (693, '碗筷', 656, 3);
INSERT INTO `product_category` VALUES (696, '客厅专用', 628, 2);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `login_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录名',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `gender` int(11) NOT NULL DEFAULT 1 COMMENT '性别(1:男 0：女)',
  `identity_code` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `email` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `PK__EASYBUY___C96109CC3A81B327`(`login_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (43, 'jq', '钟意', '123123', 1, '61058120009009788X', '111@163.com', '13567890987', '3.jpg', '2020-05-22 15:08:35', '2020-05-22 15:08:35');
INSERT INTO `user` VALUES (45, 'injamie', '刘宇帆', '95279527', 1, '610202199709200076', '13324680913@qq.com', '13321658956', NULL, '2020-08-10 10:54:20', '2020-08-10 10:54:20');
INSERT INTO `user` VALUES (46, 'LW123', '老王', 'LAOWANG123', 1, '123123123123123123', '123123@136.com', '13115643698', NULL, '2020-09-18 12:09:16', '2020-09-18 12:09:16');

-- ----------------------------
-- Table structure for user_address
-- ----------------------------
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户主键',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `isdefault` int(11) NULL DEFAULT 0 COMMENT '是否是默认地址（1:是 0否）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_address
-- ----------------------------
INSERT INTO `user_address` VALUES (11, 10, '北京市海淀区大有庄', '朋友家', 0, '2019-06-03 02:32:39', '2019-06-03 02:32:39');
INSERT INTO `user_address` VALUES (49, 43, '科技路', '公司', 0, '2020-05-18 15:55:24', '2020-09-18 12:01:52');
INSERT INTO `user_address` VALUES (50, 43, '软件园', '公司', 0, '2020-05-21 23:11:07', '2020-07-29 11:13:20');
INSERT INTO `user_address` VALUES (51, 43, '花旗', '公司', 1, '2020-07-25 01:14:19', '2020-11-08 03:13:04');
INSERT INTO `user_address` VALUES (53, 43, '小寨', '公司', 0, '2020-07-29 01:28:04', '2020-07-29 11:06:20');
INSERT INTO `user_address` VALUES (54, 45, '三亚', '', 1, '2020-08-10 10:54:52', '2020-08-10 10:54:52');
INSERT INTO `user_address` VALUES (55, 43, '如果好几个饭', '符合回复', 0, '2020-09-18 04:01:52', '2020-11-08 03:13:04');

SET FOREIGN_KEY_CHECKS = 1;
