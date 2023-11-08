-- 데이터베이스 생성
DROP DATABASE IF EXISTS Coffee;
CREATE DATABASE IF NOT EXISTS Coffee;
USE Coffee;

-- 메뉴 테이블 생성
CREATE TABLE IF NOT EXISTS Menu (
    menuId INT AUTO_INCREMENT PRIMARY KEY,
    MenuMain VARCHAR(300) NOT NULL,
    menuName VARCHAR(255) NOT NULL,
    menuPrice INT NOT NULL
    );

-- 메뉴 추가
INSERT INTO Menu (MenuMain, menuName, menuPrice) VALUES ('커피','아메리카노', 3800);
INSERT INTO Menu (MenuMain, menuName, menuPrice) VALUES ('커피','카페라떼', 4200);
INSERT INTO Menu (MenuMain, menuName, menuPrice) VALUES ('커피','에스프레소', 2400);
INSERT INTO Menu (MenuMain, menuName, menuPrice) VALUES ('논커피','밀크티', 5100);
INSERT INTO Menu (MenuMain, menuName, menuPrice) VALUES ('논커피','딸기스무디', 5500);
INSERT INTO Menu (MenuMain, menuName, menuPrice) VALUES ('논커피','망고스무디', 5600);
INSERT INTO Menu (MenuMain, menuName, menuPrice) VALUES ('논커피','블루베리스무디', 6000);
INSERT INTO Menu (MenuMain, menuName, menuPrice) VALUES ('디저트','마카롱', 3000);
INSERT INTO Menu (MenuMain, menuName, menuPrice) VALUES ('디저트','케이크', 5000);
INSERT INTO Menu (MenuMain, menuName, menuPrice) VALUES ('디저트','쿠키', 1000);

-- 메뉴 조회
DROP table UserCoupons;
SELECT * FROM UserCoupons;

CREATE TABLE IF NOT EXISTS coupon (
    id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    phoneNumber VARCHAR(255) NOT NULL UNIQUE,
    couponCount INT NOT NULL DEFAULT 0
    );

-- 만약 phoneNumber가 이미 존재한다면, couponCount를 증가시킵니다.
-- 만약 phoneNumber가 존재하지 않는다면 새 레코드를 삽입합니다.
INSERT INTO coupon (phoneNumber, couponCount)
VALUES (@phoneNumber, 1)
ON DUPLICATE KEY UPDATE couponCount = couponCount + 1, phoneNumber = phoneNumber;
