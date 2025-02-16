package Caching;

import java.util.concurrent.ConcurrentHashMap;

public class CacheManager {

    //in-memory cache using Concurrent HashMap (thread-safe)
    private final ConcurrentHashMap<String,String> cache;

    //private Constructor
    private CacheManager(){
        cache = new ConcurrentHashMap<>();
    }

    //static inner class - bill pugh instance
    private static class CacheHelper{
        private static final CacheManager INSTANCE = new CacheManager();
    }

    public static CacheManager getInstance(){
        return CacheHelper.INSTANCE;
    }

    //method to add data to cache
    public void put(String key, String value){
        cache.put(key,value);
    }

    //method to get data from cache
    public String get(String key){
        return cache.getOrDefault(key,"Not Found");
    }

    //method to remove data from cache
    public void remove(String key){
        cache.remove(key);
    }

    //method to clear all cache
    public void clear(){
        cache.clear();
    }
}
