create database kiosk_db;
use kiosk_db;

CREATE TABLE menu (
     id INT NOT NULL AUTO_INCREMENT,
     name     VARCHAR(50),
     price    VARCHAR(50),
     regDate  DATETIME,
     PRIMARY KEY(id)
)

CREATE TABLE menu_category (
     id INT NOT NULL AUTO_INCREMENT,
     product_id INT,
     name     VARCHAR(50),
     regDate  DATETIME,
     PRIMARY KEY(id)
)

create table menu_options (
     id INT NOT NULL AUTO_INCREMENT,
     product_id INT,
     name     VARCHAR(50),
     regDate  DATETIME,
     PRIMARY KEY(id)
)


create table carts (
     id INT NOT NULL AUTO_INCREMENT,
     product_id INT,
     user_id INT,
     option_id INT,
     regDate  DATETIME,
     PRIMARY KEY(id)
)


create table `users` (
	 id INT NOT NULL AUTO_INCREMENT,
	 phone_number varchar(100),
	 nickname varchar(100),
	 coupon_count INT,
	 regDate  DATETIME,
	 PRIMARY KEY(id)
)
