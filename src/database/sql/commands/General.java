package database.sql.commands;

//region Imports
//endregion

import database.sql.DBmanager;

public class General {
    //region SQL init // initializing data base and tables
    //create DataBase
    public static final String CREATE_DB = "CREATE DATABASE IF NOT EXISTS " + DBmanager.SQL_DB;

    //endregion
    public static String IS_EXISTS_IN_TABLE(String table){
        return "SELECT COUNT(*) as isExists FROM " +DBmanager.SQL_DB + "." + table +" WHERE email=? and password=?";
    }
    public static String GET_CLIENT_IN_TABLE(String table){
        return "Select * FROM " +DBmanager.SQL_DB + "." + table +" WHERE email=? and password=?";
    }





}
