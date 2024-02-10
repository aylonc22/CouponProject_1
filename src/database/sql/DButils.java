package database.sql;

import beans.QueryResult;

import java.sql.*;
import java.util.Map;

public class DButils {
    public static QueryResult runQuery(String sql){
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
            //validation that the query actually did something
            return new QueryResult(preparedStatement.getUpdateCount() > 0,0);
        } catch (InterruptedException | SQLException e) {
//            System.out.println(e.getMessage());
//            System.out.println(e instanceof SQLException ? ((SQLException) e).getErrorCode():0);
            //If the exception is SQL related give back the error code
            return new QueryResult(false,e instanceof SQLException ? ((SQLException) e).getErrorCode() : 0);
        } finally {
            ConnectionPool.getInstance().restoreConnection(connection);
        }

    }

    public static QueryResult runQuery(String sql, Map<Integer, Object> params){
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
            //validation that the query actually did something
            //IF NOT THROW CUSTOM EXCEPTION FROM MYSQL ITSELF
            return new QueryResult(preparedStatement.getUpdateCount()>0,0);
        } catch (InterruptedException | SQLException e) {
            //Just for DEBUGGING
            //System.out.println(e instanceof SQLException ? ((SQLException) e).getErrorCode() : 0);
            //System.out.println(e.getMessage());
            //If the exception is SQL related give back the error code
            return new QueryResult(false,e instanceof SQLException ? ((SQLException) e).getErrorCode() : 0);
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
            //Just for DEBUGGING
            //System.out.println(preparedStatement);
            return preparedStatement.executeQuery();
        } catch (InterruptedException | SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionPool.getInstance().restoreConnection(connection);
        }
    }
}