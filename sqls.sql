CREATE DATABASE livraria;

USE livraria;

-- Tabela de escritores
CREATE TABLE escritor (
    id_autor INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    idade INT NOT NULL
);

-- Tabela de livros
CREATE TABLE livro (
    id_livro INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    id_autor INT NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    editora VARCHAR(100),
    ano_publicacao INT,
    FOREIGN KEY (id_autor) REFERENCES escritor(id_autor) ON DELETE RESTRICT ON UPDATE CASCADE
);