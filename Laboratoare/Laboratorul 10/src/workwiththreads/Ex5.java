package workwiththreads;

public class Ex5 {
    public static void main(String[] args) {
        Thread t5 = new Thread(() -> System.out.println("my runnable r5 is run by " + Thread.currentThread().getName()), "thread 5");
        t5.start();
        System.out.println(t5.getPriority());

        t5.setPriority(10);
        System.out.println(t5.getPriority());

        t5.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t5.getPriority());
    }
}
