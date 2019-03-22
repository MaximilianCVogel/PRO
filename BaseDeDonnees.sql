-- *********************************************
-- * Standard SQL generation                   
-- *--------------------------------------------             
-- * Generation date: Fri Mar 22 09:51:13 2019 
-- ********************************************* 
-- Database Section
-- ________________ 
DROP DATABASE IF EXISTS SmartReveil;
CREATE DATABASE SmartReveil;
USE SmartReveil;
-- DBSpace Section
-- _______________
-- Tables Section
-- _____________ 
CREATE TABLE Alarme (     
	id NUMERIC AUTO_INCREMENT,     
	heureReveil TIME NOT NULL,     
	dateReveil DATE NOT NULL,     
	isSmart CHAR NOT NULL,     
	fkUser CHAR NOT NULL,     
	fkTemplate VARCHAR(30) NOT NULL,    
	CONSTRAINT ID_Alarme_ID PRIMARY KEY (id)
);
	
CREATE TABLE UserGroup (     
	fkGroup NUMERIC NOT NULL,     
	fkUser NUMERIC NOT NULL,     
	admininstrateur BOOLEAN NOT NULL,     
	CONSTRAINT ID_UserGroup PRIMARY KEY (fkGroup, fkUser)
);

CREATE TABLE Groupe (     
	id NUMERIC AUTO_INCREMENT,     
	nom VARCHAR(42) NOT NULL,    
	CONSTRAINT ID_Groupe_ID PRIMARY KEY (id)
);

CREATE TABLE Notification (     
	id NUMERIC AUTO_INCREMENT,     
	message VARCHAR(200) NOT NULL,  
	dateGeneration DATETIME NOT NULL,     
	fkAlarme NUMERIC NOT NULL,     
	CONSTRAINT ID_Notification_ID PRIMARY KEY (id)
);

CREATE TABLE Template (     
	id VARCHAR(30) NOT NULL,     
	CONSTRAINT ID_Template_ID PRIMARY KEY (id)
);

CREATE TABLE Utilisateur (    
	id NUMERIC AUTO_INCREMENT,    
	email VARCHAR(42) NOT NULL,   
	userName varCHAR(42) NOT NULL,     
	CONSTRAINT ID_Utilisateur_ID PRIMARY KEY (id)
);

-- Constraints Section
-- ___________________ 
ALTER TABLE Alarme 
	ADD CONSTRAINT FKutilise_le_template_FK     
	FOREIGN KEY (fkTemplate)     
	REFERENCES Template (id) 
	ON UPDATE CASCADE;

ALTER TABLE Alarme 
	ADD CONSTRAINT FKconfigure_FK     
	FOREIGN KEY (fkUser)     
	REFERENCES Utilisateur (id)
	ON UPDATE CASCADE;
	
ALTER TABLE GroupUser 
	ADD CONSTRAINT FKfai_Uti_FK     
	FOREIGN KEY (idUser)     
	REFERENCES Utilisateur (id) 
	ON UPDATE CASCADE;
	
ALTER TABLE GroupUser 
	ADD CONSTRAINT FKfai_Gro_FK   
	FOREIGN KEY (idGroup)     
	REFERENCES Groupe (id) 
	ON UPDATE CASCADE;
	
ALTER TABLE Notification
	ADD CONSTRAINT FKgenere_des_NOTifications_FK  
	FOREIGN KEY (fkAlarme)     
	REFERENCES Alarme (id) 
	ON UPDATE CASCADE;
	