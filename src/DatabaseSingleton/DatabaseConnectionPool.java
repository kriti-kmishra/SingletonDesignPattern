package DatabaseSingleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class DatabaseConnectionPool {

    private final static int POOL_SIZE = 5;
    private final BlockingQueue<Connection> connectionPool;

    //private constructor to create the pool
    private DatabaseConnectionPool(){
        connectionPool = new LinkedBlockingQueue<>(POOL_SIZE);
        for(int i=0;i<POOL_SIZE;i++){
            connectionPool.add(createConnection());
        }
        System.out.println("Database connection pool created with size: " + POOL_SIZE);
    }

    //static inner class - Bill Pugh singleton
    private static class SingletonHelper{
        private static final DatabaseConnectionPool INSTANCE = new DatabaseConnectionPool();
    }

    public static DatabaseConnectionPool getInstance(){
        return SingletonHelper.INSTANCE;
    }
    //method to create a new DB connection
    public static Connection createConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
        }catch (SQLException e){
            throw new RuntimeException("Error creating database connection.");
        }
    }

    //method to get a connection from the pool
    public Connection getConnection() throws InterruptedException{
        return connectionPool.take();
    }

    //method to return  connection to the pool
    public void releaseConnection(Connection connection){
        if(connection != null){
            connectionPool.offer(connection);
        }
    }



}
