package org.example.menu.repository;

import org.example.menu.entity.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    List<Menu> menuList = new ArrayList<>(); //장바구니

    public void create(int menuId, String menuName, int menuPrice, int ice, int syrup) {
        Menu menu = new Menu(menuId, menuName, menuPrice, ice, syrup);
        menuList.add(menu);
    }

    public List<Menu> getMenuListAll() {
        return menuList;
    }
}