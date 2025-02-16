package Services;

import Singleton.LoggerSingleton.Logger;

//Use the Logger Singleton in a Service
public class PaymentService {
    public void processPayment(){
        Singleton.LoggerSingleton.Logger logger = Logger.getInstance();
        logger.log("Payment started.");
        //Business logic
        logger.log("Payment processed.");
    }
}
