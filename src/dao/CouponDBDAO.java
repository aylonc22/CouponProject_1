package dao;

import beans.Coupon;
import cls.sql.ConnectionPool;

import java.util.List;

public class CouponDBDAO implements  CouponDAO{
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();


    @Override
    public void addCoupon(Coupon Coupon) {

    }

    @Override
    public void updateCoupon(Coupon Coupon) {

    }

    @Override
    public void deleteCoupon(int CouponID) {

    }

    @Override
    public List<Coupon> getAllCoupons() {
        return null;
    }

    @Override
    public Coupon getOneCoupon(int CouponID) {
        return null;
    }

    @Override
    public void addCouponPurchase(int customerID, int couponID) {

    }

    @Override
    public void deleteCouponPurchase(int customerID, int couponID) {

    }
}
