public class OutTask implements Task {
    private String message;

    public OutTask() {
        message = "This is the message.";
    }

    @Override
    public void task() {
        System.out.println(message);
    }
}
