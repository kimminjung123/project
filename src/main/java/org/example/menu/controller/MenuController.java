package org.example.menu.controller;

import org.example.Container;
import org.example.menu.entity.Menu;
import org.example.menu.service.MenuService;

import java.util.List;

public class MenuController {

    MenuService menuService = new MenuService();

    String menuName = ""; //메뉴 이름
    int menuPrice = 0; // 메뉴 가격
    int total = 0; //주문총액


    public void order() {

        while (true) {
            System.out.println("1. 커피");
            System.out.println("2. 논커피");
            System.out.println("3. 디저트");

            System.out.print("입력: ");
            int menuPick = Container.getSc().nextInt();
            Container.getSc().nextLine();

            if (menuPick == 1) {
                System.out.println("1. 아메리카노\t3800원");
                System.out.println("2. 에스프레소\t2400원");
                System.out.println("3. 카페라떼\t4200원");

                System.out.print("입력: ");
                int menuNum = Container.getSc().nextInt();

                if (menuNum == 1) {
                    menuName = "아메리카노";
                    menuPrice = 3800;
                } else if (menuNum == 2) {
                    menuName = "에스프레소";
                    menuPrice = 2400;
                } else if (menuNum == 3) {
                    menuName = "카페라떼";
                    menuPrice = 4200;
                }
                System.out.println("얼음량을 선택해 주세요");
                System.out.println("1. 100%");
                System.out.println("2. 70%");
                System.out.println("3. 50%");
                System.out.println("4. 넣지않음");

                System.out.print("얼음량: ");
                int ice = Container.getSc().nextInt();

                System.out.println("시럽횟수를 선택해 주세요");
                System.out.println("1. 1번");
                System.out.println("2. 2번");
                System.out.println("3. 3번");
                System.out.println("4. 넣지않음");

                System.out.print("시럽횟수: ");
                int syrup = Container.getSc().nextInt();
                Container.getSc().nextLine();

                System.out.println(menuName + "을(를) 장바구니에 담았습니다.");

                menuService.create(menuName, menuPrice, ice, syrup);

                total += menuPrice;

            } else if (menuPick == 2) {
                System.out.println("1. 밀크티\t5100원");
                System.out.println("2. 딸기스무디\t5500원");
                System.out.println("3. 망고스무디\t5600원");
                System.out.println("4. 블루베리스무디\t6000원");

                System.out.print("입력: ");
                int menuNum = Container.getSc().nextInt();
                Container.getSc().nextLine();

                if (menuNum == 1) {
                    menuName = "밀크티";
                    menuPrice = 5100;
                } else if (menuNum == 2) {
                    menuName = "딸기스무디";
                    menuPrice = 5500;
                } else if (menuNum == 3) {
                    menuName = "망고스무디";
                    menuPrice = 5600;
                } else if (menuNum == 4) {
                    menuName = "블루베리스무디";
                    menuPrice = 6000;
                }
                System.out.println("얼음량을 선택해 주세요");
                System.out.println("1. 100%");
                System.out.println("2. 70%");
                System.out.println("3. 50%");
                System.out.println("4. 넣지않음");

                System.out.print("얼음량: ");
                int ice = Container.getSc().nextInt();
                Container.getSc().nextLine();

                System.out.println("시럽횟수를 선택해 주세요");
                System.out.println("1. 1번");
                System.out.println("2. 2번");
                System.out.println("3. 3번");
                System.out.println("4. 넣지않음");

                System.out.print("시럽횟수: ");
                int syrup = Container.getSc().nextInt();
                Container.getSc().nextLine();

                int id = menuService.create(menuName, menuPrice, ice, syrup);

                System.out.println(menuName + "(주문번호:" + id + ")을(를) 장바구니에 담았습니다.");

                total += menuPrice;

            } else if (menuPick == 3) {
                System.out.println("1. 마카롱\t3000원");
                System.out.println("2. 케이크\t5000원");
                System.out.println("3. 쿠키\t1000원");

                System.out.print("입력: ");
                int menuNum = Container.getSc().nextInt();
                Container.getSc().nextLine();

                if (menuNum == 1) {
                    menuName = "마카롱";
                    menuPrice = 3000;
                } else if (menuNum == 2) {
                    menuName = "케이크";
                    menuPrice = 5000;
                } else if (menuNum == 3) {
                    menuName = "쿠키";
                    menuPrice = 1000;
                }
                int ice = 0;
                int syrup = 0;

                System.out.println(menuName + "을(를) 장바구니에 담았습니다.");

                menuService.create(menuName, menuPrice, ice, syrup);

                total += menuPrice;

            }
            break;
        }

    }

    public void option() {
        System.out.println("옵션 변경 할 메뉴 번호를 입력해 주세요!");

        List<Menu> menuList = this.menuService.getMenuListAll();
        for (Menu menu : menuList) {
            System.out.printf("%d,%s(얼음:%d / 시럽:%d) = %d \n", menu.getId(), menu.getMenuName(), menu.getIce(), menu.getSyrup(), menu.getMenuPrice());
        }


        System.out.print("변경할 메뉴: ");
        int id = Container.getSc().nextInt();
        Container.getSc().nextLine();

        Menu menu = this.menuService.getMenuFindById(id);

        System.out.print("얼음량: ");
        int ice = Container.getSc().nextInt();
        Container.getSc().nextLine();

        menu.setIce(ice);
        System.out.print("시럽횟수: ");
        int syrup = Container.getSc().nextInt();
        Container.getSc().nextLine();
        menu.setSyrup(syrup);

        int modifyId = this.menuService.modify(menu);

        System.out.println(modifyId + "번 메뉴 옵션이 변경 되었습니다.");

    }

    public void Cart() {
        List<Menu> menuList = this.menuService.getMenuListAll();
        System.out.println("== 장바구니 ==");

        if (menuList.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
        } else {
            for (Menu menu : menuList) {
                if (menu.getIce() == 0 && menu.getSyrup() == 0) {
                    System.out.printf("%d. %s %d원 \n", menu.getId(), menu.getMenuName(), menu.getMenuPrice());
                } else {
                    System.out.printf("%d. %s(얼음:%d / 시럽 : %d) %d원 \n", menu.getId(), menu.getMenuName(), menu.getIce(), menu.getSyrup(), menu.getMenuPrice());
                }
            }
        }
    }

    public void cancel() {
        List<Menu> menuList = this.menuService.getMenuListAll();
        System.out.println("== 장바구니 ==");

        if (menuList.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");

        } else {
            for (Menu menu : menuList) {
                System.out.printf("%d,%s(%d,%d): %d \n", menu.getId(), menu.getMenuName(), menu.getIce(), menu.getSyrup(), menu.getMenuPrice());
            }
            System.out.print("취소할 메뉴 번호: ");
            int id = Container.getSc().nextInt();
            Container.getSc().nextLine();

            Menu menu = this.menuService.getMenuFindById(id);

            this.menuService.remove(menu);

            System.out.println(id + "번 메뉴가 취소되었습니다.");
        }

    }

    public void payment() {
        System.out.println("결제할 금액: " + total + "원");
        System.out.print("지불할  금액: ");
        int money = Container.getSc().nextInt();
        Container.getSc().nextLine();
        if (money < total) {
            System.out.println("금액이 부족합니다.");

        } else {
            System.out.println("잔돈은 " + (money - total) + "원 입니다.");
//            total = 0;
//            menuList = null;
            System.out.println("이용해 주셔서 감사합니다.");
        }

    }

}