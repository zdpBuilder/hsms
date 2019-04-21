/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : hsms

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-01-16 12:23:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bill`
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增',
  `code` varchar(50) DEFAULT NULL COMMENT '商品编号',
  `transaction` double DEFAULT NULL COMMENT '交易金额',
  `supplier_id` int(11) DEFAULT NULL COMMENT '供应商id',
  `status` int(11) DEFAULT NULL COMMENT '状态 0 删除 1 进货 2售货',
  `updater` varchar(50) DEFAULT NULL,
  `update_time` varchar(50) DEFAULT NULL,
  `creater` varchar(50) DEFAULT NULL,
  `create_time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES ('6', '121', '31.5', '1', '0', 'admin', '2018-12-23', 'admin', '2018-12-08');
INSERT INTO `bill` VALUES ('7', '12121', '31.5', '2', '0', 'admin', '2018-12-23', 'admin', '2018-12-08');
INSERT INTO `bill` VALUES ('8', 'PU1545690153135075', '1000', '4', '1', null, null, 'admin', '2018-12-22');
INSERT INTO `bill` VALUES ('9', 'PU3340366067785042', '20100', '3', '0', 'admin', '2018-12-23', 'admin', '2018-12-23');
INSERT INTO `bill` VALUES ('10', 'PU0991232874403209', '200', '2', '1', null, null, 'admin', '2018-12-22');
INSERT INTO `bill` VALUES ('11', 'PU5926430044303164', '10100', '3', '1', null, null, 'admin', '2018-12-23');

-- ----------------------------
-- Table structure for `bill_detail`
-- ----------------------------
DROP TABLE IF EXISTS `bill_detail`;
CREATE TABLE `bill_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增',
  `bill_code` varchar(50) DEFAULT NULL COMMENT '账单编码',
  `goods_code` varchar(50) DEFAULT NULL COMMENT '商品id',
  `title` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `purchase_price` double DEFAULT NULL COMMENT '商品进价（按每箱）',
  `sale_branch_price` double DEFAULT NULL COMMENT '商品支售价',
  `sale_box_price` double DEFAULT NULL COMMENT '商品箱售价',
  `branch_num` int(11) DEFAULT NULL COMMENT '支数量',
  `box_num` int(11) DEFAULT NULL COMMENT '箱数量',
  `transaction` double DEFAULT NULL COMMENT '总金额',
  `status` int(11) DEFAULT NULL COMMENT '状态 0 删除 1 正常',
  `updater` varchar(50) DEFAULT NULL,
  `update_time` varchar(50) DEFAULT NULL,
  `creater` varchar(50) DEFAULT NULL,
  `create_time` varchar(50) DEFAULT NULL,
  `brand_title` varchar(50) DEFAULT NULL,
  `specification` int(11) DEFAULT NULL,
  `brand_id` int(11) DEFAULT NULL COMMENT '品牌id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bill_detail
-- ----------------------------
INSERT INTO `bill_detail` VALUES ('8', 'PU1545690153135075', '10101', '000', '100', '100', '100', null, '10', '1000', '1', null, null, 'admin', '2018-12-22', '测试1', null, null);
INSERT INTO `bill_detail` VALUES ('10', 'PU0991232874403209', '1000', '10', '10', '10', '10', null, '10', '100', '1', null, null, 'admin', '2018-12-22', '测试1', null, null);
INSERT INTO `bill_detail` VALUES ('11', 'PU0991232874403209', '101tyrre', '10', '10', '10', '10', null, '10', '100', '1', null, null, 'admin', '2018-12-22', '测试1', null, null);
INSERT INTO `bill_detail` VALUES ('12', 'PU5926430044303164', '12000', '10', '10', '10', '10', null, '10', '100', '1', null, null, 'admin', '2018-12-23', '测试1', null, null);
INSERT INTO `bill_detail` VALUES ('13', 'PU5926430044303164', '12q000', '100', '100', '100', '100', null, '100', '10000', '1', null, null, 'admin', '2018-12-23', '测试1', null, null);

-- ----------------------------
-- Table structure for `brand`
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(50) DEFAULT NULL COMMENT '品牌名称',
  `status` int(11) DEFAULT NULL COMMENT '状态 0 删除 1 正常',
  `updater` varchar(50) DEFAULT NULL,
  `update_time` varchar(50) DEFAULT NULL,
  `creater` varchar(50) DEFAULT NULL,
  `create_time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of brand
-- ----------------------------
INSERT INTO `brand` VALUES ('1', '蒙牛2', '1', 'admin', '2018-11-25', 'admin', '2018-11-25');
INSERT INTO `brand` VALUES ('2', '蒙牛3', '1', 'admin', '2018-11-25', '21232f297a57a5a743894a0e4a801fc3', '2018-11-25');
INSERT INTO `brand` VALUES ('3', '测试数据', '1', 'admin', '2018-11-25', 'admin', '2018-11-25');
INSERT INTO `brand` VALUES ('4', '测试1', '1', null, null, 'admin', '2018-12-02');

-- ----------------------------
-- Table structure for `db_backup`
-- ----------------------------
DROP TABLE IF EXISTS `db_backup`;
CREATE TABLE `db_backup` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(50) DEFAULT NULL COMMENT '备份名称',
  `comment` varchar(50) DEFAULT NULL COMMENT '备份说明',
  `backup_path` varchar(50) DEFAULT NULL COMMENT '备份路径',
  `creater` varchar(50) DEFAULT NULL COMMENT '备份者',
  `create_time` varchar(50) DEFAULT NULL COMMENT '备份时间',
  `restorer` varchar(50) DEFAULT NULL COMMENT '恢复者',
  `restore_time` varchar(50) DEFAULT NULL COMMENT '恢复时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_backup
-- ----------------------------

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增',
  `goods_code` varchar(50) DEFAULT NULL COMMENT '商品编码',
  `brand_id` int(11) DEFAULT NULL COMMENT '品牌id',
  `brand_title` varchar(50) DEFAULT NULL COMMENT '品牌名称',
  `title` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `purchase_price` double DEFAULT NULL COMMENT '商品进价（按每箱）',
  `sale_branch_price` double DEFAULT NULL COMMENT '商品支售价',
  `sale_box_price` double DEFAULT NULL COMMENT '商品箱售价',
  `status` int(11) DEFAULT NULL COMMENT '状态 0 删除 1 正常',
  `updater` varchar(50) DEFAULT NULL,
  `update_time` varchar(50) DEFAULT NULL,
  `creater` varchar(50) DEFAULT NULL,
  `specification` int(11) DEFAULT NULL,
  `create_time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '121', '0', '12121', '2121', '1', '1', '1', '1', 'admin', '2018-11-25', '1', null, '1');
INSERT INTO `goods` VALUES ('2', 'GO9843023325659118', '0', null, '测试', '1', '1', '1', '1', 'admin', '2018-11-25', 'admin', null, '2018-11-25');
INSERT INTO `goods` VALUES ('3', 'GO7271181336583385', '0', null, '你好', '10', '10', '10', '1', null, null, 'admin', null, '2018-12-01');
INSERT INTO `goods` VALUES ('7', '测试1', '2', '测试2', '测试1', '31.5', '2.5', '46', null, 'admin', null, null, null, null);
INSERT INTO `goods` VALUES ('8', '测试1', '2', '测试2', '测试1', '31.5', '2.5', '46', '1', null, null, 'admin', null, '2018-12-08');
INSERT INTO `goods` VALUES ('9', '1000000', '4', '蒙牛2', '10000', '1000', '1010', '1000', '1', 'admin', null, 'admin', null, '2018-12-22');
INSERT INTO `goods` VALUES ('10', '1000000', '1', '蒙牛2', '10000', '1000', '1010', '1000', '1', null, null, 'admin', null, '2018-12-22');
INSERT INTO `goods` VALUES ('11', '1000', '4', '测试1', '10', '10', '10', '10', '1', null, null, 'admin', null, '2018-12-22');
INSERT INTO `goods` VALUES ('12', '101tyrre', '4', '测试1', '10', '10', '10', '10', '1', null, null, 'admin', null, '2018-12-22');
INSERT INTO `goods` VALUES ('13', '12000', '4', '测试1', '10', '10', '10', '10', '1', null, null, 'admin', null, '2018-12-23');
INSERT INTO `goods` VALUES ('14', '12q000', '4', '测试1', '100', '100', '100', '100', '1', null, null, 'admin', null, '2018-12-23');
INSERT INTO `goods` VALUES ('15', '10000121', '4', '测试1', 'b编辑测试', '10', '10', '10', '1', null, null, 'admin', null, '2018-12-23');

-- ----------------------------
-- Table structure for `store`
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增 主键',
  `goods_code` varchar(50) DEFAULT NULL COMMENT '商品编码',
  `title` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `remain_branch_num` int(11) DEFAULT NULL COMMENT '剩余商品支数量',
  `sell_branch_num` int(11) DEFAULT '0' COMMENT '销售商品支数量',
  `remain_box_num` int(11) DEFAULT NULL COMMENT '剩余商品箱数量',
  `sell_box_num` int(11) DEFAULT '0' COMMENT '销售商品箱数量',
  `purchase_transaction` double DEFAULT NULL COMMENT '进货总额',
  `sale_transaction` double DEFAULT NULL COMMENT '销售总额',
  `creater` varchar(50) DEFAULT NULL,
  `create_time` varchar(50) DEFAULT NULL,
  `updater` varchar(50) DEFAULT NULL,
  `update_time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES ('5', '测试1', '测试1', '0', '0', '0', '0', '0', '0', 'admin', '2018-12-08', 'admin', '2018-12-23');
INSERT INTO `store` VALUES ('6', '10101', '000', '0', '0', '10', '0', '1000', '0', 'admin', '2018-12-22', null, null);
INSERT INTO `store` VALUES ('7', '1000000', '10000', '0', '0', '0', '0', '0', '0', 'admin', '2018-12-22', 'admin', '2018-12-23');
INSERT INTO `store` VALUES ('8', '1000', '10', '0', '0', '10', '0', '100', '0', 'admin', '2018-12-22', null, null);
INSERT INTO `store` VALUES ('9', '101tyrre', '10', '0', '0', '10', '0', '100', '0', 'admin', '2018-12-22', null, null);
INSERT INTO `store` VALUES ('10', '12000', '10', '0', '0', '10', '0', '100', '0', 'admin', '2018-12-23', null, null);
INSERT INTO `store` VALUES ('11', '12q000', '100', '0', '0', '100', '0', '10000', '0', 'admin', '2018-12-23', null, null);
INSERT INTO `store` VALUES ('12', '10000121', 'b编辑测试', '0', '0', '0', '0', '0', '0', 'admin', '2018-12-23', 'admin', '2018-12-23');

-- ----------------------------
-- Table structure for `supplier`
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '客户姓名/企业名称',
  `address` varchar(50) DEFAULT NULL COMMENT '联系地址',
  `phone` varchar(50) NOT NULL COMMENT '电话',
  `status` int(11) DEFAULT NULL COMMENT '状态 0 删除 1 正常',
  `updater` varchar(50) DEFAULT NULL,
  `update_time` varchar(50) DEFAULT NULL,
  `creater` varchar(50) DEFAULT NULL,
  `create_time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('1', '测试1', '测试1', '12345678', '1', 'admin', '2018-11-25', null, null);
INSERT INTO `supplier` VALUES ('2', '测试2', '测试3', '12345', '1', 'admin', '2018-11-25', '21232f297a57a5a743894a0e4a801fc3', '2018-11-25');
INSERT INTO `supplier` VALUES ('3', '测试3', '测试3', '123456', '1', 'admin', '2018-11-25', 'admin', '2018-11-25');
INSERT INTO `supplier` VALUES ('4', '测试5', '测试5', '12312', '1', 'admin', '2018-11-25', 'admin', '2018-11-25');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `login_id` varchar(50) NOT NULL COMMENT '登录账号',
  `login_password` varchar(50) NOT NULL COMMENT '登录密码',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `status` int(50) DEFAULT NULL COMMENT '状态 0 删除 1 管理员 2 销售员  3 采购员',
  `updater` varchar(50) DEFAULT NULL COMMENT '更新者',
  `update_time` varchar(50) DEFAULT NULL COMMENT '更新时间',
  `creater` varchar(50) DEFAULT NULL COMMENT '创建者',
  `create_time` varchar(50) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '魏华磊', '15833655291', '1', 'admin', '2018-11-24', 'admin', '2019-01-01');
INSERT INTO `sys_user` VALUES ('2', 'shy', 'e10adc3949ba59abbe56e057f20f883e', '张三', null, '0', 'admin', '2018-11-24', 'admin', '2018-11-24');
INSERT INTO `sys_user` VALUES ('3', 'admin2', 'e10adc3949ba59abbe56e057f20f883e', '123456', '15833655291', '0', 'admin', '2018-11-24', 'admin', '2018-11-24');
