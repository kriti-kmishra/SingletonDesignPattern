# Singleton Design Pattern in Depth

## 🌟 What is Singleton Design Pattern?
The **Singleton Pattern** is a creational design pattern that ensures **only one instance** of a class is created and provides a global point of access to it.

### 🚀 **Why was Singleton Introduced?**
To manage shared resources effectively, such as:
- **Database connections** (Only one shared connection pool)
- **Caching** (Single cache storage for all requests)
- **Logging services** (One logger instance for consistent logs)

**Mnemonic (Indian Context):** "One Gas Cylinder for the Whole Kitchen 🍲" – Only one shared cylinder serves multiple burners!

---

## ⚙️ Basic Singleton Implementation
```java
class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```
**Drawback:** Not thread-safe.

**Mnemonic:** "One Tiffin shared by the whole family 🍱 – But siblings might fight if not organized!"

---

## 🛡️ Types of Singleton Implementations:
### 1️⃣ **Thread-Safe Singleton**
```java
public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;
    private ThreadSafeSingleton() {}
    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}
```
**Mnemonic:** "One serving spoon 🍛 – Wait for your turn to serve!"

### 2️⃣ **Double-Checked Locking Singleton**
```java
public class DoubleCheckedSingleton {
    private static volatile DoubleCheckedSingleton instance;
    private DoubleCheckedSingleton() {}
    public static DoubleCheckedSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}
```
**Mnemonic:** "Check twice before adding salt to biryani 🍛 – Save resources, avoid duplicates!"

### 3️⃣ **Bill Pugh Singleton** (Recommended)
```java
public class BillPughSingleton {
    private BillPughSingleton() {}
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
```
**Mnemonic:** "Tandoor stays hot 🌮 – Ready to serve without wasting fuel!"

---

## ⚠️ Issues with Singleton:
### 1️⃣ **Problem with Serialization:**
- **Issue:** Deserializing creates a new instance.
- **Solution:** Implement `readResolve()` method.
```java
protected Object readResolve() {
    return getInstance();
}
```
**Mnemonic:** "Reheat leftovers 🍛 – Same dish, not a new one!"

### 2️⃣ **Problem with Enum Singleton:**
- **Issue:** Difficult to extend or control laziness.
- **Solution:** Use only for truly singleton services.
```java
public enum EnumSingleton {
    INSTANCE;
    public void someMethod() {}
}
```
**Mnemonic:** "Like Chai ☕ – Simple but limited in flavor!"

---

