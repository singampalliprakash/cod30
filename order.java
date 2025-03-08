import java.util.concurrent.*;

class Order implements Runnable {
    private static int orderCount = 1000;
    private final String orderId;
    private final String customerName;
    private final String tableNumber;
    private final String items;

    public Order(String customerName, String tableNumber, String items) {
        this.orderId = "ORD" + (++orderCount);
        this.customerName = customerName;
        this.tableNumber = tableNumber;
        this.items = items;
    }

    public String getOrderId() {
        return orderId;
    }

    @Override
    public void run() {
        try {
            System.out.println("Processing Order: " + orderId + " (Preparing...)");
            Thread.sleep(3000); 
            System.out.println("Order " + orderId + " is Ready for Delivery!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class RestaurantOrderSystem {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Order order1 = new Order("John Doe", "5", "Burger x2, Coke x1");
        Order order2 = new Order("Alice", "2", "Pizza x1, Pasta x1");
        Order order3 = new Order("Bob", "3", "Fries x3, Soda x2");

        System.out.println("Order Placed Successfully! " + order1.getOrderId());
        System.out.println("Order Placed Successfully! " + order2.getOrderId());
        System.out.println("Order Placed Successfully! " + order3.getOrderId());

        executor.execute(order1);
        executor.execute(order2);
        executor.execute(order3);

        executor.shutdown();
    }
}
