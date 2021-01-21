CREATE DATABASE encurtadorURLJSF_db;

CREATE USER 'encurtadorURLJSF_db_user'@'localhost' IDENTIFIED BY 'p@ssw0rd';

GRANT ALL ON encurtadorURLJSF_db.* TO 'encurtadorURLJSF_db_user'@'localhost';

CREATE TABLE encurtadorURLJSF_db.Usuario (
	id INT UNSIGNED auto_increment NOT NULL,
	login varchar(50) NOT NULL,
	senha varchar(50) NOT NULL,
	nome varchar(100) NOT NULL,
	CONSTRAINT Usuario_PK PRIMARY KEY (id)
);

CREATE TABLE encurtadorURLJSF_db.UrlEncurtada (
	id INT UNSIGNED auto_increment NOT NULL,
	urlOriginal varchar(1000) NOT NULL,
	urlEncurtada varchar(100) NOT NULL,
	dataProcessamento DATETIME NOT NULL,
	usuario INT UNSIGNED NOT NULL,
	CONSTRAINT UrlEncurtada_PK PRIMARY KEY (id),
	CONSTRAINT UrlEncurtada_Usuario_FK FOREIGN KEY (usuario) REFERENCES encurtadorURLJSF_db.Usuario(id)
);

INSERT INTO encurtadorURLJSF_db.Usuario
(login, senha, nome)
VALUES('daniel', 'e8d95a51f3af4a3b134bf6bb680a213a', 'Daniel Galvão'); -- senha = senha

INSERT INTO encurtadorURLJSF_db.Usuario
(login, senha, nome)
VALUES('bill', '5f4dcc3b5aa765d61d8327deb882cf99', 'Bill Gates'); -- senha = password

INSERT INTO encurtadorURLJSF_db.Usuario
(login, senha, nome)
VALUES('jobs', '5ebe2294ecd0e0f08eab7690d2a6ee69', 'Steve Jobs'); -- senha = secret


