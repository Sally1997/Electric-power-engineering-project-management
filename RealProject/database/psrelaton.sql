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

/*Table structure for table `psrelation` */

DROP TABLE IF EXISTS `psrelation`;

CREATE TABLE `psrelation` (
  `staffno` char(12) NOT NULL,
  `pno` char(5) NOT NULL,
  `duty` varchar(10) NOT NULL,
  PRIMARY KEY (`staffno`,`pno`),
  KEY `fk_psrelation_pno` (`pno`),
  CONSTRAINT `fk_psrelation_pno` FOREIGN KEY (`pno`) REFERENCES `project` (`pno`),
  CONSTRAINT `fk_psrelation_staffno` FOREIGN KEY (`staffno`) REFERENCES `staff` (`staffno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `psrelation` */

insert  into `psrelation`(`staffno`,`pno`,`duty`) values ('201526010001','10001','开发人员'),('201526010001','10002','测试人员'),('201526010001','10003','测试人员'),('201526010001','10004','职业搞笑人员');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
