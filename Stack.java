// Answer to question a Part A.

public class Stack implements IQueueable {

    // Create a queue array variable.
    private String[] queue;

    // To keep track of the head and tail pointer.
    private int head;
    private int tail;

    // To keep track the number of elements in the queue.
    private int size;

    // Initialize the queue array and initial value of head, tail and size is 0.
    public Stack(int capacity) {
        queue = new String[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    // Adds new element to the tail. If queue is full, exception is thrown. The % operator is used to make sure that the tail index wraps around to the beginning of the array if it reaches the end.
    @Override
    public String[] enqueue(String value) {
        if (size == queue.length) {
            throw new IllegalStateException("Queue is full.");
        }
        queue[tail] = value;
        tail = (tail + 1) % queue.length;
        size++;
        return getQueue();
    }

    // Removes and returns the element at the head of the queue. If queue is empty, exception is thrown.
    @Override
    public String dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty.");
        }
        String item = queue[head];
        head = (head + 1) % queue.length;
        size--;
        return item;
    }

    // Returns array containing all elements in the queue by copying the original array.
    @Override
    public String[] getQueue() {
        String[] copy = new String[size];
        for (int i = 0; i < size; i++) {
            copy[i] = queue[(head + i) % queue.length];
        }
        return copy;
    }

    // Returns number of elements in the queue.
    @Override
    public int size() {
        return size;
    }
}


