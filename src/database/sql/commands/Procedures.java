package database.sql.commands;

import database.sql.DBmanager;

public class Procedures {
    public static final String handleException = "USE " + DBmanager.SQL_DB + ";" +
            "DROP procedure IF EXISTS `handleException`;" +
            "DELIMITER $$" +
            "USE " + DBmanager.SQL_DB + "$$" +
            "CREATE PROCEDURE `handleException`(" +
            "IN flag INT," +
            "IN case_mode VARCHAR(20))" +
            "BEGIN" +
            "IF case_mode = 'update' THEN" +
            "IF flag = 0" +
            "THEN" +
            "SIGNAL SQLSTATE '10700' SET MESSAGE_TEXT = 'Cannot UPDATE RowID or RowID based on fields';" +
            "END IF;" +
            "ELSEIF  case_mode = 'delete' THEN" +
            "IF flag = 0 THEN" +
            "SIGNAL SQLSTATE '10600' SET MESSAGE_TEXT = 'Row to DELETE not found';" +
            "END IF;" +
            "END IF;" +
            "END$$" +
            "DELIMITER ;";
}
