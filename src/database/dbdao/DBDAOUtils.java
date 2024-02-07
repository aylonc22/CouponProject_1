package database.dbdao;

//region Imports
import beans.Category;
import beans.Company;
import beans.Coupon;
import beans.Customer;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//endregion

/**
 * Auxiliary Methods for DBDAOS
 */
public class DBDAOUtils {
    //region Methods For Company DBDAO
    public static Map<Integer, Object> companyToParams(Company company) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1,company.getName());
        params.put(2,company.getEmail());
        params.put(3,company.getPassword());
        return params;
    }

    public static Company resultSetToCompany(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        String email = resultSet.getString(3);
        String password = resultSet.getString(4);
        return new Company(id,name,email,password,new ArrayList<>());
    }

    public static Coupon resultSetToCouponOfCompanies(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(5);
        int companyId = resultSet.getInt(6);
        int categoryId = resultSet.getInt(7)-1;
        String title = resultSet.getString(8);
        String description = resultSet.getString(9);
        Date startDate = resultSet.getDate(10);
        Date endDate = resultSet.getDate(11);
        int amount = resultSet.getInt(12);
        double price = resultSet.getDouble(13);
        String image = resultSet.getString(14);
        return new Coupon(id,companyId, Category.values()[categoryId],title,description,startDate,endDate,amount,price,image);
    }
    //endregion
    //region Methods For Coupon DBDAO
    public static Map<Integer, Object> couponToParams(Coupon coupon) {
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
    public static Coupon resultSetToCoupon(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        int companyId = resultSet.getInt(2);
        int categoryId = resultSet.getInt(3)-1;
        String title = resultSet.getString(4);
        String description = resultSet.getString(5);
        Date startDate = resultSet.getDate(6);
        Date endDate = resultSet.getDate(7);
        int amount = resultSet.getInt(8);
        double price = resultSet.getDouble(9);
        String image = resultSet.getString(10);
        return new Coupon(id,companyId, Category.values()[categoryId],title,description,startDate,endDate,amount,price,image);
    }
    //endregion
    //region Methods For Customer DBDAO
    public static Map<Integer, Object> customerToParams(Customer customer) {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1,customer.getFirstName());
        params.put(2,customer.getLastName());
        params.put(3,customer.getEmail());
        params.put(4,customer.getPassword());
        return params;
    }

    public static Customer resultSetToCustomer(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String firstName = resultSet.getString(2);
        String lastName = resultSet.getString(3);
        String email = resultSet.getString(4);
        String password = resultSet.getString(5);
        return new Customer(id,firstName,lastName,email,password,new ArrayList<>());
    }
    //endregion
}
