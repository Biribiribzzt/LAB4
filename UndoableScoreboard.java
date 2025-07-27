import java.util.EmptyStackException;

public class UndoableScoreboard extends Scoreboard {
    private MyStack<Integer> history;
    private MyStack<GameEntry> historyremove;
    private MyStack<GameEntry> historyadd;
    
    public UndoableScoreboard() {
        super();
        this.history = new ArrayStack<>();
        this.historyremove = new ArrayStack<>();
        this.historyadd = new ArrayStack<>();
    }
    public UndoableScoreboard(int size) {
        super(size);
        this.history = new ArrayStack<>();
        this.historyremove = new ArrayStack<>();
        this.historyadd = new ArrayStack<>();
    }
    @Override
    public void remove(int index){
        historyremove.push(super.get(index));
        super.remove(index);
        history.push(2);
    }
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void add(GameEntry entry) {
        historyadd.push(entry);
        super.add(entry);
        history.push(1);
    }
    
    public GameEntry undo() {
        if (history.isEmpty()) {
            throw new EmptyStackException();
        }
        GameEntry temp = null;
        if (history.pop() == 1) {
            temp = historyadd.pop();
            super.remove(0);
            numberOfEntries--;
        }
        else {
            temp = historyremove.pop();
            super.add(temp);
            numberOfEntries++;
        }
        return temp;
        
    }
}