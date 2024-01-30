package database.sql.commands;

import database.sql.DBmanager;

public class Companies {
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
    // region CRUD Implementation for Companies table
    public static final String ADD_COMPANY = "INSERT INTO " + DBmanager.SQL_DB + "." + DBmanager.SQL_COMPANIES +
            "(name,email,password) VALUES (?,?,?)";
    public static final String UPDATE_COMPANY = "UPDATE " + DBmanager.SQL_DB + "." + DBmanager.SQL_COMPANIES +
            " SET name=?,email=?,password=? WHERE ID = ?";
    public static final String DELETE_COMPANY = "DELETE FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COMPANIES + " WHERE ID=?";
    public static final String GET_ALL_COMPANY = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COMPANIES;
    public static final String GET_ONE_COMPANY = "SELECT * FROM " + DBmanager.SQL_DB + "." + DBmanager.SQL_COMPANIES + " WHERE ID=?";
// endregion
}
