package Types;

public class DoubleCheckedLockingSingleton {

    private static volatile DoubleCheckedLockingSingleton instance; //volatile insures visibility and ordering

    private DoubleCheckedLockingSingleton(){
        System.out.println("DoubleCheckedLockingSingleton::Singleton instance created.");
    }

    public static DoubleCheckedLockingSingleton getInstance(){
        if(instance == null){
            synchronized (DoubleCheckedLockingSingleton.class){
                if(instance==null){
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }


}

//Double-checked locking improves performance by locking only when needed
//high performance - sync occurs only once
//Lazy initialization - instance is created only when needed.


/*
Mnemonic (Indian Context 🇮🇳) – "Bank Locker Room System 🏦🔐"
- A person checks outside if the locker room is empty (First Check).
- If empty, he takes a key from the manager (Synchronization).
- Before entering, he checks again inside to ensure no one else is there (Second Check).
- If no one is inside, he locks the door and enters.
Similarly, Double-Checked Locking ensures only one instance is created efficiently.

*/
