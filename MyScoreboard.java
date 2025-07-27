public interface MyScoreboard {
    void add(GameEntry entry);
    void remove(int index);
    GameEntry get(int index);
    int size();
    boolean isEmpty();
    void clear();
    void printEntries();
    String toString();
}