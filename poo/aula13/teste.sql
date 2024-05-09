SHOW DATABASES;

CREATE DATABASE agenda;
USE agenda;

DROP TABLE contatos;
CREATE TABLE contatos (
	id int AUTO_INCREMENT,
	nome char(50),
	telefone char(20),
	email char(50),
	primary key(id)
);

SHOW TABLES;

DESC contatos;

INSERT INTO contatos (nome, telefone, email) 
VALUES ('Joao Silva', '(11) 1111-1111', 'joao@teste.com');

INSERT INTO contatos (nome, telefone, email) 
VALUES ('Maria Silva', '(11) 2222-2222', 'maria@teste.com');

INSERT INTO contatos (nome, telefone, email) 
VALUES ('José Santos', '(11) 3333-3333', 'jose@teste.com');

SELECT * FROM contatos;