package Services;

import Singleton.DatabaseSingleton.DatabaseConnectionPool;
import Singleton.LoggerSingleton.Logger;

import java.sql.Connection;

//Use the Logger Singleton in a Service
public class OrderService {
    public void processOrder(){
        Logger logger = Logger.getInstance();
        logger.log("Order processing started.");
        //Business logic
        DatabaseConnectionPool databaseConnectionPool = DatabaseConnectionPool.getInstance();
        try(Connection connection = databaseConnectionPool.getConnection()){
            System.out.println("Executing order query...");
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.log("Order processed.");
    }
}
