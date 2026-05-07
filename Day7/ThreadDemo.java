package day_7_Assignment;


class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 2; i++) {
            System.out.println(getName() + " is running, iteration " + i);
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted");
            }
            Thread.yield(); 
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");

        System.out.println(t1.getName() + " Priority: " + t1.getPriority());
        System.out.println(t2.getName() + " Priority: " + t2.getPriority());

        t1.start(); 
        t2.start(); 
        System.out.println(t1.getName() + " Alive? " + t1.isAlive());
        System.out.println(t2.getName() + " Alive? " + t2.isAlive());

        t1.join(); 
        t2.join(); 

        System.out.println(t1.getName() + " Alive after join? " + t1.isAlive());
        System.out.println(t2.getName() + " Alive after join? " + t2.isAlive());

    }
}

