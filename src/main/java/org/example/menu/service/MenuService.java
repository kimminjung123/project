package org.example.menu.service;

import org.example.menu.entity.Menu;
import org.example.menu.repository.MenuRepository;


import java.util.List;


public class MenuService {
    MenuRepository menuRepository = new MenuRepository();
    public int create(String menuName, int menuPrice, int ice, int syrup) {
        return this.menuRepository.create(menuName, menuPrice, ice, syrup);
    }

    public int modify(Menu menu) {
        return this.menuRepository.modify(menu);
    }

    public List<Menu> getMenuListAll() {
        return this.menuRepository.getMenuListAll();
    }

    public Menu getMenuFindById(int id) {
        return this.menuRepository.getMenuFindById(id);
    }

    public int remove(Menu menu) {
        return this.menuRepository.remove(menu);
    }
}