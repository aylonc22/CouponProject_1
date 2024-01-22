package cls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

public class ConnectionPool {
    //singleTon
    //number of connection to sql (maximum is 20, default is 10)
    private static final int NUMBER_OF_CONNECTION=10;
    public static ConnectionPool instance=null;
    private final Stack<Connection> connections = new Stack<>();

    private ConnectionPool() {
        System.out.println("We created new connection pool instance");
        try {
            openAllConnections();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void openAllConnections() throws SQLException {
        //create connections according to NUMBER_OF_CONNECTION variable
        for (int counter=0;counter<NUMBER_OF_CONNECTION;counter++){
            //we creating a new connection using the DriverManger
            Connection connection = DriverManager.getConnection(DBmanager.URL,DBmanager.SQL_USER,DBmanager.SQL_PASSWORD);
            connections.push(connection);
        }
    }

    public static ConnectionPool getInstance() {
        //first check if instance is null
        if (instance==null){
            synchronized (ConnectionPool.class){
                //double check, that no other thread create an instance
                if (instance==null){
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }

    public void closeAllConnections() throws InterruptedException {
        //lock connections, that we will not give any new connection
        synchronized (connections){
            while (connections.size()<NUMBER_OF_CONNECTION){
                //wait until all connection is done..
                connections.wait();
            }
            connections.removeAllElements();
        }
    }

    public Connection getConnection() throws InterruptedException {
        //lock the connections
        synchronized (connections){
            //check if we have connection to give
            if (connections.isEmpty()){
                //wait until somebody will return a connection
                connections.wait();
            }
            return connections.pop();
        }
    }

    public void returnConnection(Connection connection){
        synchronized (connections){
            //return the connection to the stack collection
            connections.push(connection);
            //notify that we got back a connection from a user
            connections.notify();
        }
    }
}
