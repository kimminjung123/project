package org.example.coupon.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Coupon {
    private int id;
    private int phoneNumber;
    private int count;

    public Coupon(Map<String, Object> row) {
        this.id = (int)row.get("id");
        this.phoneNumber = (int)row.get("phoneNumber");
        this.count = (int)row.get("count");
    }
}