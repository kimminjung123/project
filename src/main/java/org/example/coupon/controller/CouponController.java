package org.example.coupon.controller;

import org.example.Container;

import java.util.ArrayList;
import java.util.List;

public class CouponController {
    List<Integer> stampCoupons = new ArrayList<>();

    int phoneNumber;
    int totalStamps = 0;
    boolean orderCompleted = false;

    public void coupon() {
        System.out.println("== 쿠폰 적립==");

        if (stampCoupons.isEmpty()) {
            System.out.print("전화번호를 입력하세요:");
            phoneNumber = Container.getSc().nextInt();
            // 스탬프 쿠폰 발급
            stampCoupons.add(phoneNumber);
            totalStamps++;
            System.out.println("스탬프 쿠폰이 발급되었습니다. 현재 스탬프 개수: " + totalStamps);

            if (totalStamps == 10) {
                System.out.println("10개의 스탬프를 모두 모았습니다. 무료 음료를 받을 수 있습니다!");
                stampCoupons.clear(); // 스탬프 초기화
                totalStamps = 0;
            }else {
                System.out.println("이미 스탬프 쿠폰을 받았습니다.");
                orderCompleted = true;
            }

        }
    }
}