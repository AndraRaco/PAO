public class Queue {
    private int capacity;
    private int beginIndex = 0;
    private int endIndex = 0;
    private Task[] queue;

    public Queue() {
        capacity = 10;
        queue = new Task[capacity];
    }

    public Queue(int size) {
        if (size < 1) {
            size = 10;
        }
        capacity = size;
        queue = new Task[capacity];
    }

    public Queue(int capacity, int beginIndex, int endIndex, Task[] queue) {
        this.capacity = capacity;
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
        this.queue = queue;
    }

    public boolean isEmpty() {
        return endIndex - beginIndex == 0;
    }

    public boolean isFull() {
        return endIndex - beginIndex >= capacity;
    }

    public boolean push(Task t) {
        if (isFull()) {
            return false;
        }
        queue[endIndex++] = t;
        return true;
    }

    public Task pop() {
        if (isEmpty()) {
            return null;
        }
        return queue[beginIndex++];
    }

    public void delete() {
        endIndex = 0;
        beginIndex = 0;
    }

    public void peak() {
        if (!isEmpty()) {
            queue[beginIndex].task();
        }
    }
}
