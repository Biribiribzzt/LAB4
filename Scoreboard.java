public class Scoreboard implements MyScoreboard {
    protected MyStack<GameEntry> entries;
    protected int numberOfEntries;
    protected static final int DEFAULT_SIZE = 10;

    public Scoreboard() {
        MyStack<GameEntry> stack = new ArrayStack<>(DEFAULT_SIZE);
        this.entries = stack;
    }

    public Scoreboard(int size) {
        MyStack<GameEntry> stack = new ArrayStack<>(size);
        this.entries = stack;
    }

    @Override
    public GameEntry get(int index) {
        if (index < 0 || index >= numberOfEntries) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numberOfEntries);
        }
        return entries.peek(index);
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= numberOfEntries) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numberOfEntries);
        }
        MyStack<GameEntry> tempStack = new ArrayStack<>();
        for (int i = 0; i < index; i++) {
            tempStack.push(entries.pop());
        }
        entries.pop();
        while (!tempStack.isEmpty()) {
            entries.push(tempStack.pop());
        }
    }

    @Override
    public void add(GameEntry entry) {
        entries.push(entry);
        numberOfEntries++;
    }
    @Override
    public int size() {
        return numberOfEntries;
    }
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }
    @Override
    public void clear() {
        while (!entries.isEmpty()) {
            entries.pop();
        }
        numberOfEntries = 0;
    }
    public MyStack<GameEntry> getEntries() {
        return entries;
    }
    public void printEntries() {
        for (int i = 0; i < numberOfEntries; i++) {
            System.out.println(entries.peek(i));
        }
    }
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";    
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < numberOfEntries; i++) {
            if (entries.peek(i) == null){
                continue;
            }else{
                sb.append(entries.peek(i).toString());
            }
            if (i < numberOfEntries - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

    