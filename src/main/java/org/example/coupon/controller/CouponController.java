package org.example.coupon.controller;

import org.example.Container;
import org.example.coupon.entity.Coupon;
import org.example.coupon.service.CouponService;

public class CouponController {
    boolean orderCompleted = false;

    CouponService CouponService = new CouponService();

    public void coupon() {
        System.out.println("== 쿠폰 적립==");

        System.out.print("전화번호를 입력하세요:");
        int phoneNumber = Container.getSc().nextInt();
        Container.getSc().nextLine();


        Coupon coupon = this.CouponService.getCouponFindByPhoneNumber(phoneNumber);

        if (coupon == null) {
            this.CouponService.create(phoneNumber);
            System.out.println("스탬프 쿠폰이 발급되었습니다. 현재 스탬프 개수: 1");
        } else {
            if (coupon.getCount() == 9) {
                this.CouponService.setCouponCountClear(coupon);
                System.out.println("10개의 스탬프를 모두 모았습니다. 무료 음료를 받을 수 있습니다!");
            } else {
                coupon.setCount(coupon.getCount() + 1);
                this.CouponService.update(coupon);
                System.out.println("스탬프 쿠폰이 발급되었습니다. 현재 스탬프 개수: " + coupon.getCount());
            }
        }

    }
}