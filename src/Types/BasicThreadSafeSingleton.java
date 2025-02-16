package Types;

public class BasicThreadSafeSingleton {

    private static BasicThreadSafeSingleton instance;

    private BasicThreadSafeSingleton(){
        System.out.println("Basis Thread Safe Singleton created.");
    }

    public static synchronized BasicThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new BasicThreadSafeSingleton();

        }
        return instance;
    }
}


//Ensures thread safety
//The synchronised keyword ensures that only one thread at a time can execute getInstance()
//Drawback: Performance issue - every call to getInstance() acquires a locl, even when the instance is already created.



