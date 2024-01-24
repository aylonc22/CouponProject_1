package cls.sql;

import cls.sql.DBmanager;

public class SQLcommands {
    //region SQL init // initializing data base and tables
    //create DataBase
    public static final String CREATE_DB = "CREATE DATABASE IF NOT EXISTS " + DBmanager.SQL_DB;
    //create companies table
    public static final String CREATE_TABLE_COMPANIES =
            "CREATE TABLE IF NOT EXISTS " +  DBmanager.SQL_DB + ".`companies`(" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT," +
                    "  `Name` VARCHAR(45) NULL," +
                    "  `Email` VARCHAR(45) NULL," +
                    "  `Password` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`ID`)," +
                    "  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE," +
                    "  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) VISIBLE);";
    //create customers table
    public static final String CREATE_TABLE_CUSTOMERS =
            "CREATE TABLE IF NOT EXISTS " +  DBmanager.SQL_DB + ".`customers`(" +
            "  `ID` INT NOT NULL AUTO_INCREMENT," +
            "  `First_Name` VARCHAR(45) NULL," +
            "  `Last_Name` VARCHAR(45) NULL," +
            "  `Email` VARCHAR(45) NULL," +
            "  `Password` VARCHAR(45) NULL," +
            "  PRIMARY KEY (`ID`)," +
            "  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) VISIBLE);";
    //create categories table
    public static final String CREATE_TABLE_CATEGORIES =
            "CREATE TABLE IF NOT EXISTS " +  DBmanager.SQL_DB + ".`categories`(" +
            "  `ID` INT NOT NULL AUTO_INCREMENT," +
            "  `Name` VARCHAR(45) NOT NULL," +
            "  PRIMARY KEY (`ID`)," +
            "  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE);";
    //create coupons table
    public static final String CREATE_TABLE_COUPONS =
        "CREATE TABLE IF NOT EXISTS " +  DBmanager.SQL_DB + ".`coupons`(" +
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
                "    REFERENCES " + DBmanager.SQL_DB + ".`companies` (`ID`)" +
                "    ON DELETE CASCADE" +
                "    ON UPDATE CASCADE," +
                "  CONSTRAINT `Category_ID`" +
                "    FOREIGN KEY (`Category_ID`)" +
                "    REFERENCES " + DBmanager.SQL_DB + ".`categories` (`ID`)" +
                "    ON DELETE CASCADE" +
                "    ON UPDATE CASCADE);";

// create customers_vs_coupons table
public static final String CREATE_TABLE_CVC=
        "CREATE TABLE IF NOT EXISTS " + DBmanager.SQL_DB + ".`customers_vs_coupons`(" +
                "  `Customer_ID` INT NOT NULL," +
                "  `Coupon_ID` INT NOT NULL," +
                "  PRIMARY KEY (`Customer_ID`, `Coupon_ID`)," +
                "  INDEX `Coupons_ID_idx` (`Coupon_ID` ASC) VISIBLE," +
                "  CONSTRAINT `Customer_ID`" +
                "    FOREIGN KEY (`Customer_ID`)" +
                "    REFERENCES " + DBmanager.SQL_DB + ".`customers` (`ID`)" +
                "    ON DELETE CASCADE" +
                "    ON UPDATE CASCADE," +
                "  CONSTRAINT `Coupons_ID`" +
                "    FOREIGN KEY (`Coupon_ID`)" +
                "    REFERENCES " +DBmanager.SQL_DB +".`coupons` (`ID`)" +
                "    ON DELETE CASCADE" +
                "    ON UPDATE CASCADE);";
    //endregion
    public static final String addStudent = "INSERT INTO `class169`.`students` " +
            "(`name`, `tel`, `avgGrade`, `city`, `married`) " +
            "VALUES (?, ?, ?, ?, ?);";

    public static final String getAllStudents = "SELECT * FROM `class169`.`students`";
    public static final String getStudentsAbove95 = "SELECT * FROM `class169`.`students` WHERE avgGrade>95";
    public static final String getStudentAbove = "SELECT * FROM `class169`.`students` WHERE avgGrade>?";

    public static final String getStudentBetwen = "SELECT * FROM `class169`.`students` WHERE avgGrade>? AND avgGrade<?";
    //CRUD

}
