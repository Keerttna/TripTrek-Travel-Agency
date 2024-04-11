CREATE DATABASE TripTrekDB;
USE TripTrekDB;

CREATE TABLE Account (
    name VARCHAR(40),
    username VARCHAR(40) NOT NULL,
    password VARCHAR(8),
    security_question VARCHAR(100),
    security_answer VARCHAR(50),
    PRIMARY KEY (username)
);

DESCRIBE Account;

SELECT * FROM Account;