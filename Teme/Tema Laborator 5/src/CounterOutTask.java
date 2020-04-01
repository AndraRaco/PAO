public class CounterOutTask implements Task {
    private static int counter = 0;

    @Override
    public void task() {
        System.out.println(++counter);
    }
}
