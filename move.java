package txtbasedadventure;

import java.util.*;

public class move {
    private String name;

    public move(String name) {
        this.name = name;

    }

    public int damage() {
        Map<String, Integer> moveDamage = new HashMap<>();
        moveDamage.put("Punch", 20);
        moveDamage.put("Power Strike", 75);
        moveDamage.put("Sword Strike", 150);
        moveDamage.put("Ultra Finisher", 300);

        return moveDamage.get(name);
    }

    public String toString() {
        return name;
    }
    
}
