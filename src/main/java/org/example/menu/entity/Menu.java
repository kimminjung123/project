package org.example.menu.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Menu {
    private int id;
    private String menuName;
    private int menuPrice;
    private int ice;
    private int syrup;

    public Menu(Map<String, Object> row) {
        this.id = (int)row.get("id");
        this.menuName = (String)row.get("menuName");
        this.menuPrice = (int)row.get("menuPrice");
        this.ice = (int)row.get("ice");
        this.syrup = (int)row.get("syrup");
    }
}