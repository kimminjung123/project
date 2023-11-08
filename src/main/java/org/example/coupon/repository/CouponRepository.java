package org.example.coupon.repository;

import org.example.Container;
import org.example.coupon.entity.Coupon;
import org.example.db.DBConnection;

import java.util.Map;

public class CouponRepository {
    private DBConnection dbConnection;

    public CouponRepository () {
        dbConnection = Container.getDBconnection();
    }
    public int create(int phoneNumber) {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("INSERT INTO coupon "));
        sb.append(String.format("SET phoneNumber = '%s', ", phoneNumber));
        sb.append(String.format("`count` = 1"));

        int id = dbConnection.insert(sb.toString());

        return id;
    }

    public Coupon getCouponFindByPhoneNumber(int phoneNumber) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("SELECT * FROM coupon "));
        sb.append(String.format("WHERE phoneNumber = %s ", phoneNumber));

        Map<String, Object> row = dbConnection.selectRow(sb.toString());
        if (row.size() == 0) {
            return null;
        } else {
            return new Coupon(row);
        }
    }

    public int update(Coupon coupon) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("UPDATE coupon "));
        sb.append(String.format("SET `count` = %s ", coupon.getCount()));
        sb.append(String.format("WHERE phoneNumber = %d", coupon.getPhoneNumber()));

        int id = dbConnection.update(sb.toString());

        return id;
    }

    public void setCouponCountClear(Coupon coupon) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("UPDATE coupon "));
        sb.append(String.format("SET `count` = %s ", 0));
        sb.append(String.format("WHERE phoneNumber = %d", coupon.getPhoneNumber()));

        int id = dbConnection.update(sb.toString());
    }
}
