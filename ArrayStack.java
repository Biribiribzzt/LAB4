import java.util.EmptyStackException;

public class ArrayStack<E> implements MyStack<E> {
    private int top;
    private E[] stack;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        stack = (E[]) new Object[capacity];
        top = -1;
    }

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void push(E value) {
        if (top == stack.length - 1) {
            @SuppressWarnings("unchecked")
            E[] newStack = (E[]) new Object[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
        }
        stack[++top] = value;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E value = stack[top];
        stack[top] = null; top--;
        if (top < stack.length / 4) {
            @SuppressWarnings("unchecked")
            E[] newStack = (E[]) new Object[stack.length / 2];
            System.arraycopy(stack, 0, newStack, 0, top + 1);
            stack = newStack;
        }   
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top];
    }
    public E peek(int index) {
        if (index < 0 || index > top) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        return stack[top - index];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int size() {
        return top + 1;
    }
}
