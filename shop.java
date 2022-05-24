package txtbasedadventure;

import java.util.*;

public class shop {
    private move[] moveShop;
    private potion[] potionShop;

    public shop() {
        moveShop = new move[3];
        moveShop[0] = new move("Power Strike");
        moveShop[1] = new move("Sword Strike");
        moveShop[2] = new move("Ultra Finisher");

        potionShop = new potion[4];
        potionShop[0] = new potion("potion");
        potionShop[1] = new potion("super potion");
        potionShop[2] = new potion("mega potion");
        potionShop[3] = new potion("ultra potion");
    }

    public int movePrice(String move) {
        Map<String, Integer> moveMap = new HashMap<>();
        moveMap.put("Power Strike", 50);
        moveMap.put("Sword Strike", 150);
        moveMap.put("Ultra Finisher", 300);

        return moveMap.get(move);
    }

    public int potionPrice(String potion) {
        Map<String, Integer> potionMap = new HashMap<>();
        potionMap.put("potion", 50);
        potionMap.put("super potion", 75);
        potionMap.put("mega potion", 100);
        potionMap.put("ultra potion", 300);

        return potionMap.get(potion);

    }
}
