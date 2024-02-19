package database.sql.commands;

//region Imports
//endregion

import database.sql.DBmanager;

public class General {
    /**
     * A query responsible for initializing the database
     */
    public static final String CREATE_DB = "CREATE DATABASE IF NOT EXISTS " + DBmanager.SQL_DB;

    /**
     * A query responsible for checking if client (Company or Customer) exists in the database
     *  with the given Email and Password.
     *  If exists 1, if not 0
     * @param table the table which the query will check on
     * @return returning the query
     */
    public static String IS_EXISTS_IN_TABLE(String table){
        return "SELECT COUNT(*) as isExists FROM " +DBmanager.SQL_DB + "." + table +" WHERE email=? and password=?";
    }
    /**
     * A query responsible for RETURNING  client (Company or Customer) if exists from the database
     *  with the given Email and Password.
     * @param table the table which the query will run on
     * @return returning the query
     */
    public static String GET_CLIENT_IN_TABLE(String table){
        return "Select * FROM " +DBmanager.SQL_DB + "." + table +" WHERE email=? and password=?";
    }

    public static String DROP_DATABASE = "Drop DATABASE " + DBmanager.SQL_DB;





}
