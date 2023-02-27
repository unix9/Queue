// Answer to question b Part A.

public class QueueV3 implements IQueueable {

/*
One way to implement enqueue and dequeue methods without using array implementation is to use a linked list.

To implement enqueue method, we create a new node with the value to be added to the queue and add it to the end of the linked list. We update the tail pointer to point to the newly added node.

To implement dequeue method, we remove the node at the head of the linked list and update the head pointer to point to the next node.
 */


    private Node head;
    private Node tail;
    private int size;

    public QueueV3() {
        head = null;
        tail = null;
        size = 0;
    }

    private class Node {
        String value;
        Node next;

        public Node(String value) {
            this.value = value;
            next = null;
        }
    }

    @Override
    public String[] enqueue(String value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
        return getQueue();
    }

    @Override
    public String dequeue() {
        if (head == null) {
            throw new IllegalStateException("Queue is empty.");
        }
        String value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    @Override
    public String[] getQueue() {
        String[] queueArray = new String[size];
        int i = 0;
        Node current = head;
        while (current != null) {
            queueArray[i] = current.value;
            current = current.next;
            i++;
        }
        return queueArray;
    }

    @Override
    public int size() {
        return size;
    }
}
