// Answer to question c Part A.

public class StackV2 implements IQueueable {

    /*
    stack: an array of Strings that stores the elements of the Stack.
    top: an integer variable that points to the index of the top element in the Stack.
     */
    private String[] stack;
    private int top;

    // initializes an array of the specified capacity and sets the top pointer to -1, which means it is empty.
    public StackV2(int capacity) {
        stack = new String[capacity];
        top = -1;
    }
    //Checks if the stack is full, if it is, IllegalStateException is thrown. Else, the method increments the top pointer and adds the new element to the array at the index specified by the top pointer. Then, it calls getQueue() method to return a copy of the current stack.
    @Override
    public String[] enqueue(String value) {
        if (top == stack.length - 1) {
            throw new IllegalStateException("Stack is full");
        }
        stack[++top] = value;
        return getQueue();
    }

    // Removes and returns the top element in the stack. If stack is empty, IllegalStateException is thrown. Else, it will take the top element from the array, decrements the top pointer and returns the top element.
    @Override
    public String dequeue() {
        if (top == -1) {
            throw new IllegalStateException("Stack is empty.");
        }
        String item = stack[top--];
        return item;
    }

    // Returns a copy of the stack as an array of Strings.
    @Override
    public String[] getQueue() {
        String[] copy = new String[top+1];
        for(int i = 0; i <= top; i++) {
            copy[i] = stack[i];
        }
        return copy;
    }

    // returns the number of elements in the stack, which is equal to the top pointer + 1.
    @Override
    public int size() {
        return top + 1;
    }
}

