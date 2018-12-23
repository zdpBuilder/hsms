/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.16-log : Database - hsms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hsms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hsms`;

/*Table structure for table `bill` */

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

/*Data for the table `bill` */

insert  into `bill`(`id`,`code`,`transaction`,`supplier_id`,`status`,`updater`,`update_time`,`creater`,`create_time`) values (6,'121',31.5,1,0,'admin','2018-12-23','admin','2018-12-08'),(7,'12121',31.5,2,0,'admin','2018-12-23','admin','2018-12-08'),(8,'PU1545690153135075',1000,4,1,NULL,NULL,'admin','2018-12-22'),(9,'PU3340366067785042',20100,3,0,'admin','2018-12-23','admin','2018-12-23'),(10,'PU0991232874403209',200,2,1,NULL,NULL,'admin','2018-12-22'),(11,'PU5926430044303164',10100,3,1,NULL,NULL,'admin','2018-12-23');

/*Table structure for table `bill_detail` */

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
  `specification` varchar(50) DEFAULT NULL,
  `brand_id` int(11) DEFAULT NULL COMMENT '品牌id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `bill_detail` */

insert  into `bill_detail`(`id`,`bill_code`,`goods_code`,`title`,`purchase_price`,`sale_branch_price`,`sale_box_price`,`branch_num`,`box_num`,`transaction`,`status`,`updater`,`update_time`,`creater`,`create_time`,`brand_title`,`specification`,`brand_id`) values (8,'PU1545690153135075','10101','000',100,100,100,NULL,10,1000,1,NULL,NULL,'admin','2018-12-22','测试1','100',NULL),(10,'PU0991232874403209','1000','10',10,10,10,NULL,10,100,1,NULL,NULL,'admin','2018-12-22','测试1','10',NULL),(11,'PU0991232874403209','101tyrre','10',10,10,10,NULL,10,100,1,NULL,NULL,'admin','2018-12-22','测试1','100',NULL),(12,'PU5926430044303164','12000','10',10,10,10,NULL,10,100,1,NULL,NULL,'admin','2018-12-23','测试1','10',NULL),(13,'PU5926430044303164','12q000','100',100,100,100,NULL,100,10000,1,NULL,NULL,'admin','2018-12-23','测试1','100',NULL);

/*Table structure for table `brand` */

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

/*Data for the table `brand` */

insert  into `brand`(`id`,`title`,`status`,`updater`,`update_time`,`creater`,`create_time`) values (1,'蒙牛2',1,'admin','2018-11-25','admin','2018-11-25'),(2,'蒙牛3',1,'admin','2018-11-25','21232f297a57a5a743894a0e4a801fc3','2018-11-25'),(3,'测试数据',1,'admin','2018-11-25','admin','2018-11-25'),(4,'测试1',1,NULL,NULL,'admin','2018-12-02');

/*Table structure for table `db_backup` */

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

/*Data for the table `db_backup` */

/*Table structure for table `goods` */

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
  `specification` varchar(50) DEFAULT NULL COMMENT '商品规格',
  `status` int(11) DEFAULT NULL COMMENT '状态 0 删除 1 正常',
  `updater` varchar(50) DEFAULT NULL,
  `update_time` varchar(50) DEFAULT NULL,
  `creater` varchar(50) DEFAULT NULL,
  `create_time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

insert  into `goods`(`id`,`goods_code`,`brand_id`,`brand_title`,`title`,`purchase_price`,`sale_branch_price`,`sale_box_price`,`specification`,`status`,`updater`,`update_time`,`creater`,`create_time`) values (1,'121',0,'12121','2121',1,1,1,'1',1,'admin','2018-11-25','1','1'),(2,'GO9843023325659118',0,NULL,'测试',1,1,1,'1',1,'admin','2018-11-25','admin','2018-11-25'),(3,'GO7271181336583385',0,NULL,'你好',10,10,10,'10',1,NULL,NULL,'admin','2018-12-01'),(7,'测试1',2,'测试2','测试1',31.5,2.5,46,'1X24',NULL,'admin',NULL,NULL,NULL),(8,'测试1',2,'测试2','测试1',31.5,2.5,46,'1X24',1,NULL,NULL,'admin','2018-12-08'),(9,'1000000',4,'蒙牛2','10000',1000,1010,1000,'1000',1,'admin',NULL,'admin','2018-12-22'),(10,'1000000',1,'蒙牛2','10000',1000,1010,1000,'1000',1,NULL,NULL,'admin','2018-12-22'),(11,'1000',4,'测试1','10',10,10,10,'10',1,NULL,NULL,'admin','2018-12-22'),(12,'101tyrre',4,'测试1','10',10,10,10,'100',1,NULL,NULL,'admin','2018-12-22'),(13,'12000',4,'测试1','10',10,10,10,'10',1,NULL,NULL,'admin','2018-12-23'),(14,'12q000',4,'测试1','100',100,100,100,'100',1,NULL,NULL,'admin','2018-12-23'),(15,'10000121',4,'测试1','b编辑测试',10,10,10,'100',1,NULL,NULL,'admin','2018-12-23');

/*Table structure for table `store` */

DROP TABLE IF EXISTS `store`;

CREATE TABLE `store` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增 主键',
  `goods_code` varchar(50) DEFAULT NULL COMMENT '商品编码',
  `title` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `remain_branch_num` int(11) DEFAULT NULL COMMENT '剩余商品支数量',
  `sell_branch_num` int(11) DEFAULT NULL COMMENT '销售商品支数量',
  `remain_box_num` int(11) DEFAULT NULL COMMENT '剩余商品箱数量',
  `sell_box_num` int(11) DEFAULT NULL COMMENT '销售商品箱数量',
  `purchase_transaction` double DEFAULT NULL COMMENT '进货总额',
  `sale_transaction` double DEFAULT NULL COMMENT '销售总额',
  `creater` varchar(50) DEFAULT NULL,
  `create_time` varchar(50) DEFAULT NULL,
  `updater` varchar(50) DEFAULT NULL,
  `update_time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `store` */

insert  into `store`(`id`,`goods_code`,`title`,`remain_branch_num`,`sell_branch_num`,`remain_box_num`,`sell_box_num`,`purchase_transaction`,`sale_transaction`,`creater`,`create_time`,`updater`,`update_time`) values (5,'测试1','测试1',0,0,0,0,0,0,'admin','2018-12-08','admin','2018-12-23'),(6,'10101','000',0,0,10,0,1000,0,'admin','2018-12-22',NULL,NULL),(7,'1000000','10000',0,0,0,0,0,0,'admin','2018-12-22','admin','2018-12-23'),(8,'1000','10',0,0,10,0,100,0,'admin','2018-12-22',NULL,NULL),(9,'101tyrre','10',0,0,10,0,100,0,'admin','2018-12-22',NULL,NULL),(10,'12000','10',0,0,10,0,100,0,'admin','2018-12-23',NULL,NULL),(11,'12q000','100',0,0,100,0,10000,0,'admin','2018-12-23',NULL,NULL),(12,'10000121','b编辑测试',0,0,0,0,0,0,'admin','2018-12-23','admin','2018-12-23');

/*Table structure for table `supplier` */

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

/*Data for the table `supplier` */

insert  into `supplier`(`id`,`name`,`address`,`phone`,`status`,`updater`,`update_time`,`creater`,`create_time`) values (1,'测试1','测试1','12345678',1,'admin','2018-11-25',NULL,NULL),(2,'测试2','测试3','12345',1,'admin','2018-11-25','21232f297a57a5a743894a0e4a801fc3','2018-11-25'),(3,'测试3','测试3','123456',1,'admin','2018-11-25','admin','2018-11-25'),(4,'测试5','测试5','12312',1,'admin','2018-11-25','admin','2018-11-25');

/*Table structure for table `sys_user` */

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

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`login_id`,`login_password`,`name`,`phone`,`status`,`updater`,`update_time`,`creater`,`create_time`) values (1,'admin','21232f297a57a5a743894a0e4a801fc3','魏华磊','15833655291',1,'admin','2018-11-24','admin','2019-01-01'),(2,'shy','e10adc3949ba59abbe56e057f20f883e','张三',NULL,0,'admin','2018-11-24','admin','2018-11-24'),(3,'admin2','e10adc3949ba59abbe56e057f20f883e','123456','15833655291',0,'admin','2018-11-24','admin','2018-11-24');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
