USE master;

IF DB_ID('resono') IS NOT NULL
DROP DATABASE resono;

--invariant master selected & resono doesn't exist.

CREATE DATABASE resono;
GO

USE resono;

-- Logins
CREATE TABLE Logins (
	id INT IDENTITY(1000, 1),
	username VARCHAR(256),
	password VARCHAR(512),
	user_type BIT,
    PRIMARY KEY (id)
);

-- Persons
CREATE TABLE Persons (
	cpr INT,
	fornavn VARCHAR(256),
	efternavn VARCHAR(256),
	login_id INT FOREIGN KEY REFERENCES Logins(id),
    PRIMARY KEY (cpr)
);

-- Telephones
CREATE TABLE Telephones (
	cpr INT FOREIGN KEY REFERENCES Persons(cpr),
	number INT,
    PRIMARY KEY (number)-- CONSIDER: Does this really need to be a primaary key?
);

-- Emails
-- TODO: C-PK in diagram?
CREATE TABLE Emails (
	cpr INT FOREIGN KEY REFERENCES Persons(cpr),
	email VARCHAR(256) 
    PRIMARY KEY(email) -- CONSIDER: Does this really need to be a primaary key?
);

-- Addresses
CREATE TABLE Addresses (
	cpr INT FOREIGN KEY REFERENCES Persons(cpr),
	street_address VARCHAR(512),
	country VARCHAR(256),
	city VARCHAR(256)
	-- CONSIDER: Postcode? Maybe even instead of city?
);

-- CONSIDER: Maybe Assignment and AssignmentContent can be merged?
-- Assignments
CREATE TABLE Assignments (
	id INT IDENTITY(1, 1), -- AUTO INCREMENT,
	title VARCHAR(512),
	description TEXT,
	is_active BIT -- CONSIDER: BIT for boolean or perhaps rename to "status" and use ENUM
    PRIMARY KEY(id)
);

-- AssignedAssignments
CREATE TABLE AssignedAssignments (
	assignment_id INT FOREIGN KEY REFERENCES Assignments(id),
	login_id INT FOREIGN KEY REFERENCES Persons(cpr),
	status VARCHAR(256)
);

-- AssignmentContent
CREATE TABLE AssignmentContent (
	id INT IDENTITY(1, 1), -- AUTO INCREMENT,
	assignment_id INT FOREIGN KEY REFERENCES Assignments(id),
	content TEXT,
	type TEXT
    PRIMARY KEY(id)
);

--==================================
--       DUMMY DATA
--==================================
INSERT INTO Logins 
(username, password, user_type)
VALUES
('Flemming', 'MinecraftMaster123', 1),
('Xiaolei', 'MMD', 1),
('Jan', 'ILoveServers', 1),
('Christian', '1', 0),
('Philip', '12', 0),
('Benjamin', '123', 0),
('Aksel', '1234', 0);


