CREATE DATABASE EjercicioJDBC1;

USE EjercicioJDBC1;

CREATE TABLE empleados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    departamento VARCHAR(255),
    salario DOUBLE
);