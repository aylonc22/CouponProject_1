package database.dao;

//region Imports
import beans.Category;
import beans.Coupon;
import exception.CouponSystemException;

import java.sql.SQLException;
import java.util.List;
//endregion

public interface CouponDAO {
    //region Core Methods
     void addCoupon(Coupon coupon) throws CouponSystemException;
     void updateCoupon(Coupon coupon) throws CouponSystemException;
     void deleteCoupon(int couponID,int companyID) throws CouponSystemException;
     List<Coupon> getAllCoupons() throws SQLException;
     List<Coupon> getAllCouponsOfCompany(int companyID) throws SQLException;
     List<Coupon> getAllCouponsOfCompanyByCategory(int companyID , Category category) throws SQLException;
    // return all the coupons of the company which price are below or equal to the criteria
    List<Coupon> getAllCouponsOfCompanyUpToPrice(int companyID, double price) throws SQLException;
    List<Coupon> getAllCouponsOfCustomer(int customerID) throws SQLException;
    List<Coupon> getAllCouponsOfCustomerByCategory(int customerID , Category category) throws SQLException;
    // return all the coupons of the customer which price are below or equal to the criteria
    List<Coupon> getAllCouponsOfCustomerUpToPrice(int customerID, double price) throws SQLException;
     Coupon getOneCoupon(int couponID) throws SQLException;
     void addCouponPurchase(int customerID,int couponID) throws CouponSystemException, SQLException;
     void deleteCouponPurchase(int customerID,int couponID) throws CouponSystemException;
     void deleteExpiredCoupons();
    //endregion
}

