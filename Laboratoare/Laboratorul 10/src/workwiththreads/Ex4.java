package workwiththreads;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Ex4 {
    public static void main(String[] args) {
        PrintEvenNumbers task = new PrintEvenNumbers();
        Thread thread=new Thread(task,"t1");
        thread.start();
        System.out.println(thread.getName()+" is in state "+thread.getState());
        thread.interrupt();
    }

    static class PrintEvenNumbers implements Runnable{

        @Override
        public void run() {
            IntStream.rangeClosed(0,10).filter(i->i%2 == 0).forEach(System.out::println);
            System.out.println("is thread interrupted -> "+ Thread.currentThread().isInterrupted());

            if (Thread.interrupted()){
                System.out.println("is thread interrupted -> "+ Thread.currentThread().isInterrupted());
            }
            System.out.println(Thread.currentThread().getState()+ " is running task");
        }
    }
}
