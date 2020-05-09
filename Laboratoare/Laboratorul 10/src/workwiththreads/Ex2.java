package workwiththreads;

import java.util.stream.Stream;

public class Ex2 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        t1.start();

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                Stream.iterate(0, i -> i + 2).limit(10)
                        .forEach(i -> System.out.println(i + " on thread " + Thread.currentThread().getName()));
            }
        };
        Thread t2 = new Thread(r2); // state NEW
        t2.start(); // RUNNABLE

        Runnable r3 = () -> System.out.println("my runnable r3");
        new Thread(r3).start();

        new Thread(() -> System.out.println("my runnable r4"), "thread 4").start();

        Thread t5 = new Thread(() -> System.out.println("my runnable r5 is run by " + Thread.currentThread().getName()), "thread 5");
        t5.start();
    }
}
