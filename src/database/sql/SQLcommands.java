package database.sql;

//region Imports
import java.util.stream.Collectors;
import java.util.stream.IntStream;
//endregion

public class SQLcommands {
    //region SQL init // initializing data base and tables
    //create DataBase
    public static final String CREATE_DB = "CREATE DATABASE IF NOT EXISTS " + DBmanager.SQL_DB;
    //create companies table
    public static final String CREATE_TABLE_COMPANIES =
            "CREATE TABLE IF NOT EXISTS " +  DBmanager.SQL_DB + "."+DBmanager.SQL_COMPANIES + "(" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT," +
                    "  `Name` VARCHAR(45) NULL," +
                    "  `Email` VARCHAR(45) NULL," +
                    "  `Password` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`ID`)," +
                    "  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE," +
                    "  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) VISIBLE);";
    //create customers table
    public static final String CREATE_TABLE_CUSTOMERS =
            "CREATE TABLE IF NOT EXISTS " +  DBmanager.SQL_DB + "."+DBmanager.SQL_CUSTOMERS +"(" +
            "  `ID` INT NOT NULL AUTO_INCREMENT," +
            "  `First_Name` VARCHAR(45) NULL," +
            "  `Last_Name` VARCHAR(45) NULL," +
            "  `Email` VARCHAR(45) NULL," +
            "  `Password` VARCHAR(45) NULL," +
            "  PRIMARY KEY (`ID`)," +
            "  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) VISIBLE);";
    //create categories table
    public static final String CREATE_TABLE_CATEGORIES =
            "CREATE TABLE IF NOT EXISTS " +  DBmanager.SQL_DB + "."+ DBmanager.SQL_CATEGORIES+ "(" +
            "  `ID` INT NOT NULL AUTO_INCREMENT," +
            "  `Name` VARCHAR(45) NOT NULL," +
            "  PRIMARY KEY (`ID`)," +
            "  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE);";
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


    public static  String INSERT_CATEGORIES(int categories){
    // Iterating and inserting "(?)," "categories" times
    String wildCards = IntStream.range(0,categories).mapToObj((index)->"(?),")
            .collect(Collectors.joining());
    //subtracting the last ',' because it's unnecessary and will cause a sql bug
    return "INSERT INTO " + DBmanager.SQL_DB + "." + DBmanager.SQL_CATEGORIES + " (Name) VALUES " + wildCards.substring(0,wildCards.length()-1);
}
    //endregion
    public static String IS_EXISTS_IN_TABLE(String table){
        return "SELECT * FROM " +DBmanager.SQL_DB + "." + table +" WHERE email=? and password=?";
    }
//region CRUD Implementation for Customers table
    public static final String ADD_CUSTOMER = "INSERT INTO " + DBmanager.SQL_DB + "." + DBmanager.SQL_CUSTOMERS +
        "(first_Name,last_Name,email,password) VALUES (?,?,?,?)";
    public static final String UPDATE_CUSTOMER = "UPDATE " + DBmanager.SQL_DB + "." + DBmanager.SQL_CUSTOMERS +
            " SET first_Name=?,last_Name=?,email=?,password=? WHERE ID = ?";
    public static final String DELETE_CUSTOMER = "DELETE FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_CUSTOMERS + " WHERE ID=?";
    public static final String GET_ALL_CUSTOMERS = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_CUSTOMERS;
    public static final String GET_ONE_CUSTOMERS = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_CUSTOMERS + " WHERE ID=?";
//endregion
// region CRUD Implementation for Companies table
public static final String ADD_COMPANY = "INSERT INTO " + DBmanager.SQL_DB + "." + DBmanager.SQL_COMPANIES +
        "(name,email,password) VALUES (?,?,?)";
    public static final String UPDATE_COMPANY = "UPDATE " + DBmanager.SQL_DB + "." + DBmanager.SQL_COMPANIES +
            " SET name=?,email=?,password=? WHERE ID = ?";
    public static final String DELETE_COMPANY = "DELETE FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COMPANIES + " WHERE ID=?";
    public static final String GET_ALL_COMPANY = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COMPANIES;
    public static final String GET_ONE_COMPANY = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COMPANIES + " WHERE ID=?";
// endregion

    //region Implementation for Coupons table
    // adding coupon ONLY if the same company does not have already a coupon with the exact same title
    public static final String ADD_COUPON = "INSERT INTO " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS +
            "(Company_ID,Category_ID,Title,Description,Start_Date,End_Date,Amount,Price,Image) SELECT (?,?,?,?,?,?,?,?,?) " +
            "WHERE NOT EXISTS (" +
            "    SELECT * FROM "+DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS +" WHERE Company_ID = ? AND Title = ?);";
    public static final String UPDATE_COUPON = "UPDATE " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS +
            " SET Category_ID=?,Title=?,Description=?,Start_Date=?,End_Date=?,Amount=?,Price=?,Image=? WHERE ID = ?";
    public static final String DELETE_COUPON = "DELETE FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS + " WHERE ID=?";
    public static final String DELETE_EXPIRED_COUPON = "DELETE FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS + " WHERE End_date <= NOW()";
    public static final String GET_ALL_COUPON = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS;
    public static final String GET_ALL_COUPON_OF_COMPANY = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS + " WHERE Company_ID = ?";
    public static final String GET_ALL_COUPON_OF_COMPANY_BY_CATEGORY = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS +
            " WHERE Company_ID = ? AND Category_ID = ?";
    public static final String GET_ALL_COUPON_OF_COMPANY_UP_TO_PRICE = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS +
            " WHERE Company_ID = ? AND Price <= ?";
    public static final String GET_ONE_COUPON = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS + " WHERE ID=?";
    //endregion
    //region Implementation for Customer_Vs_Coupon table
    public static final String ADD_CVC = "INSERT INTO " + DBmanager.SQL_DB + "." + DBmanager.SQL_CVC +
            "(Customer_ID,Coupon_ID) VALUES (?,?)";
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
