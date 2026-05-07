package day_7_Assignment;


class FoodDelivery extends Thread {
    private static final Object lock = new Object();

    public FoodDelivery(String name) {
        setName(name);
    }

    public void run() {
        synchronized (lock) { 
            try {
                System.out.println(getName() + " started");
                Thread.sleep(2000);
                System.out.println(getName() + " completed");
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted");
            }
        }
    }
}

public class SyncDemo {
    public static void main(String[] args) throws InterruptedException {
        FoodDelivery order = new FoodDelivery("Order Processing");
        FoodDelivery kitchen = new FoodDelivery("Kitchen Processing");
        FoodDelivery delivery = new FoodDelivery("Delivery Processing");

        order.start();
        kitchen.start();
        delivery.start();

        order.join();
        kitchen.join();
        delivery.join();

        System.out.println("All tasks completed.");
    }
}
