/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.6.30-0ubuntu0.14.04.1 : Database - foster
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`foster` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `foster`;

/*Table structure for table `applicationlog` */

DROP TABLE IF EXISTS `applicationlog`;

CREATE TABLE `applicationlog` (
  `id` int(11) NOT NULL,
  `apiName` varchar(255) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  `errorCode` varchar(255) DEFAULT NULL,
  `errorText` varchar(255) DEFAULT NULL,
  `executionTime` decimal(19,2) DEFAULT NULL,
  `ipAddress` varchar(255) DEFAULT NULL,
  `requestJSON` varchar(3000) DEFAULT NULL,
  `responseJSON` varchar(3000) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `applicationlog` */

insert  into `applicationlog`(`id`,`apiName`,`createdOn`,`errorCode`,`errorText`,`executionTime`,`ipAddress`,`requestJSON`,`responseJSON`,`status`) values (1342,'/chhs/rest/facilities/agencynearby','2016-06-08 16:22:07','GEN-006','{\"lattitude\":\"may not be empty\",\"INVALID_REQUEST\":\"lattitude is not provided!. :: longitude is not provided!. :: radius is not provided!.\",\"longitude\":\"may not be empty\"}',606.00,'127.0.0.1','{}','{\"status\":\"1\",\"error\":{\"system\":\"CHHS-Dev\",\"chhsErrorCode\":\"GEN-006\",\"chhsErrorMessage\":\"{\\\"lattitude\\\":\\\"may not be empty\\\",\\\"INVALID_REQUEST\\\":\\\"lattitude is not provided!. :: longitude is not provided!. :: radius is not provided!.\\\",\\\"longitude\\\":\\\"may not be empty\\\"}\"}}','1'),(1343,'/chhs/rest/member/save','2016-06-08 16:22:07','GEN-006','{\"INVALID_REQUEST\":\"Licence Details Missing\",\"userContext\":\"may not be null\"}',600.00,'127.0.0.1','{\"personalProfile\":{\"homestudy\":\"y\",\"training\":\"y\",\"useremail\":\"a@a.com\",\"userName\":\"testUser\",\"password\":\"testUser\"},\"personalDetails\":{\"contactNo\":\"9872664213\",\"dob\":\"05/31/2016\",\"firstName\":\"spfN test\",\"gender\":\"f\",\"hobbies\":\"hobbies test\",\"income\":\"12345\",\"lastName\":\"lastName test\",\"maritalStatus\":\"y\",\"occupation\":\"occupation\",\"preference\":\"preference\",\"race\":\"race\",\"religion\":\"religion\",\"spouseDetails\":{\"contactNo\":\"9876543210\",\"dob\":\"05/31/2016\",\"firstName\":\"fnameTest\",\"gender\":\"M\",\"hobbies\":\"hobbies Test\",\"income\":\"200\",\"occupation\":\"occupation\",\"preference\":\"preference\",\"race\":\"race\",\"religion\":\"religion\"}},\"familyDetails\":{\"description\":\"description\",\"haveKids\":\"Y\",\"numberOfKids\":\"2\",\"kidsPref\":\"test data\",\"kids\":[{\"kidName\":\"kidName1\",\"age\":\"12\",\"hobbies\":\"hobbies test\"},{\"kidName\":\"kidName1\",\"age\":\"12\",\"hobbies\":\"hobbies test\"}]},\"registrationStage\":4}','{\"status\":\"1\",\"error\":{\"system\":\"CHHS-Dev\",\"chhsErrorCode\":\"GEN-006\",\"chhsErrorMessage\":\"{\\\"INVALID_REQUEST\\\":\\\"Licence Details Missing\\\",\\\"userContext\\\":\\\"may not be null\\\"}\"}}','1'),(1344,'/chhs/rest/member/register','2016-06-08 16:22:07','GEN-006','{\"INVALID_REQUEST\":\"Personal Details Missing\"}',588.00,'127.0.0.1','{\"personalProfile\":{\"homestudy\":\"y\",\"training\":\"y\",\"useremail\":\"a@a.com\",\"userName\":\"testUser\",\"password\":\"testUser\"},\"familyDetails\":{\"description\":\"description\",\"haveKids\":\"Y\",\"numberOfKids\":\"2\",\"kidsPref\":\"test data\",\"kids\":[{\"kidName\":\"kidName1\",\"age\":\"12\",\"hobbies\":\"hobbies test\"},{\"kidName\":\"kidName1\",\"age\":\"12\",\"hobbies\":\"hobbies test\"}]},\"licenceDetails\":{\"agencyContact\":\"123456789\",\"agencyWorker\":\"TEST\",\"dateOfIssue\":\"05/31/2016\",\"licenceNo\":\"321456789\"},\"registrationStage\":4}','{\"status\":\"1\",\"error\":{\"system\":\"CHHS-Dev\",\"chhsErrorCode\":\"GEN-006\",\"chhsErrorMessage\":\"{\\\"INVALID_REQUEST\\\":\\\"Personal Details Missing\\\"}\"}}','1'),(1345,'/chhs/rest/contextinit/createusercontext','2016-06-08 16:22:07','GEN-007','Invalid username or password',3219.00,'127.0.0.1','{\"userName\":\"testUser\",\"password\":\"testUser-wrong\"}','{\"errorDetails\":[],\"status\":\"1\",\"error\":{\"system\":\"CHHS-Dev\",\"chhsErrorCode\":\"GEN-007\",\"chhsErrorMessage\":\"Invalid username or password\"}}','1'),(1347,'/chhs/rest/facilities/zipcode/95630','2016-06-08 16:22:07',NULL,NULL,3372.00,'127.0.0.1',NULL,NULL,'1'),(1348,'/chhs/rest/facilities/zipcode/90008','2016-06-08 16:22:07',NULL,NULL,3389.00,'127.0.0.1',NULL,NULL,'1'),(1355,'/chhs/rest/member/register','2016-06-08 16:22:07',NULL,NULL,4363.00,'127.0.0.1','{\"personalProfile\":{\"homestudy\":\"y\",\"training\":\"y\",\"useremail\":\"1465383125675@test.com\",\"userName\":\"test1465383125675\",\"password\":\"testUser\"},\"personalDetails\":{\"contactNo\":\"9872664213\",\"dob\":\"05/31/2016\",\"firstName\":\"spfN test\",\"gender\":\"f\",\"hobbies\":\"hobbies test\",\"income\":\"12345\",\"lastName\":\"lastName test\",\"maritalStatus\":\"y\",\"occupation\":\"occupation\",\"preference\":\"preference\",\"race\":\"race\",\"religion\":\"religion\",\"spouseDetails\":{\"contactNo\":\"9876543210\",\"dob\":\"05/31/2016\",\"firstName\":\"fnameTest\",\"gender\":\"M\",\"hobbies\":\"hobbies Test\",\"income\":\"200\",\"occupation\":\"occupation\",\"preference\":\"preference\",\"race\":\"race\",\"religion\":\"religion\"}},\"familyDetails\":{\"description\":\"description\",\"haveKids\":\"Y\",\"numberOfKids\":\"2\",\"kidsPref\":\"test data\",\"kids\":[{\"kidName\":\"kidName1\",\"age\":\"12\",\"hobbies\":\"hobbies test\"},{\"kidName\":\"kidName1\",\"age\":\"12\",\"hobbies\":\"hobbies test\"}]},\"licenceDetails\":{\"agencyContact\":\"123456789\",\"agencyWorker\":\"test\",\"dateOfIssue\":\"05/31/2016\",\"licenceNo\":\"321456789\"},\"registrationStage\":4}','{\"userContext\":{\"userId\":1346,\"firstName\":\"spfN test\",\"lastName\":\"lastName test\",\"userName\":\"test1465383125675\",\"loggedInDate\":\"06/08/2016 16:22\",\"profileStage\":4,\"userStatus\":\"ACTIVE\",\"userRoleMap\":{},\"sessionId\":\"fHFX1uK0BS3YzBz0HuwQBe4da\"},\"status\":\"0\",\"message\":\"User Registered successfully\"}','1'),(1356,'/chhs/rest/facilities/zipcode/95630','2016-06-08 16:23:34','GEN-004','Request payload not found',67.00,'127.0.0.1','','{\"status\":\"1\",\"error\":{\"system\":\"CHHS-Dev\",\"chhsErrorCode\":\"GEN-004\",\"chhsErrorMessage\":\"Request payload not found\"}}','1'),(1357,'/chhs/rest/member/register','2016-06-08 16:23:34','GEN-006','{\"INVALID_REQUEST\":\"Personal Details Missing\"}',337.00,'127.0.0.1','{\"personalProfile\":{\"homestudy\":\"y\",\"training\":\"y\",\"useremail\":\"a@a.com\",\"userName\":\"testUser\",\"password\":\"testUser\"},\"familyDetails\":{\"description\":\"description\",\"haveKids\":\"Y\",\"numberOfKids\":\"2\",\"kidsPref\":\"test data\",\"kids\":[{\"kidName\":\"kidName1\",\"age\":\"12\",\"hobbies\":\"hobbies test\"},{\"kidName\":\"kidName1\",\"age\":\"12\",\"hobbies\":\"hobbies test\"}]},\"licenceDetails\":{\"agencyContact\":\"123456789\",\"agencyWorker\":\"TEST\",\"dateOfIssue\":\"05/31/2016\",\"licenceNo\":\"321456789\"},\"registrationStage\":4}','{\"status\":\"1\",\"error\":{\"system\":\"CHHS-Dev\",\"chhsErrorCode\":\"GEN-006\",\"chhsErrorMessage\":\"{\\\"INVALID_REQUEST\\\":\\\"Personal Details Missing\\\"}\"}}','1'),(1358,'/chhs/rest/member/save','2016-06-08 16:23:34','GEN-006','{\"INVALID_REQUEST\":\"Licence Details Missing\",\"userContext\":\"may not be null\"}',416.00,'127.0.0.1','{\"personalProfile\":{\"homestudy\":\"y\",\"training\":\"y\",\"useremail\":\"a@a.com\",\"userName\":\"testUser\",\"password\":\"testUser\"},\"personalDetails\":{\"contactNo\":\"9872664213\",\"dob\":\"05/31/2016\",\"firstName\":\"spfN test\",\"gender\":\"f\",\"hobbies\":\"hobbies test\",\"income\":\"12345\",\"lastName\":\"lastName test\",\"maritalStatus\":\"y\",\"occupation\":\"occupation\",\"preference\":\"preference\",\"race\":\"race\",\"religion\":\"religion\",\"spouseDetails\":{\"contactNo\":\"9876543210\",\"dob\":\"05/31/2016\",\"firstName\":\"fnameTest\",\"gender\":\"M\",\"hobbies\":\"hobbies Test\",\"income\":\"200\",\"occupation\":\"occupation\",\"preference\":\"preference\",\"race\":\"race\",\"religion\":\"religion\"}},\"familyDetails\":{\"description\":\"description\",\"haveKids\":\"Y\",\"numberOfKids\":\"2\",\"kidsPref\":\"test data\",\"kids\":[{\"kidName\":\"kidName1\",\"age\":\"12\",\"hobbies\":\"hobbies test\"},{\"kidName\":\"kidName1\",\"age\":\"12\",\"hobbies\":\"hobbies test\"}]},\"registrationStage\":4}','{\"status\":\"1\",\"error\":{\"system\":\"CHHS-Dev\",\"chhsErrorCode\":\"GEN-006\",\"chhsErrorMessage\":\"{\\\"INVALID_REQUEST\\\":\\\"Licence Details Missing\\\",\\\"userContext\\\":\\\"may not be null\\\"}\"}}','1'),(1359,'/chhs/rest/facilities/agencynearby','2016-06-08 16:23:34','GEN-006','{\"lattitude\":\"may not be empty\",\"INVALID_REQUEST\":\"lattitude is not provided!. :: longitude is not provided!. :: radius is not provided!.\",\"longitude\":\"may not be empty\"}',413.00,'127.0.0.1','{}','{\"status\":\"1\",\"error\":{\"system\":\"CHHS-Dev\",\"chhsErrorCode\":\"GEN-006\",\"chhsErrorMessage\":\"{\\\"lattitude\\\":\\\"may not be empty\\\",\\\"INVALID_REQUEST\\\":\\\"lattitude is not provided!. :: longitude is not provided!. :: radius is not provided!.\\\",\\\"longitude\\\":\\\"may not be empty\\\"}\"}}','1'),(1360,'/chhs/rest/contextinit/createusercontext','2016-06-08 16:23:34','GEN-007','Invalid username or password',3588.00,'127.0.0.1','{\"userName\":\"testUser\",\"password\":\"testUser-wrong\"}','{\"errorDetails\":[],\"status\":\"1\",\"error\":{\"system\":\"CHHS-Dev\",\"chhsErrorCode\":\"GEN-007\",\"chhsErrorMessage\":\"Invalid username or password\"}}','1'),(1368,'/chhs/rest/member/register','2016-06-08 16:23:34',NULL,NULL,4567.00,'127.0.0.1','{\"personalProfile\":{\"homestudy\":\"y\",\"training\":\"y\",\"useremail\":\"1465383212811@test.com\",\"userName\":\"test1465383212811\",\"password\":\"testUser\"},\"personalDetails\":{\"contactNo\":\"9872664213\",\"dob\":\"05/31/2016\",\"firstName\":\"spfN test\",\"gender\":\"f\",\"hobbies\":\"hobbies test\",\"income\":\"12345\",\"lastName\":\"lastName test\",\"maritalStatus\":\"y\",\"occupation\":\"occupation\",\"preference\":\"preference\",\"race\":\"race\",\"religion\":\"religion\",\"spouseDetails\":{\"contactNo\":\"9876543210\",\"dob\":\"05/31/2016\",\"firstName\":\"fnameTest\",\"gender\":\"M\",\"hobbies\":\"hobbies Test\",\"income\":\"200\",\"occupation\":\"occupation\",\"preference\":\"preference\",\"race\":\"race\",\"religion\":\"religion\"}},\"familyDetails\":{\"description\":\"description\",\"haveKids\":\"Y\",\"numberOfKids\":\"2\",\"kidsPref\":\"test data\",\"kids\":[{\"kidName\":\"kidName1\",\"age\":\"12\",\"hobbies\":\"hobbies test\"},{\"kidName\":\"kidName1\",\"age\":\"12\",\"hobbies\":\"hobbies test\"}]},\"licenceDetails\":{\"agencyContact\":\"123456789\",\"agencyWorker\":\"test\",\"dateOfIssue\":\"05/31/2016\",\"licenceNo\":\"321456789\"},\"registrationStage\":4}','{\"userContext\":{\"userId\":1361,\"firstName\":\"spfN test\",\"lastName\":\"lastName test\",\"userName\":\"test1465383212811\",\"loggedInDate\":\"06/08/2016 16:23\",\"profileStage\":4,\"userStatus\":\"ACTIVE\",\"userRoleMap\":{},\"sessionId\":\"TgnFPLx4bLK1fBBvNrQMd7amC\"},\"status\":\"0\",\"message\":\"User Registered successfully\"}','1'),(1369,'/chhs/rest/facilities/zipcode/90008','2016-06-08 16:23:34',NULL,NULL,5560.00,'127.0.0.1',NULL,NULL,'1');

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values (1370),(1370),(1370),(1370),(1370),(1370),(1370);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `RoleID` int(11) NOT NULL AUTO_INCREMENT,
  `RoleName` varchar(60) DEFAULT NULL,
  `Status` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`RoleID`),
  UNIQUE KEY `RoleName_UNIQUE` (`RoleName`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`RoleID`,`RoleName`,`Status`) values (1,'admin','A');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(128) NOT NULL,
  `password` varchar(200) NOT NULL,
  `useremail` varchar(128) NOT NULL,
  `homestudy` varchar(1) NOT NULL,
  `training` varchar(1) NOT NULL,
  `status` varchar(15) NOT NULL,
  `stage` int(1) NOT NULL,
  `caseID` varchar(15) NOT NULL,
  `roleID` int(11) DEFAULT NULL,
  `createdOn` datetime NOT NULL,
  `createdBy` int(11) NOT NULL DEFAULT '0',
  `modifiedOn` datetime DEFAULT NULL,
  `modifiedBy` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`userID`),
  UNIQUE KEY `UserName_UNIQUE` (`userName`),
  KEY `FK_USER_ROLE_ROLEID_idx` (`roleID`),
  CONSTRAINT `FK_USER_ROLE_ROLEID` FOREIGN KEY (`roleID`) REFERENCES `role` (`RoleID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FKngm7ewd8isdg4b7nk13ndkp7w` FOREIGN KEY (`roleID`) REFERENCES `role` (`RoleID`)
) ENGINE=InnoDB AUTO_INCREMENT=1362 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`userID`,`userName`,`password`,`useremail`,`homestudy`,`training`,`status`,`stage`,`caseID`,`roleID`,`createdOn`,`createdBy`,`modifiedOn`,`modifiedBy`) values (1,'agreeya','Zt6FOTm02fONWkt2Y6K/7nq1aefZMfwUHLkLeRPVjhWErnFwrso/Fpc9V3P8a1O0','amit@agreeya.com','y','y','INCOMPLETE',1,'CASE-3FEC7-3549',1,'2016-06-07 12:41:35',1,'2016-06-07 12:41:35',1);

/*Table structure for table `userdetail` */

DROP TABLE IF EXISTS `userdetail`;

CREATE TABLE `userdetail` (
  `id` int(11) NOT NULL,
  `contactNo` varchar(15) NOT NULL,
  `createdBy` int(11) NOT NULL,
  `createdOn` datetime DEFAULT NULL,
  `dob` date NOT NULL,
  `firstName` varchar(60) NOT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `hobbies` longtext,
  `income` varchar(15) DEFAULT NULL,
  `lastName` varchar(60) NOT NULL,
  `maritalStatus` varchar(1) DEFAULT NULL,
  `modifiedBy` int(11) NOT NULL,
  `modifiedOn` datetime DEFAULT NULL,
  `occupation` varchar(60) DEFAULT NULL,
  `preference` varchar(45) DEFAULT NULL,
  `race` varchar(45) DEFAULT NULL,
  `religion` varchar(45) DEFAULT NULL,
  `UserID` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKelvrywf03mcqnmaf2306nk2p1` (`UserID`),
  CONSTRAINT `FKelvrywf03mcqnmaf2306nk2p1` FOREIGN KEY (`UserID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `userdetail` */

insert  into `userdetail`(`id`,`contactNo`,`createdBy`,`createdOn`,`dob`,`firstName`,`gender`,`hobbies`,`income`,`lastName`,`maritalStatus`,`modifiedBy`,`modifiedOn`,`occupation`,`preference`,`race`,`religion`,`UserID`) values (1,'9872664213',1,'2016-06-04 13:06:01','2016-05-31','spfN test','f','hobbies test','12345','lastName test','y',1,'2016-06-04 13:06:01','occupation','preference','race','religion',1);

/*Table structure for table `userfamily` */

DROP TABLE IF EXISTS `userfamily`;

CREATE TABLE `userfamily` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) NOT NULL,
  `description` longtext,
  `haveKids` varchar(10) NOT NULL,
  `kid` varchar(1) DEFAULT NULL,
  `kidsInfo` longtext,
  `createdOn` datetime NOT NULL,
  `createdBy` int(11) NOT NULL,
  `modifiedOn` datetime DEFAULT NULL,
  `modifiedBy` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userid_UNIQUE` (`userID`),
  CONSTRAINT `FKh56fc6cjbxd1c06y8l9ekci1w` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`),
  CONSTRAINT `FKswlk68jkre7fou8y49rqqss2k` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`),
  CONSTRAINT `userfamily_user_userid` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1364 DEFAULT CHARSET=utf8;

/*Data for the table `userfamily` */

insert  into `userfamily`(`id`,`userID`,`description`,`haveKids`,`kid`,`kidsInfo`,`createdOn`,`createdBy`,`modifiedOn`,`modifiedBy`) values (1,1,'description','Y','2','test data','2016-06-04 13:06:01',1,'2016-06-04 13:06:01',1);

/*Table structure for table `userinbox` */

DROP TABLE IF EXISTS `userinbox`;

CREATE TABLE `userinbox` (
  `userinboxid` int(11) NOT NULL AUTO_INCREMENT,
  `mailbody` longtext,
  `mailcc` longtext,
  `mailfrom` varchar(128) DEFAULT NULL,
  `mailread` varchar(1) NOT NULL,
  `mailto` longtext,
  `recieveddate` datetime DEFAULT NULL,
  `sentcaseid` varchar(45) DEFAULT NULL,
  `subject` longtext,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`userinboxid`),
  KEY `FKt75ek9ev313bvd4rgqbym9ju5` (`userid`),
  CONSTRAINT `FKt75ek9ev313bvd4rgqbym9ju5` FOREIGN KEY (`userid`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `userinbox` */

insert  into `userinbox`(`userinboxid`,`mailbody`,`mailcc`,`mailfrom`,`mailread`,`mailto`,`recieveddate`,`sentcaseid`,`subject`,`userid`) values (1,'Dear Foster parent\r\nThank you for taking the first step on the road to fostering and/or adopting a child .We are honored to help you in your efforts to become foster parent and build a relationship with foster child. We would be pleased to help you start your journey into the world of fostering and adoption.\r\n','admin@chhs.net','Williams.Krig@chhs.com','y','user@test.com\r\n','2016-06-07 15:26:58',NULL,'Thanks for Registering eith us!!',1),(2,'Dear Foster parent\r\nThis is a time to honor and thank the foster families who work hard every day to keep these youths safe. It is also a time to be thankful there are compassionate, loving people willing to open their hearts and homes to children in desperate need of some stability. It\'s also a time for us to think about what each of us can do to help.\r\nThanks.\r\n','admin2@chhs.net','Caroline.g@chhs.com','y','user@test.com','2016-06-07 15:28:23',NULL,'Thanks for Your Support!',1);

/*Table structure for table `userkids` */

DROP TABLE IF EXISTS `userkids`;

CREATE TABLE `userkids` (
  `userKidID` int(11) NOT NULL,
  `ageGroup` varchar(255) DEFAULT NULL,
  `hobbies` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `familyID` int(11) DEFAULT NULL,
  PRIMARY KEY (`userKidID`),
  KEY `FKhla2gcihsd50oxcyn6t9i7isj` (`familyID`),
  CONSTRAINT `FKaivnnf23m8yye84d4upwf0o89` FOREIGN KEY (`familyID`) REFERENCES `userfamily` (`id`),
  CONSTRAINT `FKhla2gcihsd50oxcyn6t9i7isj` FOREIGN KEY (`familyID`) REFERENCES `userfamily` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `userkids` */

insert  into `userkids`(`userKidID`,`ageGroup`,`hobbies`,`name`,`familyID`) values (1,'12','hobbies test','kidName1',1),(2,'12','hobbies test','kidName1',1);

/*Table structure for table `userlicence` */

DROP TABLE IF EXISTS `userlicence`;

CREATE TABLE `userlicence` (
  `id` int(11) NOT NULL,
  `agencyContact` varchar(15) DEFAULT NULL,
  `agencyWorker` varchar(20) NOT NULL,
  `createdBy` int(11) NOT NULL,
  `createdon` datetime NOT NULL,
  `dateOfIssue` date DEFAULT NULL,
  `licenceNo` varchar(45) NOT NULL,
  `modifiedBy` int(11) NOT NULL,
  `modifiedOn` datetime DEFAULT NULL,
  `UserID` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3fra28e9jyvl6wsqxxh3tscjq` (`UserID`),
  CONSTRAINT `FK3fra28e9jyvl6wsqxxh3tscjq` FOREIGN KEY (`UserID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `userlicence` */

insert  into `userlicence`(`id`,`agencyContact`,`agencyWorker`,`createdBy`,`createdon`,`dateOfIssue`,`licenceNo`,`modifiedBy`,`modifiedOn`,`UserID`) values (1,'123456789','100',1,'2016-06-04 13:06:01','2016-05-31','321456789',1,'2016-06-04 13:06:01',1);

/*Table structure for table `usersession` */

DROP TABLE IF EXISTS `usersession`;

CREATE TABLE `usersession` (
  `id` int(11) NOT NULL,
  `createdBy` int(11) NOT NULL,
  `createdOn` datetime DEFAULT NULL,
  `expiryDate` datetime DEFAULT NULL,
  `sessionId` varchar(25) NOT NULL,
  `updatedBy` int(11) NOT NULL,
  `updatedOn` datetime DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKegmcr7q83qtviatx5yd7jxifx` (`userId`),
  CONSTRAINT `FKegmcr7q83qtviatx5yd7jxifx` FOREIGN KEY (`userId`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `usersession` */

insert  into `usersession`(`id`,`createdBy`,`createdOn`,`expiryDate`,`sessionId`,`updatedBy`,`updatedOn`,`userId`) values (1,1,'2018-06-04 11:22:34','2016-06-08 23:34:21','ODXJ4f7saFFdoNqp3JRtabMXo',1,'2016-06-08 11:34:21',1);

/*Table structure for table `userspouse` */

DROP TABLE IF EXISTS `userspouse`;

CREATE TABLE `userspouse` (
  `userSpouseID` int(11) NOT NULL,
  `contactNo` varchar(15) DEFAULT NULL,
  `createdBy` int(11) NOT NULL,
  `createdOn` datetime DEFAULT NULL,
  `dob` date NOT NULL,
  `firstName` varchar(60) NOT NULL,
  `gender` varchar(1) NOT NULL,
  `hobbies` longtext,
  `preference` varchar(45) DEFAULT NULL,
  `income` varchar(15) DEFAULT NULL,
  `modifiedBy` int(11) NOT NULL,
  `modifiedOn` datetime DEFAULT NULL,
  `occupation` varchar(60) DEFAULT NULL,
  `race` varchar(45) DEFAULT NULL,
  `religion` varchar(45) DEFAULT NULL,
  `UserID` int(11) NOT NULL,
  PRIMARY KEY (`userSpouseID`),
  KEY `FK5w97xopbpjcg7jqvft304r425` (`UserID`),
  CONSTRAINT `FK5w97xopbpjcg7jqvft304r425` FOREIGN KEY (`UserID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `userspouse` */

insert  into `userspouse`(`userSpouseID`,`contactNo`,`createdBy`,`createdOn`,`dob`,`firstName`,`gender`,`hobbies`,`preference`,`income`,`modifiedBy`,`modifiedOn`,`occupation`,`race`,`religion`,`UserID`) values (399,'9876543210',1,'2016-06-04 13:06:01','2016-05-31','fnameTest','M','hobbies Test','preference','200',1,'2016-06-04 13:06:01','occupation','race','religion',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
