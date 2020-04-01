public class TaskTest {
    public static void main(String[] args) {
        // Ex 1
        System.out.println("Ex 1");
        Task t1 = new OutTask();
        Task t2 = new RandomOutTask();
        Task t3 = new CounterOutTask();

        t1.task();
        t2.task();
        t3.task();
        t3.task();
        t3.task();
        System.out.println();

        // Ex 2
        System.out.println();
        System.out.println("Ex 2");
        Stack stack = new Stack(10);
        stack.push(t1);
        stack.push(t2);
        stack.push(t3);

        System.out.println("Stack: ");
        while (!stack.isEmpty()) {
            stack.peak();
            stack.pop();
        }

        Queue queue = new Queue(10);
        Task t4 = new OutTask();
        Task t5 = new RandomOutTask();
        Task t6 = new CounterOutTask();
        queue.push(t4);
        queue.push(t5);
        queue.push(t6);

        System.out.println("Queue: ");
        while (!queue.isEmpty()) {
            queue.peak();
            queue.pop();
        }
    }
}
