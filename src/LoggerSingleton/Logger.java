package LoggerSingleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

//Logger Singleton using Bill Pugh Approach
//thread-safe and high performance
//use bill pugh to create a global logger
public class Logger {

    private static final String LOG_FILE = "app.log";
    private PrintWriter writer;


    //private constructor to initialize file writer
    private Logger(){
        try{
            writer = new PrintWriter(new FileWriter(LOG_FILE,true));
        }catch (IOException e){
            throw new RuntimeException("Failed to initialize logger", e);
        }
    }

    //static inner class for singleton
    private static class LoggerHelper{
        private static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance(){
        return LoggerHelper.INSTANCE;
    }


    //method to log messages
    public void log(String message){
        String logMessage = LocalDateTime.now() + " - " + message;
        System.out.println(logMessage);
        writer.println(logMessage);
        writer.flush();
    }

    //close the writer when done
    public void close(){
        if(writer != null){
            writer.close();
        }
    }
}
