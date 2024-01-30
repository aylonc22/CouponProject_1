package database.dbdao;

//region Imports
import beans.Category;
import beans.Coupon;
import database.sql.DButils;
import database.dao.CouponDAO;
import database.sql.commands.Coupons;
import database.sql.commands.Cvc;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//endregion

public class CouponDBDAO implements CouponDAO {

    @Override
            //TODO in company facade you cannot add coupon with same title in the same company
    public void addCoupon(Coupon coupon) {
        Map<Integer, Object> params = couponToParams(coupon);
        params.put(1,coupon.getCompanyId());
        params.put(10,coupon.getCompanyId());
        params.put(11,coupon.getTitle());
        if(DButils.runQuery(Coupons.ADD_COUPON,params))
            System.out.println("Coupon added\n" + coupon);
        else
            System.out.println("Coupon wasn't added");
    }

    @Override
    public void updateCoupon(Coupon coupon) {
        Map<Integer, Object> params = couponToParams(coupon);
        // adding id in order to update directly from id
        params.put(params.size()+1,coupon.getId());
        if(DButils.runQuery(Coupons.UPDATE_COUPON,params))
            System.out.println("Coupon updated\n" + coupon);
        else
            System.out.println("Coupon wasn't updated");
    }

    @Override
    public void deleteCoupon(int couponID) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1,couponID);
        if(DButils.runQuery(Coupons.DELETE_COUPON,params))
            System.out.println("Coupon deleted");
        else
            System.out.println("Coupon wasn't deleted");
    }

    @Override
    public List<Coupon> getAllCoupons() throws SQLException {
        ResultSet resultSet = DButils.runQueryForResult(Coupons.GET_ALL_COUPON);
        List<Coupon> coupons = new ArrayList<>();
        while(resultSet.next())
        {
            coupons.add(resultSetToCoupon(resultSet));
        }
        return coupons;
    }

    @Override
    public List<Coupon> getAllCouponsOfCompany(int companyID) throws SQLException {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,companyID);
        ResultSet resultSet = DButils.runQueryForResult(Coupons.GET_ALL_COUPON_OF_COMPANY,params);
        List<Coupon> coupons = new ArrayList<>();
        while(resultSet.next())
        {
            coupons.add(resultSetToCoupon(resultSet));
        }
        return coupons;
    }

    @Override
    public List<Coupon> getAllCouponsOfCompanyByCategory(int companyID,Category category) throws SQLException {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,companyID);
        params.put(2,category.ordinal());
        ResultSet resultSet = DButils.runQueryForResult(Coupons.GET_ALL_COUPON_OF_COMPANY_BY_CATEGORY,params);
        List<Coupon> coupons = new ArrayList<>();
        while(resultSet.next())
        {
            coupons.add(resultSetToCoupon(resultSet));
        }
        return coupons;
    }

    @Override
    // return all the coupons of the company which price are below or equal to the criteria
    public List<Coupon> getAllCouponsOfCompanyUpToPrice(int companyID, double price) throws SQLException {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,companyID);
        params.put(2,price);
        ResultSet resultSet = DButils.runQueryForResult(Coupons.GET_ALL_COUPON_OF_COMPANY_UP_TO_PRICE,params);
        List<Coupon> coupons = new ArrayList<>();
        while(resultSet.next())
        {
            coupons.add(resultSetToCoupon(resultSet));
        }
        return coupons;
    }

    @Override
    public List<Coupon> getAllCouponsOfCustomer(int customerID) throws SQLException {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,customerID);
        ResultSet resultSet = DButils.runQueryForResult(Cvc.GET_ALL_COUPON_OF_CUSTOMER,params);
        List<Coupon> coupons = new ArrayList<>();
        while(resultSet.next())
        {
            coupons.add(resultSetToCoupon(resultSet));
        }
        return coupons;
    }

    @Override
    public List<Coupon> getAllCouponsOfCustomerByCategory(int customerID, Category category) throws SQLException {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,customerID);
        params.put(2,category.ordinal());
        ResultSet resultSet = DButils.runQueryForResult(Cvc.GET_ALL_COUPON_OF_CUSTOMER_BY_CATEGORY,params);
        List<Coupon> coupons = new ArrayList<>();
        while(resultSet.next())
        {
            coupons.add(resultSetToCoupon(resultSet));
        }
        return coupons;
    }

    @Override
    public List<Coupon> getAllCouponsOfCustomerUpToPrice(int customerID, double price) throws SQLException {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,customerID);
        params.put(2,price);
        ResultSet resultSet = DButils.runQueryForResult(Cvc.GET_ALL_COUPON_OF_CUSTOMER_UP_TO_PRICE,params);
        List<Coupon> coupons = new ArrayList<>();
        while(resultSet.next())
        {
            coupons.add(resultSetToCoupon(resultSet));
        }
        return coupons;
    }

    @Override
    public Coupon getOneCoupon(int couponID) throws SQLException {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,couponID);
        ResultSet resultSet = DButils.runQueryForResult(Coupons.GET_ONE_COUPON,params);
        while (resultSet.next()) {
            return resultSetToCoupon(resultSet);
        }
        return null;
    }

    @Override
    public void addCouponPurchase(int customerID, int couponID) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1,customerID);
        params.put(2,couponID);
        if(DButils.runQuery(Cvc.ADD_CVC,params))
            System.out.println("Customer_Vs_Coupon added");
        else
            System.out.println("Customer_Vs_Coupon wasn't added");
    }

    @Override
    public void deleteCouponPurchase(int customerID, int couponID) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1,customerID);
        params.put(2,couponID);
        if(DButils.runQuery(Cvc.DELETE_CVC,params))
            System.out.println("Customer_Vs_Coupon deleted");
        else
            System.out.println("Customer_Vs_Coupon wasn't deleted");
    }

    @Override
    public void deleteExpiredCoupons() {
        if(DButils.runQuery(Coupons.DELETE_EXPIRED_COUPON))
            System.out.println("Coupons and their purchase history deleted");
        else
            System.out.println("Coupons and their purchase history weren't deleted");
    }

    @Override
    public Map<Integer, Object> couponToParams(Coupon coupon) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(2,Category.valueOf(coupon.getCategory().toString()).ordinal() +1);
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
