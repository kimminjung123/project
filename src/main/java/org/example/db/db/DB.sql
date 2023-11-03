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
SELECT * FROM Menu;

DECLARE @phoneNumber VARCHAR(255);
SET @phoneNumber = '사용자의_전화번호';

-- 사용자가 가지고 있는 쿠폰 개수 확인
SELECT CouponCount INTO @couponCount FROM UserCoupons WHERE PhoneNumber = @phoneNumber;

-- 쿠폰 적립
IF @couponCount < 10 THEN
    INSERT INTO UserCoupons (PhoneNumber, CouponCount)
    VALUES (@phoneNumber, 1)
    ON DUPLICATE KEY UPDATE CouponCount = CouponCount + 1;
ELSE
    INSERT INTO UserCoupons (PhoneNumber, CouponCount)
    VALUES (@phoneNumber, 1)
    ON DUPLICATE KEY UPDATE CouponCount = 1;
END IF;

-- 적립 후 쿠폰 개수 반환
SELECT CouponCount FROM UserCoupons WHERE PhoneNumber = @phoneNumber;