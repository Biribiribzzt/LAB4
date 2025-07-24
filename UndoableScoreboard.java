import java.util.EmptyStackException;

public class UndoableScoreboard extends Scoreboard {
    private MyStack<GameEntry> history;

    public UndoableScoreboard() {
        super();
        this.history = new ArrayStack<>();
    }
    public UndoableScoreboard(int size) {
        super(size);
        this.history = new ArrayStack<>();
    }

    @Override
    public void add(GameEntry entry) {
        history.push(entry);
        super.add(entry);
    }

    public GameEntry undo() {
        if (history.isEmpty()) {
            throw new EmptyStackException();
        }
        GameEntry lastEntry = history.pop();
        numberOfEntries--;
        return lastEntry;
    }
}