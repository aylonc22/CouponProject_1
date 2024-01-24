package dao;

import beans.Category;
import beans.Coupon;
import beans.Customer;
import cls.sql.DButils;
import cls.sql.SQLcommands;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CouponDBDAO implements  CouponDAO{

    @Override
    public void addCoupon(Coupon coupon) {
        Map<Integer, Object> params = couponToParams(coupon);
        if(DButils.runQuery(SQLcommands.ADD_COUPON,params))
            System.out.println("Coupon added\n" + coupon);
        else
            System.out.println("Coupon wasn't added");
    }

    @Override
    public void updateCoupon(Coupon coupon) {

    }

    @Override
    public void deleteCoupon(int couponID) {

    }

    @Override
    public List<Coupon> getAllCoupons() {
        return null;
    }

    @Override
    public Coupon getOneCoupon(int couponID) {
        return null;
    }

    @Override
    public void addCouponPurchase(int customerID, int couponID) {

    }

    @Override
    public void deleteCouponPurchase(int customerID, int couponID) {

    }

    @Override
    public Map<Integer, Object> couponToParams(Coupon coupon) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1,coupon.getCompanyId());
        params.put(2,coupon.getCategory());
        params.put(3,coupon.getTitle());
        params.put(4,coupon.getDescription());
        params.put(5,coupon.getStartDate());
        params.put(6,coupon.getEndDate());
        params.put(7,coupon.getAmount());
        params.put(8,coupon.getPrice());
        params.put(9,coupon.getImage());

        return params;
    }

    @Override
    public Coupon resultSetToCoupon(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        int companyId = resultSet.getInt(2);
        int categoryId = resultSet.getInt(3);
        String title = resultSet.getString(4);
        String description = resultSet.getString(5);
        Date startDate = resultSet.getDate(6);
        Date endDate = resultSet.getDate(7);
        int amount = resultSet.getInt(8);
        double price = resultSet.getDouble(9);
        String image = resultSet.getString(9);
//TODO check that category id really sync with enum and database!!!
        return new Coupon(id,companyId, Category.values()[categoryId],title,description,startDate,endDate,amount,price,image);
    }
}
