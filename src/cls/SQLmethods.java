package cls;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class SQLmethods {
    public static void createDB(){
       if( DButils.runQuery(SQLcommands.CREATE_DB))
           System.out.println("DB Created or already exist");
       else
           System.out.println("DB is not created");
    }
}
