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

CREATE TABLE Hotels_available (
    hotel VARCHAR(50) NOT NULL,
    location VARCHAR(50),
    single_bed_cost NUMERIC(10 , 2 ),
    double_bed_cost NUMERIC(10 , 2 ),
    ac_cost NUMERIC(10 , 2 ),
    food_cost NUMERIC(10 , 2 )
);

INSERT INTO Hotels_available VALUES ("Jungle Bay Resort", "Wayanad, Kerala", 920.00, 1400.00, 500, 400), ("Morickap Resort","Wayanad, Kerala", 800.00, 1360.00, 600, 300), ("Vyna Hillock Resort", "Wayanad, Kerala", 1000.00, 1500.00, 400, 400);
INSERT INTO Hotels_available VALUES ("Samruddhi Resort", "Gokarna, Karnataka", 1000.00, 1500.00, 450, 380), ("Arthigamya Hotels", "Gokarna, Karnataka", 700.00, 1100.00, 500, 400), ("Stone Wood Resort", "Gokarna, Karnataka", 850.00, 1300.00, 550, 600);  
INSERT INTO Hotels_available VALUES ("Venice Premium Houseboat", "Alleppey, Kerala", 940.00, 1300.00, 500, 540), ("Abad Turtle Beach Resort", "Alleppey, Kerala", 930.00, 1270.00, 470, 500), ("Sterling Lake Palace", "Alleppey, Kerala", 990.00, 1340.00, 490, 520);

SELECT * FROM Hotels_available;

DESCRIBE Account;

SELECT * FROM Account;

