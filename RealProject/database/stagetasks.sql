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

/*Table structure for table `stagetasks` */

DROP TABLE IF EXISTS `stagetasks`;

CREATE TABLE `stagetasks` (
  `taskno` char(10) NOT NULL,
  `taskname` varchar(30) NOT NULL,
  `stime` date NOT NULL,
  `etime` date NOT NULL,
  `pubno` char(12) NOT NULL,
  `charpno` char(12) NOT NULL,
  `ptaskno` char(10) DEFAULT NULL,
  `tstate` char(1) NOT NULL,
  `taskcontent` varchar(255) NOT NULL,
  PRIMARY KEY (`taskno`),
  KEY `fk_project_pubno` (`pubno`),
  KEY `fk_project_charpno` (`charpno`),
  KEY `fk_project_ptaskno` (`ptaskno`),
  CONSTRAINT `fk_project_charpno` FOREIGN KEY (`charpno`) REFERENCES `staff` (`staffno`),
  CONSTRAINT `fk_project_ptaskno` FOREIGN KEY (`ptaskno`) REFERENCES `stagetasks` (`taskno`),
  CONSTRAINT `fk_project_pubno` FOREIGN KEY (`pubno`) REFERENCES `staff` (`staffno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stagetasks` */

insert  into `stagetasks`(`taskno`,`taskname`,`stime`,`etime`,`pubno`,`charpno`,`ptaskno`,`tstate`,`taskcontent`) values ('1000110001','跳水','2015-05-06','2015-05-07','201526010001','201526010002',NULL,'1','这是一场游戏'),('1000110002','吃鸡','2015-09-05','2015-09-16','201526010002','201526010001',NULL,'1','好玩吗'),('1000110003','草泥马','2017-08-05','2017-08-09','201526010412','201526010001',NULL,'1','那岂不是很爽水水水水水水水水水水'),('1000110004','呵呵大赛','2017-11-02','2017-11-05','201526010006','201526010001',NULL,'0','呵你妈逼');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
