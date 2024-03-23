create database TripTrek;
use TripTrek;

-- create table for signup class
create table account(username varchar(30), name varchar(40), password varchar(30), security_question varchar(100), security_answer varchar(50));

-- create table to add new customer in new customer class
create table customer(username varchar(30), id_type varchar(20), id_number varchar(20), name varchar(30), 
gender varchar(15), country varchar(20), address varchar(50), phone varchar(20), email varchar(40));

-- create table to add hotels
create table hotels(hotel_name varchar(30), cost_per_day varchar(20), food_charges varchar(20), ac_charges varchar(20));

-- create table for booking hotel
create table bookHotel(username varchar(30), hotel_name varchar(30), persons varchar(20), days varchar(20), ac varchar(10), 
food varchar(10), id_type varchar(20), id_number varchar(20), phone varchar(20), cost varchar(20));

-- create table for package booking
create table bookPackage(username varchar(30), package varchar(40), persons varchar(20), id_type varchar(20), id_number varchar(20), 
phone varchar(20), package_price varchar(20));

show tables;

select * from account;

-- insert value in the hotel table
insert into hotels values("JW Marriott Hotel", "2000", "2500", "3000");
insert into hotels values("Four Seasons Hotel", "1200", "1900", "2200");

select * from hotels;


