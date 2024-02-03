package database.sql.commands;

import database.sql.DBmanager;

public class Cvc {
    // create customers_vs_coupons table
    public static final String CREATE_TABLE_CVC=
            "CREATE TABLE IF NOT EXISTS " + DBmanager.SQL_DB + "." + DBmanager.SQL_CVC + "(" +
                    "  `Customer_ID` INT NOT NULL," +
                    "  `Coupon_ID` INT NOT NULL," +
                    "  PRIMARY KEY (`Customer_ID`, `Coupon_ID`)," +
                    "  INDEX `Coupons_ID_idx` (`Coupon_ID` ASC) VISIBLE," +
                    "  CONSTRAINT `Customer_ID`" +
                    "    FOREIGN KEY (`Customer_ID`)" +
                    "    REFERENCES " + DBmanager.SQL_DB + "." + DBmanager.SQL_CUSTOMERS + " (`ID`)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE," +
                    "  CONSTRAINT `Coupons_ID`" +
                    "    FOREIGN KEY (`Coupon_ID`)" +
                    "    REFERENCES " +DBmanager.SQL_DB +"." + DBmanager.SQL_COUPONS + " (`ID`)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE);";
    //region Implementation for Customer_Vs_Coupon table
    public static final String ADD_CVC_STEP1 = "INSERT INTO " + DBmanager.SQL_DB + "." + DBmanager.SQL_CVC +
            " (Customer_ID,Coupon_ID)" +
            " SELECT ?,?" +
            " WHERE EXISTS (SELECT 1 FROM " + DBmanager.SQL_DB + "."+ DBmanager.SQL_COUPONS + " WHERE ID=? AND Amount >=1);";
    public static final String ADD_CVC_STEP2 = " UPDATE " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS +
            " SET Amount = Amount - 1 WHERE ID=?";
    public static final String VALIDATE_OUT_OF_STOCK = "SELECT COUNT(*) FROM "+ DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS +
            " WHERE ID=? AND AMOUNT = 0";
    public static final String DELETE_CVC = "DELETE FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_CVC + " WHERE Customer_ID=? AND Coupon_ID=?";
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    // aliases
    //cvc stands for customer_vs_coupon
    //coup stands for coupon
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    // TODO CHECK THIS actually works!
    public static final String GET_ALL_COUPON_OF_CUSTOMER = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS +
            " coup JOIN " + DBmanager.SQL_DB + "." + DBmanager.SQL_CVC + " cvc ON coup.ID=cvc.Coupon_ID"+
            " WHERE cvc.Customer_ID = ?";
    public static final String GET_ALL_COUPON_OF_CUSTOMER_BY_CATEGORY = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS +
            " coup JOIN " + DBmanager.SQL_DB + "." + DBmanager.SQL_CVC + " cvc ON coup.ID=cvc.Coupon_ID"+
            " WHERE cvc.Customer_ID = ? AND coup.Category_ID = ?";
    public static final String GET_ALL_COUPON_OF_CUSTOMER_UP_TO_PRICE = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS +
            " coup JOIN " + DBmanager.SQL_DB + "." + DBmanager.SQL_CVC + " cvc ON coup.ID=cvc.Coupon_ID"+
            " WHERE cvc.Customer_ID = ? AND coup.Price <=";;
    //endregion
}
