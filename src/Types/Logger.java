package Types;

//Basic Version ( Thread unsafe singleton )
public class Logger {
    private static Logger instance; //STEP 2: static variable to store instance

    private Logger(){ //STEP 1: Private constructor
        System.out.println("Logger initialised.");
    }

    public static Logger getInstance(){ //STEP 3: public method to return instance
        if (instance == null){
            instance = new Logger();
        }
        return instance;
    }
}

//ensures class has only one instance throughout the lifetime of an application
//provides global access point to that instance


//Three main rules -
//1. Private constructor - prevents direct instantiation from other classes
//2. Static instance variables - stores a single instance
//3. public static getInstance method - returns the single instance
