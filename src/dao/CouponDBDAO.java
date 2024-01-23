package dao;

import beans.Coupon;
import cls.ConnectionPool;

import java.util.List;

public class CouponDBDAO implements  CouponDAO{
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    @Override
    public boolean isCouponExists(String email, String password) {
        return false;
    }

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
    public List<Coupon> getAllCompanies() {
        return null;
    }

    @Override
    public Coupon getOneCoupon(int CouponID) {
        return null;
    }
}
