package org.example.menu.service;

import org.example.menu.entity.Menu;
import org.example.menu.repository.MenuRepository;


import java.util.List;


public class MenuService {
    MenuRepository menuRepository = new MenuRepository();
    public void create(int menuId, String menuName, int menuPrice, int ice, int syrup) {
        this.menuRepository.create(menuId, menuName, menuPrice, ice, syrup);
    }

    public List<Menu> getMenuListAll() {
        return this.menuRepository.getMenuListAll();
    }
}