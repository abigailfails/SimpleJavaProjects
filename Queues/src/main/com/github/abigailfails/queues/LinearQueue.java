package main.com.github.abigailfails.queues;

public class LinearQueue<T> {
    private final T[] queue;
    private int size, front, rear;

    /**
     * @param queue must be empty
     * */
    public LinearQueue(T[] queue) {
        //TODO add something to force the array to be empty, probably a loop
        this.queue = queue;
        this.front = 0;
        this.rear = -1;
    }

    public void enQueue(T item) {
        rear++;
        size++;
        
        queue[rear] = item;
    }

    public T deQueue() {
        front++;
        return queue[front-1];
    }

    public boolean isFull() {
        return rear  == queue.length;
    }

    public boolean isEmpty() {
        return rear+1 == front;
    }
}
