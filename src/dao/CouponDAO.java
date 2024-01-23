package dao;

import beans.Coupon;
import java.util.List;

public interface CouponDAO {
    public  boolean isCouponExists(String email,String password);
    public void addCoupon(Coupon Coupon);
    public void updateCoupon(Coupon Coupon);
    public void deleteCoupon(int CouponID);
    public List<Coupon> getAllCompanies();
    public Coupon getOneCoupon(int CouponID);
}
