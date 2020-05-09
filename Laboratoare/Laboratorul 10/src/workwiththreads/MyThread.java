package workwiththreads;

public class MyThread extends Thread {
    @Override
    public void run() {
        this.setName("MyThread");
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName() + " step " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
