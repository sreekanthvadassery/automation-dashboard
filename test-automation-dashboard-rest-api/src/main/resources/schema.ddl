-------------------------------------------------------------------------------------------------------------------------------
CREATE SCHEMA `automation_dashboard` ;
-------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE automation_dashboard.project (
  projectId INT(11) NOT NULL AUTO_INCREMENT,
  projectName VARCHAR(50) NOT NULL,
  projectDescription VARCHAR(150) NULL DEFAULT NULL,
  enabled TINYINT(4) NULL DEFAULT 1,
  createdAt DATETIME NULL DEFAULT NULL,
  updatedAt DATETIME NULL DEFAULT NULL,
  lastUpdatedBy VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (projectId));
-------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE `automation_dashboard`.`user` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(100) NOT NULL,
  `lastName` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `phoneNumber` VARCHAR(100) NULL DEFAULT NULL,
  `username` VARCHAR(100) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `verifyPassword` VARCHAR(200) NOT NULL,
  `enabled` TINYINT NULL DEFAULT '1',
  `createdAt` DATETIME NULL DEFAULT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `lastUpdatedBy` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);
-------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE `automation_dashboard`.`role` (
  `roleId` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(50) NOT NULL,
  `roleDescription` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`roleId`));
-------------------------------------------------------------------------------------------------------------------------------
  
