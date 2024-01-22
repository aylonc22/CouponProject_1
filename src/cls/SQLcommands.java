package cls;

public class SQLcommands {
    //create DataBase
    public static final String CREATE_DB = "CREATE DATABASE IF NOT EXISTS `cuponsdb`";
    //create companies table
    public static final String CREATE_TABLE_COMPANIES =
            "CREATE TABLE IF NOT EXISTS `cuponsdb`.`companies` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Name` VARCHAR(45) NULL,\n" +
                    "  `Email` VARCHAR(45) NULL,\n" +
                    "  `Password` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE,\n" +
                    "  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) VISIBLE);";
    //create customers table
    public static final String CREATE_TABLE_CUSTOMERS =
            "CREATE TABLE IF NOT EXISTS `cuponsdb`.`customers` (\n" +
            "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `First_Name` VARCHAR(45) NULL,\n" +
            "  `Last_Name` VARCHAR(45) NULL,\n" +
            "  `Email` VARCHAR(45) NULL,\n" +
            "  `Password` VARCHAR(45) NULL,\n" +
            "  PRIMARY KEY (`ID`),\n" +
            "  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) VISIBLE);";
    //create categories table
    public static final String CREATE_TABLE_CATEGORIES =
            "CREATE TABLE IF NOT EXISTS `cuponsdb`.`categories` (\n" +
            "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `Name` VARCHAR(45) NOT NULL,\n" +
            "  PRIMARY KEY (`ID`),\n" +
            "  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE);";
    //create coupons table
    public static final String CREATE_TABLE_COUPONS =
        "CREATE TABLE IF NOT EXISTS `cuponsdb`.`coupons` (\n" +
                "  `ID` INT NOT NULL,\n" +
                "  `Company_ID` INT NOT NULL,\n" +
                "  `Category_ID` INT NOT NULL,\n" +
                "  `Title` VARCHAR(45) NOT NULL,\n" +
                "  `Description` VARCHAR(45) NULL,\n" +
                "  `Start_Date` DATETIME NOT NULL,\n" +
                "  `End_Date` DATETIME NOT NULL,\n" +
                "  `Amount` INT NOT NULL,\n" +
                "  `Price` DOUBLE NOT NULL,\n" +
                "  `Image` VARCHAR(45) NULL,\n" +
                "  PRIMARY KEY (`ID`),\n" +
                "  UNIQUE INDEX `Company_ID_UNIQUE` (`Company_ID` ASC) VISIBLE,\n" +
                "  UNIQUE INDEX `Category_ID_UNIQUE` (`Category_ID` ASC) VISIBLE,\n" +
                "  CONSTRAINT `Company_ID`\n" +
                "    FOREIGN KEY (`Company_ID`)\n" +
                "    REFERENCES `cuponsdb`.`companies` (`ID`)\n" +
                "    ON DELETE CASCADE\n" +
                "    ON UPDATE CASCADE,\n" +
                "  CONSTRAINT `Category_ID`\n" +
                "    FOREIGN KEY (`Category_ID`)\n" +
                "    REFERENCES `cuponsdb`.`categories` (`ID`)\n" +
                "    ON DELETE CASCADE\n" +
                "    ON UPDATE CASCADE);\n";

// create customers_vs_coupons table
public static final String CREATE_TABLE_CVC=
        "CREATE TABLE IF NOT EXISTS`cuponsdb`.`customers_vs_coupons` (\n" +
                "  `Customer_ID` INT NOT NULL,\n" +
                "  `Coupon_ID` INT NOT NULL,\n" +
                "  PRIMARY KEY (`Customer_ID`, `Coupon_ID`),\n" +
                "  INDEX `Coupons_ID_idx` (`Coupon_ID` ASC) VISIBLE,\n" +
                "  CONSTRAINT `Customer_ID`\n" +
                "    FOREIGN KEY (`Customer_ID`)\n" +
                "    REFERENCES `cuponsdb`.`customers` (`ID`)\n" +
                "    ON DELETE CASCADE\n" +
                "    ON UPDATE CASCADE,\n" +
                "  CONSTRAINT `Coupons_ID`\n" +
                "    FOREIGN KEY (`Coupon_ID`)\n" +
                "    REFERENCES `cuponsdb`.`coupons` (`ID`)\n" +
                "    ON DELETE CASCADE\n" +
                "    ON UPDATE CASCADE);";
    public static final String addStudent = "INSERT INTO `class169`.`students` " +
            "(`name`, `tel`, `avgGrade`, `city`, `married`) " +
            "VALUES (?, ?, ?, ?, ?);";

    public static final String getAllStudents = "SELECT * FROM `class169`.`students`";
    public static final String getStudentsAbove95 = "SELECT * FROM `class169`.`students` WHERE avgGrade>95";
    public static final String getStudentAbove = "SELECT * FROM `class169`.`students` WHERE avgGrade>?";

    public static final String getStudentBetwen = "SELECT * FROM `class169`.`students` WHERE avgGrade>? AND avgGrade<?";
    //CRUD

}
