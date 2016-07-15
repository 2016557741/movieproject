/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.0.27-community-nt : Database - graduation
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`graduation` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `graduation`;

/*Table structure for table `admins` */

DROP TABLE IF EXISTS `admins`;

CREATE TABLE `admins` (
  `ADMINS_ID` int(32) NOT NULL auto_increment,
  `ADMINS_NAME` varchar(20) NOT NULL default '',
  `ADMINS_PASS` varchar(20) NOT NULL default '',
  PRIMARY KEY  (`ADMINS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admins` */

insert  into `admins`(`ADMINS_ID`,`ADMINS_NAME`,`ADMINS_PASS`) values (1,'admin','admin');

/*Table structure for table `affair` */

DROP TABLE IF EXISTS `affair`;

CREATE TABLE `affair` (
  `AFFAIR_ID` int(32) NOT NULL auto_increment COMMENT '主键',
  `AFFAIR_COMMENT` varchar(500) default NULL COMMENT '事件内容',
  `AFFAIR_DATE` datetime default NULL COMMENT '事件时间',
  `USERINFO_ID` int(32) default NULL COMMENT '创建人ID',
  `FAMILY_ID` int(32) default NULL COMMENT '家族ID',
  PRIMARY KEY  (`AFFAIR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `affair` */

insert  into `affair`(`AFFAIR_ID`,`AFFAIR_COMMENT`,`AFFAIR_DATE`,`USERINFO_ID`,`FAMILY_ID`) values (1,'家族聚餐：a在厦门理工学院','2014-04-12 10:10:11',1,1),(2,'香山一日游：b联系人电话123123111','2014-04-13 05:00:00',1,1),(3,'环岛路跑步c','2014-05-15 08:00:00',2,1),(4,'看日出 联系小伟：121301920','2014-05-14 05:40:00',1,1),(6,'今天答辩 联系人13213123','2014-05-21 23:57:00',1,1);

/*Table structure for table `album` */

DROP TABLE IF EXISTS `album`;

CREATE TABLE `album` (
  `ALBUM_ID` int(32) NOT NULL auto_increment COMMENT '主键',
  `ALBUM_NAME` varchar(50) default NULL COMMENT '相册名称',
  `ALBUM_COMMENT` varchar(500) default NULL COMMENT '相册介绍',
  `FAMILY_ID` int(32) default NULL COMMENT '所属家族ID',
  `USERINFO_ID` int(32) default NULL COMMENT '创建人ID',
  `CREATE_DATE` datetime default NULL COMMENT '创建时间',
  PRIMARY KEY  (`ALBUM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `album` */

insert  into `album`(`ALBUM_ID`,`ALBUM_NAME`,`ALBUM_COMMENT`,`FAMILY_ID`,`USERINFO_ID`,`CREATE_DATE`) values (1,'杂图','放了点杂图',1,1,'2014-05-10 00:00:00'),(2,'服装','放了点服装',1,1,'2014-05-10 00:00:00'),(3,'家具','放了点家具',1,1,'2014-05-10 00:00:00'),(4,'测试','11',1,1,'2014-05-12 20:41:13'),(5,'ceshi','asa',1,1,'2014-05-19 11:23:18');

/*Table structure for table `anniversary` */

DROP TABLE IF EXISTS `anniversary`;

CREATE TABLE `anniversary` (
  `ANNIVERSARY_ID` int(32) NOT NULL auto_increment COMMENT '主键',
  `ANNIVERSARY_NAME` varchar(50) default NULL COMMENT '纪念日名称',
  `ANNIVERSARY_COMMENT` varchar(500) default NULL COMMENT '纪念日介绍',
  `ANNIVERSARY_DATE` datetime default NULL COMMENT '纪念日时间',
  `USERINFO_ID` int(32) default NULL COMMENT '用户ID',
  `FAMILY_ID` int(32) default NULL COMMENT '家族ID',
  PRIMARY KEY  (`ANNIVERSARY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `anniversary` */

insert  into `anniversary`(`ANNIVERSARY_ID`,`ANNIVERSARY_NAME`,`ANNIVERSARY_COMMENT`,`ANNIVERSARY_DATE`,`USERINFO_ID`,`FAMILY_ID`) values (1,'生日','1991年12月24日早上08点30分，一个健康活泼的男婴在产房里呱呱落地了，那就是我。你们知道吗?我爸爸也是在这家医院里出生的。','1991-12-24 00:00:00',1,1),(2,'小学','开学了，小三角龙丁丁背着书包高高兴兴地走向了学校。在半路上，他碰见了小翼龙刷刷。他们两个好朋友就一起走到了学校。','1997-07-07 00:00:00',1,1),(3,'初中','终于上初中了,终于成了初中生了,虽然只是初一。 　 ','2004-08-07 00:00:00',1,1),(4,'高中',' 军训是之前的事情,高中第一天就是搬书上课,课堂上老师自我介绍,讲一下他这门课怎么学。第一天还会有同学的自我介绍。','2007-08-07 00:00:00',1,1),(5,'大学','大学第一天报道，天气那个热啊，宿舍怎么没空调啊，厕所很宽敞，洗澡的地方很狭小，已经开始想念家里的浴室了。 ','2010-09-30 00:00:00',1,1),(6,'第一次拿筷子','第一次拿筷子 O(∩_∩)O~','1994-08-08 00:00:00',1,1),(9,'打灯泡','和小伙伴黄河打路灯','2002-05-10 00:00:00',1,1),(11,'纪念日1','纪念日1','2012-08-08 00:00:00',3,3),(12,'生日','小欣的生日66','2014-05-10 00:00:00',4,4),(14,'生日','小明的生日','1994-08-14 00:00:00',2,1);

/*Table structure for table `comments` */

DROP TABLE IF EXISTS `comments`;

CREATE TABLE `comments` (
  `COMMENTS_ID` int(32) NOT NULL auto_increment COMMENT '主键',
  `COMMENTS_INFO` varchar(200) default NULL COMMENT '评论内容',
  `CREATE_DATE` datetime default NULL COMMENT '评论时间',
  `MESSAGES_ID` int(32) NOT NULL COMMENT '所属消息ID',
  `USERINFO_ID` int(32) NOT NULL COMMENT '评论人ID',
  PRIMARY KEY  (`COMMENTS_ID`),
  KEY `MESSAGES_ID` (`MESSAGES_ID`),
  KEY `USERS_ID` (`USERINFO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comments` */

/*Table structure for table `family` */

DROP TABLE IF EXISTS `family`;

CREATE TABLE `family` (
  `FAMILY_ID` int(32) NOT NULL auto_increment COMMENT '主键',
  `FAMILY_NAME` varchar(50) default NULL COMMENT '家族名称',
  `FAMILY_COMMENT` varchar(500) default NULL COMMENT '家族介绍',
  `USERINFO_ID` int(32) default NULL COMMENT '创建人ID',
  `CREATE_DATE` datetime default NULL COMMENT '创建时间',
  PRIMARY KEY  (`FAMILY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `family` */

insert  into `family`(`FAMILY_ID`,`FAMILY_NAME`,`FAMILY_COMMENT`,`USERINFO_ID`,`CREATE_DATE`) values (1,NULL,NULL,1,'2014-05-08 13:49:05'),(2,NULL,NULL,2,'2014-05-09 19:13:05'),(3,NULL,NULL,3,'2014-05-09 20:15:48'),(4,NULL,NULL,4,'2014-05-09 20:26:37'),(5,NULL,NULL,5,'2014-05-10 14:22:50'),(6,NULL,NULL,6,'2014-05-13 23:23:46'),(7,NULL,NULL,36,'2014-05-20 20:52:42'),(8,NULL,NULL,38,'2014-05-20 22:52:06'),(9,NULL,NULL,40,'2014-05-20 22:57:38'),(10,NULL,NULL,42,'2014-05-20 23:13:37'),(11,NULL,NULL,53,'2014-05-20 23:58:24');

/*Table structure for table `messages` */

DROP TABLE IF EXISTS `messages`;

CREATE TABLE `messages` (
  `MESSAGES_ID` int(32) NOT NULL auto_increment COMMENT '主键',
  `MESSAGES_INFO` varchar(400) default NULL COMMENT '信息是内容',
  `CREATE_DATE` datetime default NULL COMMENT '创建时间',
  `MESSAGES_COMMENTNUM` int(8) default '0' COMMENT '评论数',
  `MESSAGES_AGREENUM` int(8) default '0' COMMENT '赞的数量',
  `MESSAGES_STATUS` int(1) NOT NULL default '1' COMMENT '是否可见:0不可见,1可见',
  `USERINFO_ID` int(32) default NULL COMMENT '用户ID',
  PRIMARY KEY  (`MESSAGES_ID`),
  KEY `USERS_ID` (`MESSAGES_STATUS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `messages` */

/*Table structure for table `pictures` */

DROP TABLE IF EXISTS `pictures`;

CREATE TABLE `pictures` (
  `PICTURES_ID` int(32) NOT NULL auto_increment COMMENT '主键',
  `PICTURES_URL` varchar(200) default NULL COMMENT '照片UTL地址',
  `PICTURES_TYPE` int(1) default NULL COMMENT '0头像1信息2相册',
  `PICTURES_COMMENT` varchar(500) default NULL COMMENT '备注',
  `CREATE_DATE` datetime default NULL COMMENT '创建时间',
  `USERINFO_ID` int(32) NOT NULL COMMENT '所属创建用户ID',
  `MESSAGES_ID` int(32) default NULL COMMENT '所属消息ID',
  `ALBUM_ID` int(32) default NULL COMMENT '所属相册ID',
  PRIMARY KEY  (`PICTURES_ID`),
  KEY `MESSAGES_ID` (`MESSAGES_ID`),
  KEY `USERS_ID` (`USERINFO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pictures` */

insert  into `pictures`(`PICTURES_ID`,`PICTURES_URL`,`PICTURES_TYPE`,`PICTURES_COMMENT`,`CREATE_DATE`,`USERINFO_ID`,`MESSAGES_ID`,`ALBUM_ID`) values (1,'1.jpg',2,'我很喜欢','2014-04-14 00:00:00',1,NULL,1),(2,'4.jpg',2,'好图','2014-04-15 00:00:00',1,NULL,1),(3,'5.jpg',2,'啊啊啊啊','2014-04-16 00:00:00',1,NULL,1),(4,'7.jpg',2,'发个图玩玩','2014-04-17 00:00:00',1,NULL,1),(5,'2.jpg',2,'服装1','2014-04-11 00:00:00',1,NULL,2),(6,'6.jpg',2,'服装2','2014-04-12 00:00:00',1,NULL,2),(7,'8.jpg',2,'服装3','2014-04-13 00:00:00',2,NULL,2),(8,'9.jpg',2,'服装4','2014-04-14 00:00:00',2,NULL,2),(9,'3.jpg',2,'家具1','2014-04-15 00:00:00',1,NULL,3),(10,'10.jpg',2,'家具2','2014-04-16 00:00:00',2,NULL,3),(11,'11.jpg',2,'家具3','2014-04-19 00:00:00',3,NULL,3),(12,'12.jpg',2,'家具4','2014-04-10 00:00:00',4,NULL,3),(13,'934b7b5592314ef4952e3c4b3b83c065.png',2,'测试1','2014-05-12 20:41:46',1,NULL,4),(14,'sago.jpg',0,NULL,'2014-05-14 17:30:46',1,NULL,NULL),(15,'ec3a82f1f2084a1e95608d5ffaf8994d.png',2,'测试','2014-05-14 22:50:43',1,NULL,4),(17,'179acb5e90714acd825f73106bb68fd1_small.jpg',0,NULL,'2014-05-15 11:51:13',2,NULL,NULL),(18,'646b7a1ced8546b09547868b4cfd2c23_small.jpg',0,NULL,'2014-05-15 11:51:50',2,NULL,NULL),(19,'454bfcae3a3f485da2e7beabb45f53f2_small.png',0,NULL,'2014-05-15 11:54:30',1,NULL,NULL),(20,'e7c9e1f514d74ee1813faaa169f60412_small.jpg',0,NULL,'2014-05-15 11:55:21',1,NULL,NULL),(21,'53d2a1b369f24bb987cbebae46ea73bc_small.jpg',0,NULL,'2014-05-15 11:57:19',1,NULL,NULL),(22,'e9ca59f65fd24de6b2c9afd7684b7654_small.jpg',0,NULL,'2014-05-19 11:19:02',1,NULL,NULL),(23,'44465a92ca2b4b00b37c6a5a495e8f5f.jpg',2,'sd','2014-05-19 11:23:38',1,NULL,5),(24,'b4cae6478d864004bd19f12baf9c6e1e_small.jpg',0,NULL,'2014-05-20 21:02:55',36,NULL,NULL),(25,'a83bedc3f5dc4e3a85af4d1a7a0f105f_small.jpg',0,NULL,'2014-05-20 21:04:27',4,NULL,NULL),(26,'efe0c6010f4f462eb59ec35884f6396a_small.jpg',0,NULL,'2014-05-20 21:29:04',3,NULL,NULL),(27,'677b20ef7fb949a5aaaf617ccdfb859a_small.jpg',0,NULL,'2014-05-20 22:50:38',6,NULL,NULL),(28,'d4d13ef6810947b1bd6ff77f419638c4_small.png',0,NULL,'2014-05-21 13:04:25',38,NULL,NULL),(29,'538d50d5f3ea4559a8bbc628df90b14c_small.jpg',0,NULL,'2014-05-21 13:25:00',1,NULL,NULL);

/*Table structure for table `review` */

DROP TABLE IF EXISTS `review`;

CREATE TABLE `review` (
  `REVIEW_ID` int(32) NOT NULL auto_increment COMMENT '主键',
  `USERINFO_ID` int(32) default NULL COMMENT '邀请人USERINFO_ID',
  `USERS_ID` int(32) default NULL COMMENT '邀请对象USERS_ID',
  `COMEINTO_USERINFO_ID` int(32) default NULL COMMENT '邀请入住家族成员的USERINFO_ID',
  `REVIEW_STATUS` int(1) default '0' COMMENT '审核状态0未审核1审核',
  `REVIEW_FLAG` int(1) default '0' COMMENT '是否接受0不接受1接受',
  `CREATE_DATE` datetime default NULL COMMENT '邀请',
  PRIMARY KEY  (`REVIEW_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `review` */

insert  into `review`(`REVIEW_ID`,`USERINFO_ID`,`USERS_ID`,`COMEINTO_USERINFO_ID`,`REVIEW_STATUS`,`REVIEW_FLAG`,`CREATE_DATE`) values (4,1,2,17,1,1,'2014-05-20 14:14:23'),(5,1,4,16,1,1,'2014-05-20 20:26:50'),(6,1,7,37,1,1,'2014-05-20 21:01:20'),(7,4,3,20,1,1,'2014-05-20 21:28:10'),(8,1,6,19,1,1,'2014-05-20 22:49:54'),(9,38,5,39,1,1,'2014-05-20 22:54:02'),(10,1,5,32,1,1,'2014-05-20 22:54:39'),(11,38,9,41,1,1,'2014-05-20 22:58:39'),(12,1,9,18,1,1,'2014-05-20 23:00:09'),(13,38,10,43,1,1,'2014-05-20 23:14:48'),(14,1,10,29,1,1,'2014-05-20 23:28:18'),(15,38,11,52,1,1,'2014-05-20 23:58:53'),(16,1,11,14,1,1,'2014-05-21 00:00:23');

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `USERINFO_ID` int(32) NOT NULL auto_increment COMMENT '主键',
  `USERINFO_TRUENAME` varchar(40) default NULL COMMENT '真实姓名',
  `USERINFO_SEX` int(1) default NULL COMMENT '性别:0男,1女',
  `USERINFO_BIRTHDAY` datetime default NULL COMMENT '生日日期',
  `USERINFO_DIEDAY` datetime default NULL COMMENT '死亡日期',
  `USERINFO_WORK` varchar(100) default NULL COMMENT '工作',
  `USERINFO_ACTIVE` int(1) default NULL COMMENT '是否在世:0去世,1在世',
  `USERINFO_COMMENT` varchar(500) default NULL COMMENT '介绍',
  `USERS_ID` int(32) default NULL COMMENT '用户基本信息id',
  `FAMILY_ID` int(32) default NULL COMMENT '家族id',
  `PARENT_ID` int(32) default NULL COMMENT '父亲或母亲id',
  `SPOUSE_ID` int(32) default NULL COMMENT '伴侣id',
  `LEVEL` int(11) default NULL COMMENT '世',
  PRIMARY KEY  (`USERINFO_ID`),
  KEY `USERS_ID` (`USERS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `userinfo` */

insert  into `userinfo`(`USERINFO_ID`,`USERINFO_TRUENAME`,`USERINFO_SEX`,`USERINFO_BIRTHDAY`,`USERINFO_DIEDAY`,`USERINFO_WORK`,`USERINFO_ACTIVE`,`USERINFO_COMMENT`,`USERS_ID`,`FAMILY_ID`,`PARENT_ID`,`SPOUSE_ID`,`LEVEL`) values (1,'陈伟超',0,'1991-12-24 08:00:00',NULL,'学生',1,'hello world',1,1,7,2,0),(2,'小明',1,'1991-05-15 09:00:00',NULL,'wu',1,'我是小明',2,1,NULL,1,0),(3,'小黄',1,'1991-11-11 00:00:00',NULL,NULL,1,'无',3,1,NULL,6,0),(4,'小欣',1,'2014-05-20 00:00:00',NULL,'',1,'',4,1,1,5,1),(5,'小西',0,NULL,NULL,NULL,1,NULL,5,1,NULL,4,1),(6,'小弟',0,NULL,NULL,NULL,1,NULL,6,1,53,3,0),(7,'陈伟超父亲',0,'1968-11-01 08:00:00',NULL,NULL,1,'陈伟超的父亲',NULL,1,9,8,-1),(8,'陈伟超母亲',1,'1968-03-18 08:00:00',NULL,NULL,1,'陈伟超的母亲',NULL,1,11,7,-1),(9,'陈伟超爷爷',0,'1937-08-16 08:00:00','2002-05-10 00:00:00',NULL,0,'陈伟超爷爷',NULL,1,NULL,10,-2),(10,'陈伟超奶奶',1,'1939-04-07 08:00:00',NULL,NULL,1,'陈伟超奶奶',NULL,1,NULL,9,-2),(11,'陈伟超外公',0,'1945-06-25 00:00:00',NULL,'阿',1,'陈伟超外公',NULL,1,NULL,12,-2),(12,'陈伟超外婆',1,'1946-12-05 08:00:00',NULL,NULL,1,'陈伟超外婆',NULL,1,NULL,11,-2),(13,'陈伟超亲妹妹',1,'1996-11-02 00:00:00',NULL,NULL,1,'陈伟超亲妹妹',NULL,1,7,27,0),(15,'陈伟超婶婶',1,'1958-03-02 00:00:00',NULL,NULL,1,'陈伟超婶婶',NULL,1,NULL,53,-1),(21,'陈伟超舅舅',0,'1974-12-24 00:00:00',NULL,NULL,1,'陈伟超舅舅',NULL,1,11,NULL,-1),(22,'陈伟超表弟',0,'1994-12-24 00:00:00',NULL,NULL,1,'陈伟超表弟',NULL,1,21,24,0),(23,'陈伟超外甥女',1,'2010-06-23 00:00:00','2014-05-21 00:00:00','',1,'陈伟超外甥女',NULL,1,22,NULL,1),(24,'陈伟超表弟弟妹',1,'2014-05-22 00:00:00','2014-05-28 00:00:00','无',1,'阿萨',NULL,1,28,22,0),(27,'陈伟超亲妹妹妹夫',0,'2014-05-22 00:00:00',NULL,'无',1,'111陈伟超亲妹妹妹夫',NULL,1,NULL,13,0),(28,'陈伟超表弟弟妹母亲',1,'2014-05-14 00:00:00',NULL,'无',1,'ass',NULL,1,NULL,33,-1),(31,'妹妹女儿',1,'2014-05-13 00:00:00','2014-05-20 00:00:00','1',1,'',NULL,1,27,NULL,1),(33,'表弟弟妹父亲',0,'2014-05-09 00:00:00',NULL,'',1,'',NULL,1,NULL,28,-1),(34,'孙子',0,NULL,'2014-05-28 00:00:00','',1,'11',NULL,1,42,NULL,2),(35,'曾孙子',0,'2014-05-20 00:00:00',NULL,'',1,'阿阿',NULL,1,34,NULL,3),(36,'陈一鸣',0,NULL,NULL,NULL,1,NULL,7,1,15,NULL,0),(38,'其他家族陈伟超',0,NULL,NULL,NULL,1,NULL,8,8,NULL,NULL,0),(40,'其他家族小绿',0,NULL,NULL,NULL,1,NULL,9,1,1,42,1),(42,'其他家族小芳',1,NULL,NULL,NULL,1,NULL,10,1,NULL,40,1),(51,'该成员已经跳槽',1,NULL,NULL,NULL,1,NULL,10,8,38,54,1),(53,'阿狗',0,NULL,NULL,NULL,1,NULL,11,1,9,15,-1),(54,'该成员已经跳槽',0,NULL,NULL,NULL,1,NULL,11,8,NULL,51,1);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `USERS_ID` int(32) NOT NULL auto_increment COMMENT '主键',
  `USERS_EMAIL` varchar(20) NOT NULL default '' COMMENT 'email登录账号',
  `USERS_PASSWORD` varchar(20) NOT NULL default '' COMMENT '密码',
  `CREATE_DATE` datetime default NULL COMMENT '创建时间',
  `USERS_STATUS` int(1) default NULL COMMENT '用户状态:0离线,1在线',
  PRIMARY KEY  (`USERS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`USERS_ID`,`USERS_EMAIL`,`USERS_PASSWORD`,`CREATE_DATE`,`USERS_STATUS`) values (1,'382961080@qq.com','123456','2014-05-08 13:49:05',1),(2,'xiaoming@qq.com','123456','2014-05-09 19:13:05',1),(3,'xiaohuang@qq.com','123456','2014-05-09 20:15:48',1),(4,'xiaoxin@qq.com','123456','2014-05-09 20:26:36',0),(5,'xiaoxi@qq.com','123456','2014-05-10 14:22:50',0),(6,'xiaodi@qq.com','123456','2014-05-13 23:23:46',1),(7,'yiming@qq.com','123456','2014-05-20 20:52:42',0),(8,'othercwc@qq.com','123456','2014-05-20 22:52:06',1),(9,'otherxiaolv@qq.com','123456','2014-05-20 22:57:38',0),(10,'otherxiaofang@qq.com','123456','2014-05-20 23:13:37',0),(11,'otheragou@qq.com','123456','2014-05-20 23:58:24',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
