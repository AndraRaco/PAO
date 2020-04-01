import java.util.Random;

public class RandomOutTask implements Task {
    private int number;

    public RandomOutTask() {
        Random random = new Random();
        number = random.nextInt();
    }

    @Override
    public void task() {
        System.out.println(number);
    }
}
