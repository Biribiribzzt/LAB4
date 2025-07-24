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
}
    