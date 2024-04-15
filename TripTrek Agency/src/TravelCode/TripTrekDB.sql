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
    single_bed_cost float,
    double_bed_cost float,
    ac_cost float,
    food_cost float
);

INSERT INTO Hotels_available VALUES ("Jungle Bay Resort", "Wayanad, Kerala", 920.00, 1400.00, 500, 400), ("Morickap Resort","Wayanad, Kerala", 800.00, 1360.00, 600, 300), ("Vyna Hillock Resort", "Wayanad, Kerala", 1000.00, 1500.00, 400, 400);
INSERT INTO Hotels_available VALUES ("Samruddhi Resort", "Gokarna, Karnataka", 1000.00, 1500.00, 450, 380), ("Arthigamya Hotels", "Gokarna, Karnataka", 700.00, 1100.00, 500, 400), ("Stone Wood Resort", "Gokarna, Karnataka", 850.00, 1300.00, 550, 600);  
INSERT INTO Hotels_available VALUES ("Venice Premium Houseboat", "Alleppey, Kerala", 940.00, 1300.00, 500, 540), ("Abad Turtle Beach Resort", "Alleppey, Kerala", 930.00, 1270.00, 470, 500), ("Sterling Lake Palace", "Alleppey, Kerala", 990.00, 1340.00, 490, 520);

CREATE TABLE Bookings (
    booking_id INT AUTO_INCREMENT NOT NULL,
    username VARCHAR(40) NOT NULL,
    destination VARCHAR(40),
    pickup_point VARCHAR(40),
    package_type VARCHAR(20),
    no_of_people INT,
    no_of_days INT,
    hotel VARCHAR(50) NOT NULL,
    check_in_date VARCHAR(30),
    check_out_date VARCHAR(30),
    room_type VARCHAR(50),
    ac_type VARCHAR(30),
    food VARCHAR(30),
    total_price FLOAT,
    booking_date VARCHAR(30),
    PRIMARY KEY (booking_id),
    FOREIGN KEY (username)
        REFERENCES ACCOUNT (username)
);

SELECT * FROM Bookings;

ALTER TABLE Bookings
MODIFY COLUMN booking_date VARCHAR(30);

DESCRIBE Bookings;



    
    
    
    
    

