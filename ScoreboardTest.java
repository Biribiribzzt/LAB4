
public class ScoreboardTest {
    public static void main(String[] args) {
        MyScoreboard scoreboard = new Scoreboard(5);
        
        // Test adding entries
        scoreboard.add(new GameEntry("Alice", 100));
        scoreboard.add(new GameEntry("Bob", 200));
        scoreboard.add(new GameEntry("Charlie", 150));
        System.out.println("Added entries:");
        for (int i = 0; i < scoreboard.size(); i++) {
            System.out.println(scoreboard.get(i));
        }
        
        // Test size and isEmpty
        System.out.println("Size: " + scoreboard.size()); // Expected: 3
        System.out.println("Is Empty: " + scoreboard.isEmpty()); // Expected: false
        
        // Test getting entries
        System.out.println("Entry at index 0: " + scoreboard.get(0)); // Expected: Alice's entry
        System.out.println("Entry at index 1: " + scoreboard.get(1)); // Expected: Bob's entry
        
        // Test clearing the scoreboard
        scoreboard.clear();
        System.out.println("Size after clear: " + scoreboard.size()); // Expected: 0
    }
}  

