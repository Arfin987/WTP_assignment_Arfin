package day_8_assignment;

class Task1 extends Thread {
    public void run() {
        System.out.println("Task1: Printing numbers");
        for(int i=1; i<=5; i++) {
            System.out.println(i);
        }
    }
}

class Task2 implements Runnable {
    public void run() {
        System.out.println("Task2: Printing letters");
        for(char c='A'; c<='E'; c++) {
            System.out.println(c);
        }
    }
}

public class MultiTaskExample {
    public static void main(String[] args) {
        Task1 t1 = new Task1();
        Thread t2 = new Thread(new Task2());
        t1.start();
        t2.start();
    }
}

