package database.dbdao;

//region Imports
import beans.Category;
import beans.Coupon;
import beans.QueryResult;
import database.sql.DButils;
import database.dao.CouponDAO;
import database.sql.SQLExceptionErrorCodes;
import database.sql.commands.Companies;
import database.sql.commands.Coupons;
import database.sql.commands.Cvc;
import exception.ObjectNotFoundException;
import exception.SQLDuplicateUniqueKeyException;

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
    public void addCoupon(Coupon coupon) throws SQLDuplicateUniqueKeyException {
        Map<Integer, Object> params = DBDAOUtils.couponToParams(coupon);
        params.put(1,coupon.getCompanyId());
        params.put(10,coupon.getCompanyId());
        params.put(11,coupon.getTitle());
        QueryResult queryResult = DButils.runQuery(Coupons.ADD_COUPON,params);
        if(queryResult.isResult()) {
            System.out.println("Coupon added\n" + coupon);
        }
        else {
           if(queryResult.getExceptionID() == SQLExceptionErrorCodes.DUPLICATE_KEY) {
               throw new SQLDuplicateUniqueKeyException(SQLDuplicateUniqueKeyException.tables.COUPON);
           }
            System.out.println(queryResult.getExceptionID());
        }
    }

    @Override
    public void updateCoupon(Coupon coupon) throws ObjectNotFoundException, SQLDuplicateUniqueKeyException {
        Map<Integer, Object> params = DBDAOUtils.couponToParams(coupon);
        // adding id in order to update directly from id
        params.put(params.size()+1,coupon.getId());
        QueryResult queryResult = DButils.runQuery(Coupons.UPDATE_COUPON,params);
        if(queryResult.isResult()) {
            System.out.println("Coupon updated\n" + coupon);
        }
        else {
            if(queryResult.getExceptionID() == SQLExceptionErrorCodes.DUPLICATE_KEY) {
               throw new SQLDuplicateUniqueKeyException(SQLDuplicateUniqueKeyException.tables.COUPON);
            }
            else
            {
                throw new ObjectNotFoundException(coupon.getId(), "Coupon");
            }
        }
    }

    @Override
    public void deleteCoupon(int couponID,int companyID) throws ObjectNotFoundException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1,couponID);
        params.put(2,couponID);
        QueryResult queryResult = DButils.runQuery(Coupons.DELETE_COUPON,params);
        if(queryResult.isResult()) {
            System.out.println("Coupon deleted");
        }
        else {
                throw new ObjectNotFoundException("Coupon with id: "+couponID +
                        " is not exists or it doesn't belong to company with id: " + companyID);
        }
    }

    @Override
    public List<Coupon> getAllCoupons() throws SQLException {
        ResultSet resultSet = DButils.runQueryForResult(Coupons.GET_ALL_COUPON);
        List<Coupon> coupons = new ArrayList<>();
        while(resultSet.next())
        {
            coupons.add(DBDAOUtils.resultSetToCoupon(resultSet));
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
            coupons.add(DBDAOUtils.resultSetToCoupon(resultSet));
        }
        return coupons;
    }

    @Override
    public List<Coupon> getAllCouponsOfCompanyByCategory(int companyID,Category category) throws SQLException {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,companyID);
        params.put(2,category.ordinal()+1);
        ResultSet resultSet = DButils.runQueryForResult(Coupons.GET_ALL_COUPON_OF_COMPANY_BY_CATEGORY,params);
        List<Coupon> coupons = new ArrayList<>();
        while(resultSet.next())
        {
            coupons.add(DBDAOUtils.resultSetToCoupon(resultSet));
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
            coupons.add(DBDAOUtils.resultSetToCoupon(resultSet));
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
            coupons.add(DBDAOUtils.resultSetToCoupon(resultSet));
        }
        return coupons;
    }

    @Override
    public List<Coupon> getAllCouponsOfCustomerByCategory(int customerID, Category category) throws SQLException {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,customerID);
        params.put(2,category.ordinal()+1);
        ResultSet resultSet = DButils.runQueryForResult(Cvc.GET_ALL_COUPON_OF_CUSTOMER_BY_CATEGORY,params);
        List<Coupon> coupons = new ArrayList<>();
        while(resultSet.next())
        {
            coupons.add(DBDAOUtils.resultSetToCoupon(resultSet));
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
            coupons.add(DBDAOUtils.resultSetToCoupon(resultSet));
        }
        return coupons;
    }

    @Override
    public Coupon getOneCoupon(int couponID) throws SQLException {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,couponID);
        ResultSet resultSet = DButils.runQueryForResult(Coupons.GET_ONE_COUPON,params);
        while (resultSet.next()) {
            return DBDAOUtils.resultSetToCoupon(resultSet);
        }
        return null;
    }

    @Override
    public void addCouponPurchase(int customerID, int couponID) throws ObjectNotFoundException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1,customerID);
        params.put(2,couponID);
        QueryResult queryResult = DButils.runQuery(Cvc.ADD_CVC,params);
        if(queryResult.isResult()) {
            System.out.println("Customer_Vs_Coupon added");
        }
        else {
           throw new ObjectNotFoundException("Customer with ID: " + customerID + " or/and Coupon with ID: " + couponID + "is/are not exists!");
        }
    }

    @Override
    public void deleteCouponPurchase(int customerID, int couponID) throws ObjectNotFoundException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1,customerID);
        params.put(2,couponID);
        QueryResult queryResult = DButils.runQuery(Cvc.DELETE_CVC,params);
        if(queryResult.isResult()) {
            System.out.println("Customer_Vs_Coupon deleted");
        }
        else {
            throw new ObjectNotFoundException("Customer with ID: " + customerID + " or/and Coupon with ID: " + couponID + "is/are not exists!");
        }
    }

    @Override
    public void deleteExpiredCoupons() {
        QueryResult queryResult = DButils.runQuery(Coupons.DELETE_EXPIRED_COUPON);
        if(queryResult.isResult()) {
            System.out.println("Coupons and their purchase history deleted");
        }
    }
}
