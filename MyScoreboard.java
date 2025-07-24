public interface MyScoreboard {
    void add(GameEntry entry);
    GameEntry get(int index);
    int size();
    boolean isEmpty();
    void clear();
    void printEntries();
}