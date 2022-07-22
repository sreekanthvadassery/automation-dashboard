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
