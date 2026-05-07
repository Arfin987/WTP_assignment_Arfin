package day_8_assignment;

class Counter implements Runnable {
    private int count = 0;
    public synchronized void increment() {
        count++;
        System.out.println("Count: " + count);
    }
    public void run() {
        for(int i=0; i<5; i++) {
            increment();
        }
    }
}

public class SyncExample {
    public static void main(String[] args) {
        Counter c = new Counter();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}
