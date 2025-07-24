public interface MyQueue<E> {
    void enqueue(E value);
    E dequeue();
    E peek();
    boolean isEmpty();
    int size();
} 
    
