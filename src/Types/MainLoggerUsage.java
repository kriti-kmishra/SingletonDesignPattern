package Types;

public class MainLoggerUsage {
    public static void main(String[] args) {
        Logger log1 = Logger.getInstance();
        Logger log2 = Logger.getInstance();
        System.out.println("Are log1 & log2 equal???  " + (log1==log2)); //true - same instance
    }
}
