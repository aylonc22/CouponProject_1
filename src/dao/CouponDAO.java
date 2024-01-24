package dao;

//region Imports
import beans.Coupon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
//endregion

public interface CouponDAO {
    //region Core Methods
    public void addCoupon(Coupon coupon);
    public void updateCoupon(Coupon coupon);
    public void deleteCoupon(int couponID);
    public List<Coupon> getAllCoupons();
    public Coupon getOneCoupon(int couponID);
    public void addCouponPurchase(int customerID,int couponID);
    public void deleteCouponPurchase(int customerID,int couponID);
    //endregion
    //region Auxiliary Methods
    public Map<Integer,Object> couponToParams(Coupon coupon);
    public Coupon resultSetToCoupon(ResultSet resultSet) throws SQLException;
    //endregion
}
}
