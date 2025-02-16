package Services;

import Singleton.Caching.CacheManager;

public class ProductService {

    public void loadProducts(){
        CacheManager cache = CacheManager.getInstance();
        cache.put("Product 1", "Laptop");
        cache.put("product 2", "Mobile");
        System.out.println("Products added to cache.");
    }

    public void getProduct(String productId){
        CacheManager cacheManager = CacheManager.getInstance();
        String product = cacheManager.get(productId);
        System.out.println("Retrieved from cache:" + product);
    }
}
