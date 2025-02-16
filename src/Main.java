import Singleton.Services.OrderService;
import Singleton.Services.PaymentService;
import Singleton.Services.ProductService;

public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        PaymentService paymentService = new PaymentService();
        orderService.processOrder();
        paymentService.processPayment();

        ProductService productService = new ProductService();
        productService.getProduct("Product 1");
    }
}
