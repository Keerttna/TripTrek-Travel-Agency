CREATE DATABASE TripTrek;
USE TripTrek;

-- Create table for signup of new user
CREATE TABLE Account (
    customer_id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(40),
    password VARCHAR(8),
    security_question VARCHAR(100),
    security_answer VARCHAR(50),
    PRIMARY KEY (customer_id)
);
-- Create table for adding & updating customer details
CREATE TABLE Customer (
    customer_id INT NOT NULL UNIQUE,
    name VARCHAR(30),
    id_type VARCHAR(20),
    id_no VARCHAR(20),
    gender VARCHAR(15),
    address VARCHAR(50),
    phone VARCHAR(20),
    email VARCHAR(40),
    FOREIGN KEY (customer_id)
        REFERENCES Account (customer_id)
);
    
-- Create table to add hotels details
CREATE TABLE Hotels_Available (
    hotel_id INT AUTO_INCREMENT NOT NULL,
    hotel_name VARCHAR(30),
    hotel_address VARCHAR(100),
    cost_per_day VARCHAR(20),
    food_charges VARCHAR(20),
    ac_charges VARCHAR(20),
    PRIMARY KEY (hotel_id)
);

-- Create table for booking hotel
CREATE TABLE Book_Hotel (
    customer_id INT,
    hotel_booking_id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(30),
    hotel_id INT,
    no_of_persons INT,
    check_in DATE,
    check_out DATE,
    no_of_days INT,
    ac VARCHAR(10),
    food VARCHAR(10),
    total_hotel_cost VARCHAR(20),
    PRIMARY KEY (hotel_booking_id),
    FOREIGN KEY (customer_id)
        REFERENCES Account (customer_id),
    FOREIGN KEY (hotel_id)
        REFERENCES Hotels_Available (hotel_id)
);
    
-- Create table for booking package
CREATE TABLE Book_Package (
    package_booking_id INT AUTO_INCREMENT NOT NULL,
    package_type VARCHAR(40),
    customer_id INT,
    hotel_booking_id INT,
    no_of_persons INT,
    phone VARCHAR(20),
    source VARCHAR(50),
    destination VARCHAR(50),
    start_date DATE,
    end_date DATE,
    total_price VARCHAR(20),
    PRIMARY KEY (package_booking_id),
    FOREIGN KEY (customer_id)
        REFERENCES Account (customer_id),
    FOREIGN KEY (hotel_booking_id)
        REFERENCES Book_Hotel (hotel_booking_id)
);
    
SHOW TABLES;

DESCRIBE Account;

DESCRIBE Customer;

DESCRIBE Hotels_Available;

DESCRIBE Book_Hotel;




DESCRIBE Book_Package;








INSERT INTO Account(name, password, security_question, security_answer)
	VALUES('Keerttna', '123', 'Favourite fruit' , 'Mango'),
		('Saranya', '456', 'Birth place', 'Chennai');   
        
	SELECT * FROM Account;
        
        
        
        
        
        
        
        
        
        

SELECT * FROM Account WHERE customer_id = 1;

INSERT INTO Hotels_Available (hotel_name, hotel_address, cost_per_day , food_charges, ac_charges) 
VALUES('Sunshine', 'Patna','3000', '100', '300'),
('Riverdale', 'Patna', '2800','200','300'),
('Amazing Resorts', 'Mumbai', '3400', '250', '300'); 

SELECT * FROM Hotels_Available;






DELETE FROM Hotels_Available WHERE hotel_id = 2;
SELECT * FROM Hotels_Available;







SELECT * FROM Hotels_Available WHERE hotel_city = 'Patna';


UPDATE Account SET password = '987' WHERE customer_id = 1;
SELECT * FROM Account;
















ALTER TABLE Hotels_Available RENAME COLUMN hotel_address TO hotel_city;
SELECT * FROM Hotels_Available; 
    
    

        

    
    
