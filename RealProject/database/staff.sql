/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.5.52 : Database - realproject
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`realproject` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `realproject`;

/*Table structure for table `staff` */

DROP TABLE IF EXISTS `staff`;

CREATE TABLE `staff` (
  `staffno` char(12) NOT NULL,
  `name` varchar(20) NOT NULL,
  `sex` varchar(3) NOT NULL,
  `birthday` date NOT NULL,
  `te` char(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `imagelink` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`staffno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `staff` */

insert  into `staff`(`staffno`,`name`,`sex`,`birthday`,`te`,`email`,`imagelink`) values ('201526010001','张三','男','1996-12-06','15612345623','1515dsads@qq.com','D:\\ProjectDatabase\\staffimage\\1.jpg'),('201526010002','爱丽丝','女','1997-05-10','15236984125','dsadsa@gmail.com','D:\\ProjectDatabase\\staffimage\\2.jpg'),('201526010003','二狗子','男','1997-09-09','16165165141','95141255226@qq.com',NULL),('201526010004','三蹦子','妖','1996-05-06','12345678912','123456@qq.com','D:\\ProjectDatabase\\staffimage\\2.jpg'),('201526010005','四傻子','男','1998-05-05','15236525235','741258963@qq。com','D:\\ProjectDatabase\\staffimage\\1.jpg'),('201526010006','张爱国','男','1995-06-06','15641257885','2356@qq.com','D:\\ProjectDatabase\\staffimage\\1.jpg'),('201526010007','张大叼','女','1965-05-05','14523523689','5241@qq.com','D:\\ProjectDatabase\\staffimage\\2.jpg'),('201526010412','五大','女','1999-06-03','14523654855','1230226@gmail.com','D:\\ProjectDatabase\\staffimage\\1.jpg');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
