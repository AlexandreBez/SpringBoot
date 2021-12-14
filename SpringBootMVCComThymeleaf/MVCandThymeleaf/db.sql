CREATE DATABASE demo_mvc;

USE demo_mvc;

CREATE Table departamos(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(60)
);

CREATE Table cargos(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(60)
);