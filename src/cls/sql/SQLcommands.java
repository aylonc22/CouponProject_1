package cls.sql;

import cls.sql.DBmanager;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
                "  `ID` INT NOT NULL," +
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
                "  UNIQUE INDEX `Company_ID_UNIQUE` (`Company_ID` ASC) VISIBLE," +
                "  UNIQUE INDEX `Category_ID_UNIQUE` (`Category_ID` ASC) VISIBLE," +
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
//region CRUD Implementation for Customer
    public static final String ADD_CUSTOMER = "INSERT INTO " + DBmanager.SQL_DB + "." + DBmanager.SQL_CUSTOMERS +
        "(first_Name,last_Name,email,password) VALUES (?,?,?,?)";
    public static final String UPDATE_CUSTOMER = "UPDATE " + DBmanager.SQL_DB + "." + DBmanager.SQL_CUSTOMERS +
            " SET first_Name=?,last_Name=?,email=?,password=? WHERE ID = ?";
    public static final String DELETE_CUSTOMER = "DELETE FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_CUSTOMERS + " WHERE ID=?";
    public static final String GET_ALL_CUSTOMERS = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_CUSTOMERS;
    public static final String GET_ONE_CUSTOMERS = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_CUSTOMERS + " WHERE ID=?";
//region
}
