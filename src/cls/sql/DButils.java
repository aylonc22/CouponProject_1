package cls.sql;

import cls.sql.ConnectionPool;

import java.sql.*;
import java.util.Map;

public class DButils {
    public static boolean runQuery(String sql){
        //delete from students
        //use connection from connection sql to send queries to our DB
        Connection connection = null;

        try {
            //get a connection from connection pool
            connection = ConnectionPool.getInstance().getConnection();

            //prepare our sql (String) and convert it to a language that mysql will understand
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //run statement
            preparedStatement.execute();
            return true;
        } catch (InterruptedException | SQLException e) {
            //for specials occasions where even though there is an exception it's actually fine
            if(specials(e.getMessage()))
                return true;
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConnectionPool.getInstance().restoreConnection(connection);
        }

    }

    private static boolean specials(String message) {
        if(message.contains("'categories.Name_UNIQUE'"))
            return true;
        return false;
    }

    public static boolean runQuery(String sql, Map<Integer, Object> params){
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //lambda expression
            params.forEach((key,value)->{
                try {
                    if (value instanceof Integer){
                        preparedStatement.setInt(key,(Integer)value);
                    } else if (value instanceof String){
                        preparedStatement.setString(key,String.valueOf(value));
                    } else if (value instanceof Date){
                        preparedStatement.setDate(key,(Date)value);
                    } else if (value instanceof Double){
                        preparedStatement.setDouble(key, (Double)value);
                    } else if (value instanceof Boolean){
                        preparedStatement.setBoolean(key, (Boolean)value);
                    } else if (value instanceof Float){
                        preparedStatement.setFloat(key, (Float)value);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            preparedStatement.execute();
            return true;
        } catch (InterruptedException | SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConnectionPool.getInstance().restoreConnection(connection);
        }
    }

    public static ResultSet runQueryForResult(String sql){
        Connection connection = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            return preparedStatement.executeQuery();
        } catch (InterruptedException | SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionPool.getInstance().restoreConnection(connection);
        }
    }
    public static ResultSet runQueryForResult(String sql,Map<Integer,Object> params){
        Connection connection = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            params.forEach((key,value)->{
                try {
                    if (value instanceof Integer){
                        preparedStatement.setInt(key,(Integer)value);
                    } else if (value instanceof String){
                        preparedStatement.setString(key,String.valueOf(value));
                    } else if (value instanceof Date){
                        preparedStatement.setDate(key,(Date)value);
                    } else if (value instanceof Double){
                        preparedStatement.setDouble(key, (Double)value);
                    } else if (value instanceof Boolean){
                        preparedStatement.setBoolean(key, (Boolean)value);
                    } else if (value instanceof Float){
                        preparedStatement.setFloat(key, (Float)value);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            return preparedStatement.executeQuery();
        } catch (InterruptedException | SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionPool.getInstance().restoreConnection(connection);
        }
    }
}