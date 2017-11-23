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

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `staffno` char(12) NOT NULL,
  `password` varchar(20) NOT NULL,
  `lltime` date DEFAULT NULL,
  PRIMARY KEY (`staffno`),
  CONSTRAINT `fk_account_staffno` FOREIGN KEY (`staffno`) REFERENCES `staff` (`staffno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `account` */

insert  into `account`(`staffno`,`password`,`lltime`) values ('201526010001','201526010001','2017-11-21'),('201526010002','201526010002','2017-11-20'),('201526010003','201526010003',NULL),('201526010004','201526010004',NULL),('201526010005','201526010005','2017-11-20'),('201526010006','201526010006',NULL),('201526010007','201526010007','2017-11-20'),('201526010412','201526010412',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
