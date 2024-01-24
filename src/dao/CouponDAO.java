package dao;

import beans.Coupon;
import java.util.List;

public interface CouponDAO {
    public void addCoupon(Coupon Coupon);
    public void updateCoupon(Coupon Coupon);
    public void deleteCoupon(int CouponID);
    public List<Coupon> getAllCoupons();
    public Coupon getOneCoupon(int CouponID);
    public void addCouponPurchase(int customerID,int couponID);
    public void deleteCouponPurchase(int customerID,int couponID);
}
