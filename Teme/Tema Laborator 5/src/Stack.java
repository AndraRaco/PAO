public class Stack {
    private int capacity;
    private int currentSize = 0;
    private Task[] stack;

    public Stack() {
        capacity = 10;
        stack = new Task[capacity];
    }

    public Stack(int size) {
        if (size < 1) {
            size = 10;
        }
        capacity = size;
        stack = new Task[capacity];
    }

    public Stack(int capacity, int currentSize, Task[] stack) {
        this.capacity = capacity;
        this.currentSize = currentSize;
        this.stack = stack;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize >= capacity;
    }

    public boolean push(Task t) {
        if (isFull()) {
            return false;
        }
        stack[currentSize++] = t;
        return true;
    }

    public Task pop() {
        if (isEmpty()) {
            return null;
        }
        currentSize--;
        return stack[currentSize];
    }

    public void delete() {
        currentSize = 0;
    }

    public void peak() {
        if (!isEmpty()) {
            stack[currentSize - 1].task();
        }
    }

}
