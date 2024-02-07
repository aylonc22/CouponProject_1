package database.sql.commands;

import database.sql.DBmanager;

public class Companies {
    //create companies table
    /**
     * A Query responsible for creating the company table when initializing the project
     */
    public static final String CREATE_TABLE_COMPANIES =
            "CREATE TABLE IF NOT EXISTS " +  DBmanager.SQL_DB + "."+DBmanager.SQL_COMPANIES + "(" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT," +
                    "  `Name` VARCHAR(45) NULL," +
                    "  `Email` VARCHAR(45) NULL," +
                    "  `Password` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`ID`)," +
                    "  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE," +
                    "  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) VISIBLE);";
    // region CRUD Implementation for Companies table
    /**
     * A Query responsible for returning the logged in company details with its coupons from the coupons table
     */
    public static final String GET_COMPANY_WITH_COUPONS = "Select * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COMPANIES +
            " co JOIN " + DBmanager.SQL_DB + "." + DBmanager.SQL_COUPONS + " cou " +
            "ON co.ID = cou.Company_ID WHERE email=? and password=?";
    /**
     * A Query responsible for returning the logged in company details when it has no coupons
     */
    public static final String GET_COMPANY = "Select * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COMPANIES +
            " WHERE email=? and password=?";
    /**
     * A Query responsible for INSERTING one new company.
     * Company can't have the same Name and Email as another company
     */
    public static final String ADD_COMPANY =
            "INSERT INTO " + DBmanager.SQL_DB + "." + DBmanager.SQL_COMPANIES +
            "(name,email,password) VALUES (?,?,?)";
    /**
     * A Query responsible for UPDATING one company.
     * Company can't have the same Name and Email as another company
     */
    public static final String UPDATE_COMPANY = "UPDATE " + DBmanager.SQL_DB + "." + DBmanager.SQL_COMPANIES +
            " SET name=?,email=?,password=? WHERE ID = ?";
    /**
     * A Query responsible for deleting an existing company from the database
     */
    public static final String DELETE_COMPANY = "DELETE FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COMPANIES + " WHERE ID=?";
    /**
     * A Query responsible for returning all the companies in the database
     */
    public static final String GET_ALL_COMPANY = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COMPANIES;
    /**
     * A Query responsible for returning a specific company (by its ID) from the database
     */
    public static final String GET_ONE_COMPANY = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COMPANIES + " WHERE ID=?";
// endregion
}
