package database.sql.commands;

import database.sql.DBmanager;

public class Customers {
    /**
     * A Query responsible for creating the customer table when initializing the project
     */
    public static final String CREATE_TABLE_CUSTOMERS =
            "CREATE TABLE IF NOT EXISTS " +  DBmanager.SQL_DB + "."+DBmanager.SQL_CUSTOMERS +"(" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT," +
                    "  `First_Name` VARCHAR(45) NULL," +
                    "  `Last_Name` VARCHAR(45) NULL," +
                    "  `Email` VARCHAR(45) NULL," +
                    "  `Password` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`ID`)," +
                    "  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) VISIBLE);";
    //region CRUD Implementation for Customers table
    /**
     * A Query responsible for INSERTING one new customer.
     * Customer can't have the same Email as another customer
     */
    public static final String ADD_CUSTOMER = "INSERT INTO " + DBmanager.SQL_DB + "." + DBmanager.SQL_CUSTOMERS +
            "(first_Name,last_Name,email,password) VALUES (?,?,?,?)";
    /**
     * A Query responsible for UPDATING one customer.
     * Customer can't have the same Email as another customer
     */
    public static final String UPDATE_CUSTOMER = "UPDATE " + DBmanager.SQL_DB + "." + DBmanager.SQL_CUSTOMERS +
            " SET first_Name=?,last_Name=?,email=?,password=? WHERE ID = ?";
    /**
     * A Query responsible for DELETING one customer.
     */
    public static final String DELETE_CUSTOMER = "DELETE FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_CUSTOMERS + " WHERE ID=?";
    /**
     * A Query responsible for RETURNING all customers.
     */
    public static final String GET_ALL_CUSTOMERS = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_CUSTOMERS;
    /**
     * A Query responsible for RETURNING one customer.
     */
    public static final String GET_ONE_CUSTOMER = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_CUSTOMERS + " WHERE ID=?";
//endregion
}
