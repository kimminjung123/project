create database kiosk_db;
use kiosk_db;

CREATE TABLE menu (
     id INT NOT NULL AUTO_INCREMENT,
     menuName varchar(100),
     menuPrice INT,
     ice  INT,
     syrup INT,
     PRIMARY KEY(id)
);

CREATE TABLE coupon (
     id INT NOT NULL AUTO_INCREMENT,
     phoneNumber int not NULL,
     `count` int default 0,
     PRIMARY KEY(id)
);
