package txtbasedadventure;

public class player {
    private String name;
    private int health;
    public move[] moveList = new move[4];
    private potion[] potionList = new potion[3];
    private int money;


    public player(String name) {
        this.name = name;
        this.health = 100;
        moveList[0] = new move("Punch");
        money = 200;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void addHealth(int boost) {
        if ((100 - health) < boost) {
            health += 100 - health;
        } else {
            health += boost;
        }
    }

    public void deductHealth(int damage) {
        if ((health - damage) < 0) {
            health = 0;
        } else {
            health -= damage;
        }
    }

    public int getMoney() {
        return money;
    }

    public void deductMoney(int amount) {
        money -= amount;
    }

    public String learnMove(move newMove) {
        if (moveList.length == 4) {
            return "You currently have the max amount of moves allowed (4)";
        } else {
            move[] newMoveList = new move[moveList.length + 1];
            for(int i = 0; i < moveList.length; i++) {
                moveList[i] = newMoveList[i];
            }
            newMoveList[newMoveList.length - 1] = newMove;
            moveList = newMoveList;
            return("You succesfully learned" + newMove);
        }
    }
}
