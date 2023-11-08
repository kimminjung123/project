package org.example.coupon.service;

import org.example.coupon.entity.Coupon;
import org.example.coupon.repository.CouponRepository;

public class CouponService {
    CouponRepository couponRepository = new CouponRepository();
    public int create(int phoneNumber) {
        return this.couponRepository.create(phoneNumber);
    }

    public Coupon getCouponFindByPhoneNumber(int phoneNumber) {
        return this.couponRepository.getCouponFindByPhoneNumber(phoneNumber);
    }

    public int update(Coupon coupon) {
        return this.couponRepository.update(coupon);
    }

    public void setCouponCountClear(Coupon coupon) {
        this.couponRepository.setCouponCountClear(coupon);
    }
}
