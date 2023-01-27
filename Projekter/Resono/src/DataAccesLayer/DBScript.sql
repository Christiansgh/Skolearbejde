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
	usertype BIT,
    PRIMARY KEY (id)
);

-- Assignments
CREATE TABLE Assignments (
	id INT IDENTITY(1, 1),
	title VARCHAR(256),
	creator_fn VARCHAR(128),
	creator_ln VARCHAR(128),
	description VARCHAR(4096),
    PRIMARY KEY(id)
);

-- Tags
CREATE TABLE Tags (
	id INT IDENTITY(1, 1),
	text VARCHAR(12),
	color VARCHAR(12),
	stroke_color VARCHAR(12),
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

INSERT INTO Tags
(text, color, stroke_color)
VALUES
('Tag1', '#F7F7F7', '#000000'),
('DMU', '#8AA8AE', '#F7F7F7'),
('Inspiration', '#37474', '#F7F7F7'),
('DoIt', '#000000', '#F7F7F7'),
('Test', '#313131', '#F7F7F7');

INSERT INTO Tags
(text, color, stroke_color)
VALUES
('Tag1', '#F7F7F7', '#000000'),
('DMU', '#8AA8AE', '#F7F7F7'),
('Inspiration', '#37474', '#F7F7F7'),
('DoIt', '#000000', '#F7F7F7'),
('Test', '#313131', '#F7F7F7');

INSERT INTO Assignments
(title, creator_fn, creator_ln, description)
VALUES
('Opgave 1', 'C', 'A', 'Gå en tur'),
('Dag 1', 'FK', 'J', 'Spil Minecraft en time'),
('Kursus 1', 'JP', 'N', 'Sig nihao til XBI'),
('Øvelse 1', 'XB', 'I', 'Kald Jan for Peter Plys'),
('Video 1', 'A', 'N', 'Spis en omgang pinto');