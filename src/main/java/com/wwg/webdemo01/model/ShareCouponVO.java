package com.wwg.webdemo01.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author：liangshuyan
 * @date：2021/11/15 11:20
 * @description：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShareCouponVO {
    private String coupon_id;//优惠券ID
    private String coupon_name;//优惠券名称
    private String img;//图片
    private String share_code;//优惠券分享码
    private String coupon_start_time;//优惠券使用开始时间
    private String coupon_end_time;//优惠券使用结束时间
    private String cu_id;
    private String match_order_type;
    private Boolean is_my_coupon;

    private String imgPath;
}
