package workwiththreads;

public class Ex3 {
    public static void main(String[] args) {
        for (Thread.State ts : Thread.State.values()) {
            System.out.println(ts);
        }

        Thread t1= new Thread(new Processor(),"processor 1");
        t1.start();
        Thread t2= new Thread(new Processor(),"processor 2");
        t2.start();

        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t1.getState());
        System.out.println(t2.getState());

    }
}
