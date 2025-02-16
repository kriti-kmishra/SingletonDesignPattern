package Types;

public class BillPughSingleton {

    private BillPughSingleton(){
        System.out.println("BillPughSingleton:: Singleton instance created.");
    }

    private static class SingletonHelper{ //static inner class
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
/*
The outer class is loaded first, but SingletonHelper is not loaded yet.
When getInstance() is called, only then does SingletonHelper class load and create the instance.
JVM ensures thread safety by loading the class in a thread-safe manner.
*/

/*
✅ Lazy Initialization – Instance is created only when needed.
✅ Thread-safe without explicit synchronization.
✅ No need for volatile, synchronization, or complex locking mechanisms.
✅ Faster than Double-Checked Locking.
*/


/*
🔹 Mnemonic (Indian Context 🇮🇳) – "Hostel Room Key System 🏨🔑"
The hostel warden keeps all room keys in a locker.
Nobody accesses the locker until someone actually needs a key (getInstance() is called).
When a student requests a key, the warden opens the locker and gives the correct key (loading the inner class).
Similarly, SingletonHelper is loaded only when needed, ensuring lazy initialization and thread safety.
*/
