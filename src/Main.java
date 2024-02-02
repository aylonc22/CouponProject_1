import beans.Category;
import cls.SystemManager;
import cls.Test;
import database.sql.SQL_Init;



public class Main {
    public static void main(String[] args) {
        SQL_Init.initSQL();
        //SystemManager.getInstance();
        Test.testAll();
    }
}