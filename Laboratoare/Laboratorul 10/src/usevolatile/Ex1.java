package usevolatile;

public class Ex1 {
    private static volatile int outer;

    public static void main(String[] args) {
        Thread rt=new Thread(new ReaderTask(),"reader");
        rt.start();
        Thread wt=new Thread(new WriterTask(),"writer");
        wt.start();

        try {
            rt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            wt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class ReaderTask implements Runnable {

        @Override
        public void run() {
            int local = outer;
            while (local < 3) {
                if (local != outer) {
                    local = outer;
                    System.out.println("local value from " + Thread.currentThread().getName() + " is " + local);
                }
            }
        }
    }

    static class WriterTask implements Runnable {

        @Override
        public void run() {
            int local = outer;
            while (outer < 3) {
                System.out.println("local value from " + Thread.currentThread().getName() + " is " + local);
                outer = ++local;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
