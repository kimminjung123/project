package org.example;

import org.example.coupon.controller.CouponController;
import org.example.db.DBConnection;
import org.example.menu.controller.MenuController;


public class App {
    public App () {
        DBConnection.DB_NAME = "kiosk_db";
        DBConnection.DB_USER = "root";
        DBConnection.DB_PASSWORD = "";
        DBConnection.DB_PORT = 3306;

        Container.getDBconnection().connect();
    }
    SystemController systemController = new SystemController();
    MenuController menuController = new MenuController();
    CouponController couponController = new CouponController();

    void run() {

        label:
        while (true) {
            System.out.println("☆★☆★ 얼어죽어도 아이스만 ☆★☆★");
            System.out.println("1. 주문하기");
            System.out.println("2. 메뉴옵션변경");
            System.out.println("3. 장바구니");
            System.out.println("4. 취소하기");
            System.out.println("5. 쿠폰 적립하기");
            System.out.println("6. 결제하기");
            System.out.println("7. 종료하기");
            System.out.print("입력: ");
            int num = Container.getSc().nextInt();

            switch (num) {
                case 1:
                    menuController.order();
                    break;

                case 2:
                    menuController.option();
                    break;

                case 3:
                    menuController.Cart();
                    break;

                case 4:
                    menuController.cancel();
                    break;

                case 5:
                    couponController.coupon();
                    break;
                case 6:
                    menuController.payment();
                    return;
                case 7:
                    systemController.exit();
                    return;
            }
        }
    }
}