package txtbasedadventure;

import java.util.*;

public class monster {
    private String name;
    private int health;

    public monster(String name) {
        this.name = name;
    }

    //"Chimera", "Basilisk", "Hydra", "Centaur", "Goblin"

    public int monDamage() {
        Map<String, Integer> monDamage = new HashMap<>();
        monDamage.put("Goblin", 20);
        monDamage.put("Basilisk", 100);
        monDamage.put("Hydra", 200);
        monDamage.put("Centaur", 50);
        monDamage.put("Chimera", 75);

        return monDamage.get(name);
        
    }
    
    public void setMonHealth() {
        Map<String, Integer> monHealth = new HashMap<>();
        monHealth.put("Goblin", 100);
        monHealth.put("Basilisk", 150);
        monHealth.put("Hydra", 200);
        monHealth.put("Centaur", 250);
        monHealth.put("Chimera", 300);

        health = monHealth.get(name);

    }

    public int getHealth() {
        return health;
    }

    public void deductHealth(int damage) {
        health -= damage;
    }


    public String toString() {
        return name;
    }
}