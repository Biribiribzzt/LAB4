public class ScoreboardTest {
    public static void main(String[] args) {
        UndoableScoreboard usb = new UndoableScoreboard(5);

        usb.add(new GameEntry("Alice", 100));
        usb.add(new GameEntry("Bob", 200));
        System.out.println("Scoreboard after adds: " + usb);
        // Expected: [Bob(200), Alice(100)]

        // Now, undo the last action (adding Bob)
        usb.undo();
        System.out.println("Scoreboard after undo: " + usb);
        // Expected: [Alice(100)]

        // Remove Alice
        usb.remove(0);
        System.out.println("Scoreboard after remove: " + usb);
        // Expected: []

        // This undo is more complex and not required by the lab,
        // but shows the limitation. A full command pattern would be needed.
        usb.undo(); 
        System.out.println("Scoreboard after second undo: " + usb);
    }
}
