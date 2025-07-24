public class ArrayQueue<E> implements MyQueue<E> {
    private int front;
    private int rear;
    private E[] queue;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        queue = (E[]) new Object[capacity];
        front = 0;
        rear = -1;
    }

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void enqueue(E value) {
        if (size() == queue.length) {
            @SuppressWarnings("unchecked")
            E[] newQueue = (E[]) new Object[queue.length * 2];
            System.arraycopy(queue, 0, newQueue, 0, queue.length);
            queue = newQueue;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = value;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        E value = queue[front];
        queue[front] = null; 
        front = (front + 1) % queue.length;
        if (size() < queue.length / 4) {
            @SuppressWarnings("unchecked")
            E[] newQueue = (E[]) new Object[queue.length / 2];
            int size = size();
            for (int i = 0; i < size; i++) {
                newQueue[i] = queue[(front + i) % queue.length];
            }
            queue = newQueue;
            front = 0;
            rear = size - 1;
        }
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return (rear - front + queue.length) % queue.length + 1;
    }

     
}