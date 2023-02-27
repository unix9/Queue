// Answer to question a part A.

public class Queue implements IQueueable {

    private String[] queue;
    private int head;
    private int tail;
    private int size;

    public Queue(int capacity) {
        queue = new String[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public String[] enqueue(String value) {
        if(size == queue.length)
        {
            throw new IllegalStateException("Queue is full.");
        }
        queue[tail] = value;
        tail = (tail + 1) % queue.length;
        size++;
        return getQueue();
    }

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

    @Override
    public String[] getQueue() {
        String[] copy = new String [size];
        int j = 0;
        for (int i = head; i < head + size; i++) {
            copy[j++] = queue[i % queue.length];
        }
        return copy;
    }

    @Override
    public int size() {
        return size;
    }
}
/*
This code is an implementation of a queue data structure using an array. The Queue class implements the IQueueable interface, which specifies the methods that a queue data structure should have.

The Queue class has four instance variables:

    queue: an array of strings that stores the items in the queue.
    head: an integer representing the index of the first item in the queue.
    tail: an integer representing the index of the next available position in the queue.
    size: an integer representing the number of items in the queue.

The Queue constructor takes an integer argument capacity, which is the maximum number of items that the queue can hold. It initializes the queue array with the specified capacity, and sets the head, tail, and size variables to zero.

The enqueue method takes a string argument value, adds the string to the queue array at the tail index, and increments the tail index by one. If the tail index reaches the end of the queue array, it wraps around to the beginning of the array using the modulus operator. It also increments the size variable. If the size variable reaches the queue array's capacity, it throws an exception indicating that the queue is full.

The dequeue method removes the string at the head index of the queue array, and increments the head index by one. If the head index reaches the end of the queue array, it wraps around to the beginning of the array using the modulus operator. It also decrements the size variable. If the size variable is zero, it throws an exception indicating that the queue is empty.

The getQueue method creates a new string array copy with the size of the size variable, and fills it with the items in the queue array starting from the head index. It wraps around to the beginning of the queue array using the modulus operator if necessary.

The size method returns the size variable, which is the number of items in the queue.

 */