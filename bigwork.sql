/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.17 : Database - jctp
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jctp` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jctp`;

/*Table structure for table `jctp_chat_course` */

DROP TABLE IF EXISTS `jctp_chat_course`;

CREATE TABLE `jctp_chat_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `msg` varchar(1000) DEFAULT NULL,
  `seq` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_10` (`course_id`),
  KEY `FK_Reference_11` (`user_id`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`course_id`) REFERENCES `jctp_course` (`id`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`user_id`) REFERENCES `jctp_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `jctp_chat_course` */

/*Table structure for table `jctp_chat_ts` */

DROP TABLE IF EXISTS `jctp_chat_ts`;

CREATE TABLE `jctp_chat_ts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `student_msg` varchar(1000) DEFAULT NULL,
  `teacher_msg` varchar(1000) DEFAULT NULL,
  `state` int(11) DEFAULT NULL COMMENT '0-教师未回复\n            1-教师已回复',
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_12` (`course_id`),
  KEY `FK_Reference_13` (`student_id`),
  KEY `FK_Reference_14` (`teacher_id`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`course_id`) REFERENCES `jctp_course` (`id`),
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`student_id`) REFERENCES `jctp_user` (`id`),
  CONSTRAINT `FK_Reference_14` FOREIGN KEY (`teacher_id`) REFERENCES `jctp_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `jctp_chat_ts` */

/*Table structure for table `jctp_class` */

DROP TABLE IF EXISTS `jctp_class`;

CREATE TABLE `jctp_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `college` varchar(100) DEFAULT NULL,
  `class_no` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=162043 DEFAULT CHARSET=utf8;

/*Data for the table `jctp_class` */

insert  into `jctp_class`(`id`,`college`,`class_no`) values (1,'软件学院','162041'),(2,'软件学院','162042');

/*Table structure for table `jctp_course` */

DROP TABLE IF EXISTS `jctp_course`;

CREATE TABLE `jctp_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `course_name` varchar(100) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  `term` int(11) DEFAULT NULL,
  `course_img` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_15` (`teacher_id`),
  KEY `FK_Reference_classId` (`class_id`),
  CONSTRAINT `FK_Reference_15` FOREIGN KEY (`teacher_id`) REFERENCES `jctp_user` (`id`),
  CONSTRAINT `FK_Reference_classId` FOREIGN KEY (`class_id`) REFERENCES `jctp_class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `jctp_course` */

insert  into `jctp_course`(`id`,`class_id`,`teacher_id`,`course_name`,`create_date`,`grade`,`term`,`course_img`) values (1,1,2,'WEB高级编程','2019-06-17 10:59:29',3,2,'/images/courses/course1.png'),(2,1,2,'软件建模技术','2019-06-15 11:01:17',3,2,'/images/courses/course1.png'),(3,1,2,'oracle大型数据库编程','2019-06-15 11:01:38',3,2,'/images/courses/course1.png'),(4,1,2,'专业英语','2019-06-16 11:01:54',3,2,'/images/courses/course1.png'),(5,1,2,'算法设计','2019-05-01 12:28:30',3,2,'/images/courses/course1.png');

/*Table structure for table `jctp_course_file` */

DROP TABLE IF EXISTS `jctp_course_file`;

CREATE TABLE `jctp_course_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '1-视频\n            2-文档以及PPT',
  `file_name` varchar(100) DEFAULT NULL,
  `file_path` varchar(200) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_5` (`course_id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`course_id`) REFERENCES `jctp_course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `jctp_course_file` */

/*Table structure for table `jctp_course_job` */

DROP TABLE IF EXISTS `jctp_course_job`;

CREATE TABLE `jctp_course_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) DEFAULT NULL,
  `job_name` varchar(100) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `release_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `seq` int(11) DEFAULT NULL,
  `total_socre` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_4` (`course_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`course_id`) REFERENCES `jctp_course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `jctp_course_job` */

insert  into `jctp_course_job`(`id`,`course_id`,`job_name`,`description`,`release_date`,`end_date`,`seq`,`total_socre`) values (1,1,'作业1','作业1','2019-06-17 17:57:19','2019-06-20 17:57:24',1,100),(2,1,'作业2','作业2','2019-06-17 17:57:47','2019-06-20 17:57:51',2,100),(3,2,'作业2','作业3',NULL,NULL,NULL,NULL),(9,2,NULL,NULL,NULL,NULL,NULL,NULL),(10,2,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `jctp_permission` */

DROP TABLE IF EXISTS `jctp_permission`;

CREATE TABLE `jctp_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `method` varchar(10) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `jctp_permission` */

insert  into `jctp_permission`(`id`,`name`,`description`,`url`,`pid`,`method`,`state`) values (1,'STUDENT','TEST','/student/**',NULL,'get|post',1),(2,'TEACHER','TEST','/teacher/**',NULL,'get|post',1),(3,'DEAN','TEST','/dean/**',NULL,'get|post',1),(4,'所有课程','学生主界面','/student/index',NULL,'get|post',1),(5,'课程','学生课程界面','/student/course',NULL,'get|post',1),(6,'代码编辑器','学生代码编辑器','/student/codeEditor',NULL,'get|post',1),(7,'收件箱','学生收件箱','/student/inbox',NULL,'get|post',1);

/*Table structure for table `jctp_question_job` */

DROP TABLE IF EXISTS `jctp_question_job`;

CREATE TABLE `jctp_question_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) DEFAULT NULL,
  `job_id` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_16` (`question_id`),
  KEY `FK_Reference_17` (`job_id`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`question_id`) REFERENCES `jctp_questions` (`id`),
  CONSTRAINT `FK_Reference_17` FOREIGN KEY (`job_id`) REFERENCES `jctp_course_job` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `jctp_question_job` */

/*Table structure for table `jctp_questions` */

DROP TABLE IF EXISTS `jctp_questions`;

CREATE TABLE `jctp_questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_name` varchar(100) DEFAULT NULL,
  `question_type` int(11) DEFAULT NULL COMMENT '0-填空题\n            1-选择题\n            2-判断题\n            3-简答题\n            4-代码题',
  `answer` varchar(1000) DEFAULT NULL COMMENT 'json数据格式\n            [\n                {\n                    input::1,\n                    output:1\n                },\n                {\n                    input::2,\n                    output:2\n                }\n            ]',
  `seq` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `jctp_questions` */

/*Table structure for table `jctp_role` */

DROP TABLE IF EXISTS `jctp_role`;

CREATE TABLE `jctp_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `jctp_role` */

insert  into `jctp_role`(`id`,`name`,`state`) values (1,'STUDENT',1),(2,'TEACHER',1),(3,'DEAN',1);

/*Table structure for table `jctp_role_permission` */

DROP TABLE IF EXISTS `jctp_role_permission`;

CREATE TABLE `jctp_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_2` (`role_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`role_id`) REFERENCES `jctp_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `jctp_role_permission` */

insert  into `jctp_role_permission`(`id`,`role_id`,`permission_id`,`state`) values (1,1,1,1),(2,2,2,1);

/*Table structure for table `jctp_student_job` */

DROP TABLE IF EXISTS `jctp_student_job`;

CREATE TABLE `jctp_student_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `job_id` int(11) DEFAULT NULL,
  `submit_date` datetime DEFAULT NULL,
  `score` double DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `PK_reference_sj_user` (`student_id`),
  KEY `PK_reference_sj_job` (`job_id`),
  CONSTRAINT `PK_reference_sj_job` FOREIGN KEY (`job_id`) REFERENCES `jctp_course_job` (`id`),
  CONSTRAINT `PK_reference_sj_user` FOREIGN KEY (`student_id`) REFERENCES `jctp_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

/*Data for the table `jctp_student_job` */

insert  into `jctp_student_job`(`id`,`student_id`,`job_id`,`submit_date`,`score`,`state`) values (18,1,10,NULL,NULL,0),(19,2,10,NULL,NULL,0),(20,3,10,NULL,NULL,0),(21,4,10,NULL,NULL,0),(22,5,10,NULL,NULL,0),(23,6,10,NULL,NULL,0),(24,7,10,NULL,NULL,0),(25,8,10,NULL,NULL,0),(26,9,10,NULL,NULL,0),(27,692,10,NULL,NULL,0);

/*Table structure for table `jctp_students_questions` */

DROP TABLE IF EXISTS `jctp_students_questions`;

CREATE TABLE `jctp_students_questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `up_answer` varchar(1000) DEFAULT NULL,
  `score` double DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_18` (`question_id`),
  KEY `FK_Reference_19` (`user_id`),
  CONSTRAINT `FK_Reference_18` FOREIGN KEY (`question_id`) REFERENCES `jctp_questions` (`id`),
  CONSTRAINT `FK_Reference_19` FOREIGN KEY (`user_id`) REFERENCES `jctp_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `jctp_students_questions` */

/*Table structure for table `jctp_user` */

DROP TABLE IF EXISTS `jctp_user`;

CREATE TABLE `jctp_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `work_no` varchar(20) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `avatar` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_1` (`role_id`),
  KEY `FK_Reference_user_class` (`class_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`role_id`) REFERENCES `jctp_role` (`id`),
  CONSTRAINT `FK_Reference_user_class` FOREIGN KEY (`class_id`) REFERENCES `jctp_class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=694 DEFAULT CHARSET=utf8;

/*Data for the table `jctp_user` */

insert  into `jctp_user`(`id`,`name`,`sex`,`work_no`,`phone`,`role_id`,`state`,`class_id`,`password`,`avatar`) values (1,'陈佰鑫','男','16204110','18160745110',1,1,1,'$2a$10$tmPnzqtDtMbW6YE3CT31YeX6J4MKR.cXJBEZ4p4zfgq5XLPKdhO2a','/images/title1.jpg'),(2,'黄川沂','男','16204111','18160745110',2,1,1,'$2a$10$tmPnzqtDtMbW6YE3CT31YeX6J4MKR.cXJBEZ4p4zfgq5XLPKdhO2a','/images/title2.jpg'),(3,'曾利平','男','16204125','18160745110',3,1,1,'$2a$10$tmPnzqtDtMbW6YE3CT31YeX6J4MKR.cXJBEZ4p4zfgq5XLPKdhO2a','/images/title3.jpg'),(4,'曾利平','男','16204126','18160745110',3,1,1,'$2a$10$tmPnzqtDtMbW6YE3CT31YeX6J4MKR.cXJBEZ4p4zfgq5XLPKdhO2a','/images/title3.jpg'),(5,'陈佰鑫','男','16204112','18160745110',1,1,1,'$2a$10$tmPnzqtDtMbW6YE3CT31YeX6J4MKR.cXJBEZ4p4zfgq5XLPKdhO2a','/images/title1.jpg'),(6,'陈佰鑫','男','16204113','18160745110',1,1,1,'$2a$10$tmPnzqtDtMbW6YE3CT31YeX6J4MKR.cXJBEZ4p4zfgq5XLPKdhO2a','/images/title1.jpg'),(7,'陈佰鑫','男','16204114','18160745110',1,1,1,'$2a$10$tmPnzqtDtMbW6YE3CT31YeX6J4MKR.cXJBEZ4p4zfgq5XLPKdhO2a','/images/title1.jpg'),(8,'陈佰鑫','男','16204115','18160745110',1,1,1,'$2a$10$tmPnzqtDtMbW6YE3CT31YeX6J4MKR.cXJBEZ4p4zfgq5XLPKdhO2a','/images/title1.jpg'),(9,'陈佰鑫','男','16204116','18160745110',1,1,1,'$2a$10$tmPnzqtDtMbW6YE3CT31YeX6J4MKR.cXJBEZ4p4zfgq5XLPKdhO2a','/images/title1.jpg'),(692,'金伟莉','男女','16204117',NULL,NULL,1,1,NULL,NULL),(693,'金伟莉二号','男','16204118',NULL,NULL,1,NULL,NULL,NULL);

/* Trigger structure for table `jctp_course_job` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `init_student_job` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `init_student_job` AFTER INSERT ON `jctp_course_job` FOR EACH ROW BEGIN
	DECLARE VAR_CLASS_ID INT;
	SET VAR_CLASS_ID=(SELECT CLASS_ID FROM JCTP_COURSE WHERE ID=NEW.COURSE_ID);
	
	INSERT INTO JCTP_STUDENT_JOB(student_id,job_id,state) (SELECT id,new.id,0 FROM jctp_user WHERE class_id=VAR_CLASS_ID);
END */$$


DELIMITER ;

/* Trigger structure for table `jctp_course_job` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `delete_student_job` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `delete_student_job` BEFORE DELETE ON `jctp_course_job` FOR EACH ROW BEGIN
	DELETE FROM jctp_student_job WHERE job_id=old.id;
END */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
