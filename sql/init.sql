-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-10-03 03:10:05.778

-- tables
-- Table: categoria
CREATE DATABASE empresa;
USE empresa;

CREATE TABLE categoria (
    categoria_id int NOT NULL AUTO_INCREMENT,
    categoria varchar(50) NOT NULL,
    CONSTRAINT categoria_pk PRIMARY KEY (categoria_id)
);

-- Table: entrega
CREATE TABLE entrega (
    entrega_id int NOT NULL AUTO_INCREMENT,
    fecha date NOT NULL,
    total double(8,2) NOT NULL,
    propietario varchar(50) NOT NULL,
    fecha_entrega date NOT NULL,
    usuario_user_id int NOT NULL,
    CONSTRAINT entrega_pk PRIMARY KEY (entrega_id)
);

-- Table: mueble
CREATE TABLE mueble (
    mueble_id int NOT NULL AUTO_INCREMENT,
    nombre varchar(50) NOT NULL,
    color varchar(50) NOT NULL,
    cantidad int NOT NULL,
    estado boolean NOT NULL,
    categoria_categoria_id int NOT NULL,
    CONSTRAINT mueble_pk PRIMARY KEY (mueble_id)
);

-- Table: mueble_has_entrega
CREATE TABLE mueble_has_entrega (
    entrega_entrega_id int NOT NULL,
    mueble_mueble_id int NOT NULL,
    CONSTRAINT mueble_has_entrega_pk PRIMARY KEY (entrega_entrega_id,mueble_mueble_id)
);

-- Table: rol
CREATE TABLE rol (
    rol_id int NOT NULL,
    rol_name varchar(50) NOT NULL,
    CONSTRAINT rol_pk PRIMARY KEY (rol_id)
);

-- Table: usuario
CREATE TABLE usuario (
    user_id int NOT NULL AUTO_INCREMENT,
    nombre varchar(50) NOT NULL,
    telefono int NOT NULL,
    direccion varchar(50) NOT NULL,
    user varchar(50) NOT NULL,
    password varchar(300) NOT NULL,
    estado boolean NOT NULL,
    CONSTRAINT user_id PRIMARY KEY (user_id)
);

-- Table: usuario_has_rol
CREATE TABLE usuario_has_rol (
    usuario_user_id int NOT NULL,
    rol_rol_id int NOT NULL,
    CONSTRAINT usuario_has_rol_pk PRIMARY KEY (usuario_user_id,rol_rol_id)
);

-- foreign keys
-- Reference: entrega_usuario (table: entrega)
ALTER TABLE entrega ADD CONSTRAINT entrega_usuario FOREIGN KEY entrega_usuario (usuario_user_id)
    REFERENCES usuario (user_id);

-- Reference: mueble_categoria (table: mueble)
ALTER TABLE mueble ADD CONSTRAINT mueble_categoria FOREIGN KEY mueble_categoria (categoria_categoria_id)
    REFERENCES categoria (categoria_id);

-- Reference: mueble_has_entrega_entrega (table: mueble_has_entrega)
ALTER TABLE mueble_has_entrega ADD CONSTRAINT mueble_has_entrega_entrega FOREIGN KEY mueble_has_entrega_entrega (entrega_entrega_id)
    REFERENCES entrega (entrega_id);

-- Reference: mueble_has_entrega_mueble (table: mueble_has_entrega)
ALTER TABLE mueble_has_entrega ADD CONSTRAINT mueble_has_entrega_mueble FOREIGN KEY mueble_has_entrega_mueble (mueble_mueble_id)
    REFERENCES mueble (mueble_id);

-- Reference: usuario_has_rol_rol (table: usuario_has_rol)
ALTER TABLE usuario_has_rol ADD CONSTRAINT usuario_has_rol_rol FOREIGN KEY usuario_has_rol_rol (rol_rol_id)
    REFERENCES rol (rol_id);

-- Reference: usuario_has_rol_usuario (table: usuario_has_rol)
ALTER TABLE usuario_has_rol ADD CONSTRAINT usuario_has_rol_usuario FOREIGN KEY usuario_has_rol_usuario (usuario_user_id)
    REFERENCES usuario (user_id);

-- End of file.

insert into categoria (categoria_id,categoria) values (1,"Ropero"),(2,"Escritorio"),(3,"Peinador");
insert into rol(rol_id,rol_name) values (1,"USER"),(2,"ADMIN"),(3,"MANAGER");