package org.example.menu.repository;

import org.example.Container;
import org.example.db.DBConnection;
import org.example.menu.entity.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuRepository {
    private DBConnection dbConnection;

    public MenuRepository () {
        dbConnection = Container.getDBconnection();
    }
    public int create(String menuName, int menuPrice, int ice, int syrup) {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("INSERT INTO menu "));
        sb.append(String.format("SET menuName = '%s', ", menuName));
        sb.append(String.format("menuPrice = '%s', ", menuPrice));
        sb.append(String.format("ice = '%s', ", ice));
        sb.append(String.format("syrup = %s ", syrup));

        int id = dbConnection.insert(sb.toString());

        return id;
    }


    public List<Menu> getMenuListAll() {
        List<Menu> menuList = new ArrayList<>();

        String sql = "SELECT * FROM menu";
        List<Map<String, Object>> rows = dbConnection.selectRows(sql);

        for (Map<String, Object> row : rows) {
            Menu menu = new Menu(row);

            menuList.add(menu);
        }
        return menuList;
    }

    public int modify(Menu menu) {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("UPDATE menu "));
        sb.append(String.format("SET ice = %s, ", menu.getIce()));
        sb.append(String.format("syrup = %s ", menu.getSyrup()));
        sb.append(String.format("WHERE id = %s ", menu.getId()));

        int id = dbConnection.update(sb.toString());

        return id;
    }

    public Menu getMenuFindById(int id) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT * "));
        sb.append(String.format("FROM menu "));
        sb.append(String.format("WHERE id = %s ", id));

        Map<String, Object> row = dbConnection.selectRow(sb.toString());

        Menu menu = new Menu(row);

        return menu;
    }

    public int remove(Menu menu) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("DELETE FROM menu "));
        sb.append(String.format("WHERE id = %s ", menu.getId()));

        int id = dbConnection.delete(sb.toString());

        return id;
    }
}