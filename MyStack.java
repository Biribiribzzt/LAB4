public interface MyStack<E> {
    void push(E value);
    E pop();
    E peek();
    boolean isEmpty();
    int size();
    E peek(int index); // Added method to peek at a specific index
} 
