package database.sql.commands;

import database.sql.DBmanager;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Categories {
    /**
     * A Query responsible for creating the category table when initializing the project
     */
    public static final String CREATE_TABLE_CATEGORIES =
            "CREATE TABLE IF NOT EXISTS " +  DBmanager.SQL_DB + "."+ DBmanager.SQL_CATEGORIES+ "(" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT," +
                    "  `Name` VARCHAR(45) NOT NULL," +
                    "  PRIMARY KEY (`ID`)," +
                    "  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE);";

    /**
     * A query to insert the coupon's categories when initializing the project
     * Concatenating enough wild cards to insert all the enum categories in the same query
     * @param categories the amount of categories we have in the project
     * @return returning the finished query with the exact amount of wild cards
     * wild card is '?'
     */
    public static  String INSERT_CATEGORIES(int categories){
        // Iterating and inserting "(?)," "categories" times
        String wildCards = IntStream.range(0,categories).mapToObj((index)->"(?),")
                .collect(Collectors.joining());
        //subtracting the last ',' because it's unnecessary and will cause a sql bug
        return "INSERT INTO " + DBmanager.SQL_DB + "." + DBmanager.SQL_CATEGORIES + " (Name) VALUES " + wildCards.substring(0,wildCards.length()-1);
    }
}
