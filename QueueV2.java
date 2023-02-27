// Answer to question c part A

public class QueueV2 implements IQueueable {

    
/*

    Dynamic resizing: if the queue becomes full, the enqueue() method will automatically resize the array to double its current size before adding the new item. This ensures that the queue can fill in any number of items without setting the inital value of the queue.

    Nulling dequeued items: when an item is dequeued from the queue, its slot in the underlying array is set to null. This ensures that the array doesn't fill up with stale references, which could prevent old items from being garbage-collected and waste memory.

    Simplified getQueue() method: the getQueue() method now simply iterates over the array to copy its contents into a new array, without needing to adjust the indices based on the head or tail pointers. This makes the method simpler to understand and less error.

 */

    private String[] queue;
    private int head;
    private int tail;
    private int size;

    public QueueV2(int capacity) {
        queue = new String[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public String[] enqueue(String value) {
        if (size == queue.length) {
            resizeQueue();
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
        queue[head] = null;
        head = (head + 1) % queue.length;
        size--;
        return item;
    }

    @Override
    public String[] getQueue() {
        String[] copy = new String[size];
        for (int i = 0; i < size; i++) {
            copy[i] = queue[(head + i) % queue.length];
        }
        return copy;
    }

    @Override
    public int size() {
        return size;
    }

    private void resizeQueue() {
        String[] newQueue = new String[queue.length * 2];
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(head + i) % queue.length];
        }
        queue = newQueue;
        head = 0;
        tail = size;
    }
}
