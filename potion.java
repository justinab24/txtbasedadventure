package txtbasedadventure;

import java.util.*;

public class potion extends item {
    private String name;

    public potion(String name) {
        this.name = name;
    }

    public int healthBoost() {
        Map<String, Integer> potionBoost = new HashMap<>();
        potionBoost.put("potion", 25);
        potionBoost.put("super potion", 50);
        potionBoost.put("mega potion", 75);
        potionBoost.put("ultra potion", 100);

        return potionBoost.get(name);
    }  
    
}
