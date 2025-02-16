### **🎯 Real-World Use Case: Singleton for Logging**  

### **🔹 Why Singleton for Logging?**  
- **Logging frameworks** (e.g., `Log4j`, `SLF4J`, `java.util.logging`) are used to **record application events** (e.g., errors, transactions, performance).  
- Multiple parts of an application (e.g., controllers, services, repositories) **need access to the same logger**.  
- Creating multiple logger instances wastes resources and makes **log management chaotic**.  

✅ **Singleton ensures only one logger instance** handles all logs consistently.  

---

### **🔹 Singleton Solution: Logger Manager**  
- Use **Bill Pugh Singleton** to create a **global logger**.  
- **Thread-safe and high-performance** (important for large-scale applications).  
- **Consistent logs** from all parts of the application.  

---

## **1️⃣ Logger Singleton Using Bill Pugh Approach**  

### **🔹 Code Example:**  
```java
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

class Logger {
    
    private static final String LOG_FILE = "app.log";
    private PrintWriter writer;

    // Private constructor to initialize file writer
    private Logger() {
        try {
            writer = new PrintWriter(new FileWriter(LOG_FILE, true));
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize logger", e);
        }
    }

    // Static Inner Class for Singleton
    private static class LoggerHelper {
        private static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance() {
        return LoggerHelper.INSTANCE;
    }

    // Method to log messages
    public void log(String message) {
        String logMessage = LocalDateTime.now() + " - " + message;
        System.out.println(logMessage);  // Print to console
        writer.println(logMessage);      // Write to file
        writer.flush();
    }

    // Close the writer when done
    public void close() {
        if (writer != null) {
            writer.close();
        }
    }
}
```

---

### **🔹 How It Works:**  
1. **Bill Pugh Singleton:** Only one logger instance handles all logs.  
2. **Thread-Safe:** Multiple threads can log events without conflicts.  
3. **Log File:** All logs are written to a **single log file**.  
4. **Console Output:** Logs are also displayed on the console.  

---

### **🔹 Mnemonic (Indian Context 🇮🇳) – "Railway Announcement System 🚂🎙️"**  
- **One announcer (Singleton)** announces for **all trains**.  
- Passengers from **all platforms hear the same message**.  
- **Consistent and centralized information**.  
- Similarly, **one logger instance** records logs for **all services**.  

---

## **2️⃣ How to Use the Logger Singleton in a Service:**  
```java
public class PaymentService {
    public void processPayment() {
        Logger logger = Logger.getInstance();
        logger.log("Payment processing started...");
        // Business logic
        logger.log("Payment processed successfully.");
    }
}

public class OrderService {
    public void processOrder() {
        Logger logger = Logger.getInstance();
        logger.log("Order processing started...");
        // Business logic
        logger.log("Order placed successfully.");
    }
}
```

---

### **🔹 Example Output in `app.log`:**  
```
2025-02-16T10:15:32 - Payment processing started...
2025-02-16T10:15:35 - Payment processed successfully.
2025-02-16T10:16:01 - Order processing started...
2025-02-16T10:16:03 - Order placed successfully.
```

---

### ✅ **Benefits of Singleton for Logging:**  
- **Centralized Logging:** All logs come from a **single source**, making debugging easier.  
- **Consistent Log Format:** Same format across the application.  
- **Thread-Safety:** Multiple components log without conflicts.  
- **Performance:** Single instance reduces overhead.  
- **Resource Efficiency:** Only **one file writer instance** is used.  

---
