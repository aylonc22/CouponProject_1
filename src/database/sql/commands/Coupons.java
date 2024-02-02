package database.sql.commands;

import database.sql.DBmanager;

public class Coupons {
    //create coupons table
    public static final String CREATE_TABLE_COUPONS =
            "CREATE TABLE IF NOT EXISTS " +  DBmanager.SQL_DB + "."+ DBmanager.SQL_COUPONS + "(" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT," +
                    "  `Company_ID` INT NOT NULL," +
                    "  `Category_ID` INT NOT NULL," +
                    "  `Title` VARCHAR(45) NOT NULL," +
                    "  `Description` VARCHAR(45) NULL," +
                    "  `Start_Date` DATETIME NOT NULL," +
                    "  `End_Date` DATETIME NOT NULL," +
                    "  `Amount` INT NOT NULL," +
                    "  `Price` DOUBLE NOT NULL," +
                    "  `Image` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`ID`)," +
                    "  CONSTRAINT `Company_ID`" +
                    "    FOREIGN KEY (`Company_ID`)" +
                    "    REFERENCES " + DBmanager.SQL_DB + "." + DBmanager.SQL_COMPANIES+ " (`ID`)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE," +
                    "  CONSTRAINT `Category_ID`" +
                    "    FOREIGN KEY (`Category_ID`)" +
                    "    REFERENCES " + DBmanager.SQL_DB + "." + DBmanager.SQL_CATEGORIES + " (`ID`)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE);";
    //region Implementation for Coupons table
    // adding coupon ONLY if the same company does not have already a coupon with the exact same title
    public static final String ADD_COUPON = "INSERT INTO " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS +
            " (Company_ID,Category_ID,Title,Description,Start_Date,End_Date,Amount,Price,Image) SELECT ?,?,?,?,?,?,?,?,? " +
            " WHERE NOT EXISTS (" +
            " SELECT * FROM "+DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS +" WHERE Company_ID = ? AND Title = ?);";
    public static final String UPDATE_COUPON = "UPDATE " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS +
            " SET Category_ID=?,Title=?,Description=?,Start_Date=?,End_Date=?,Amount=?,Price=?,Image=? WHERE ID = ?";
    public static final String DELETE_COUPON = "DELETE FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS + " WHERE ID=? AND Company_ID =?";
    public static final String DELETE_EXPIRED_COUPON = "DELETE FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS + " WHERE End_date <= NOW()";
    public static final String GET_ALL_COUPON = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS;
    public static final String GET_ALL_COUPON_OF_COMPANY = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS + " WHERE Company_ID = ?";
    public static final String GET_ALL_COUPON_OF_COMPANY_BY_CATEGORY = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS +
            " WHERE Company_ID = ? AND Category_ID = ?";
    public static final String GET_ALL_COUPON_OF_COMPANY_UP_TO_PRICE = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS +
            " WHERE Company_ID = ? AND Price <= ?";
    public static final String GET_ONE_COUPON = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS + " WHERE ID=?";
    //endregion
}
