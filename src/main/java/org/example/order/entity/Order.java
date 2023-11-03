package org.example.order.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

class Order {
    private int menuId;
    private String menuName;
    private int menuPrice;
    private int ice;
    private int syrup;
}