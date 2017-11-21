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

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `pno` char(5) NOT NULL,
  `pname` varchar(30) NOT NULL,
  `pmno` char(12) NOT NULL,
  `stime` date NOT NULL,
  `etime` date DEFAULT NULL,
  `ptype` char(1) DEFAULT NULL,
  `pbudget` decimal(10,2) DEFAULT NULL,
  `pstage` decimal(2,2) NOT NULL,
  `pstate` char(1) DEFAULT NULL,
  PRIMARY KEY (`pno`),
  KEY `fk_project_pmno` (`pmno`),
  CONSTRAINT `fk_project_pmno` FOREIGN KEY (`pmno`) REFERENCES `staff` (`staffno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `project` */

insert  into `project`(`pno`,`pname`,`pmno`,`stime`,`etime`,`ptype`,`pbudget`,`pstage`,`pstate`) values ('10001','湖南省电力搭建','201526010002','2017-11-20',NULL,'1','200000.00','0.00','0'),('10002','湖北省跑步比赛','201526010001','2017-02-09',NULL,'2','5265152.00','0.23','3'),('10003','吃鸡大赛','201526010412','2015-09-23',NULL,'3','99999999.99','0.52','1'),('10004','跳舞比赛','201526010003','2015-09-06','2015-10-03','4','2000000.00','0.99','4');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
