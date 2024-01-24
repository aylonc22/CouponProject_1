package cls.sql;

public class DBmanager {
    //connection credentials to the Data Base
    public static final String URL = "jdbc:mysql://localhost:3306";
    public static final String SQL_USER = "root";
    public static final String SQL_PASSWORD = "12345678";

    //database name (schema)
    public static final String SQL_DB = "couponsdb";
    public static final String SQL_CUSTOMERS = "customers";
    public static final String SQL_CATEGORIES = "categories";
    public static final String SQL_COMPANIES = "companies";
    public static final String SQL_COUPONS = "coupons";
    public static final String SQL_CVC="customers_vs_coupons";
}
