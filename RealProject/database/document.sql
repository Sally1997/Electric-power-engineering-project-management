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

/*Table structure for table `document` */

DROP TABLE IF EXISTS `document`;

CREATE TABLE `document` (
  `dno` char(14) NOT NULL,
  `pno` char(5) NOT NULL,
  `dtitle` varchar(30) NOT NULL,
  `dpath` varchar(100) NOT NULL,
  `uploadtime` datetime NOT NULL,
  `dloadtimes` int(11) NOT NULL,
  `ftype` varchar(10) NOT NULL,
  `dtype` varchar(10) NOT NULL,
  `fsize` int(11) NOT NULL,
  `uloadpno` char(12) NOT NULL,
  PRIMARY KEY (`dno`),
  KEY `fk_document_pno` (`pno`),
  KEY `fk_document_uloadpno` (`uloadpno`),
  CONSTRAINT `fk_document_pno` FOREIGN KEY (`pno`) REFERENCES `project` (`pno`),
  CONSTRAINT `fk_document_uloadpno` FOREIGN KEY (`uloadpno`) REFERENCES `staff` (`staffno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `document` */

insert  into `document`(`dno`,`pno`,`dtitle`,`dpath`,`uploadtime`,`dloadtimes`,`ftype`,`dtype`,`fsize`,`uloadpno`) values ('1','10001','关于建设小康社会的共识','','2015-09-15 22:21:30',2,'doc','',20000,'201526010001'),('2','10001','java编程思想','','2017-08-06 10:11:11',3,'doc','',200,'201526010002'),('3','10003','imperfect c++思考','','2016-08-06 02:05:32',2,'doc','',100,'201526010003'),('4','10002','深入了解计算机系统','','2016-08-05 12:04:20',5,'doc','',0,'201526010004'),('5','10001','深入理解JVM虚拟机','','2017-08-09 12:23:20',6,'mp4','',0,'201526010005'),('6','10001','深入分析java web技术内幕','','2017-11-20 20:27:10',0,'','',0,'201526010006');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
