package txtbasedadventure;

import java.util.*;

public class gameMain {
    public static void main(String[] args) {


        String[] gameMons = {"Chimera", "Basilisk", "Hydra", "Centaur", "Goblin"};

        
        Scanner input = new Scanner(System.in);
        System.out.print("Welcome new player! What is your name? ");
        player user = new player(input.nextLine());



        boolean running = true;

        while(running) {
            System.out.println("What would you like to do? \n 1. Explore(E) \n 2. Shop(S) \n 3. Quit(Q)");
            char userChoice = input.next().charAt(0);
            if (userChoice == 'E') {
                Random rand = new Random();
                int encounterChance = rand.nextInt(2);
                if (encounterChance == 0) {
                    System.out.println("You did not find anything");
                } else if (encounterChance == 1) {
                    int randMonIndex = rand.nextInt(gameMons.length);
                    monster randMon = new monster(gameMons[randMonIndex]);
                    randMon.setMonHealth();
                    System.out.println("A wild " + randMon + " appeared! What would you like to do? \n 1. Fight(F) \n 2. Run(R)");
                    char fightChoice = input.next().charAt(0);
                    if(fightChoice == 'F') {
                        while (user.getHealth() > 0 && randMon.getHealth() > 0) {
                            System.out.println(user.getHealth());
                            System.out.println(randMon.getHealth());
                            for(int i = 1; i <= user.moveList.length; i++) {
                                System.out.println(i + ". " + user.moveList[i-1]);
                            }
                            System.out.println("Which move would you like to use?");
                            int moveChoice = input.nextInt();
                            System.out.println("You used " + user.moveList[moveChoice-1] + " !");
                            randMon.deductHealth(user.moveList[moveChoice-1].damage());
                            System.out.println("The " + randMon + " attacked back!");
                            user.deductHealth(randMon.monDamage());
                            System.out.println(user.getHealth());
                            System.out.println(randMon.getHealth());
                        }
                        if (user.getHealth() <= 0) {
                            System.out.println("You lost to the " + randMon + " !");
                            running = false;
                        } else {
                            System.out.println("You defeated the " + randMon + " !");
                        }
                    } else if (fightChoice == 'R') {
                        int runSuccess = rand.nextInt(2);
                        if (runSuccess == 0) {
                            System.out.println("You got away safely!");
                        } else if (runSuccess == 1) {
                            System.out.println("You couldn't get away fast enough, the " + randMon + " has attacked!");
                            while (user.getHealth() > 0 && randMon.getHealth() > 0) {
                                System.out.println(user.getHealth());
                                System.out.println(randMon.getHealth());
                                for(int i = 1; i <= user.moveList.length; i++) {
                                    System.out.println(i + ". " + user.moveList[i-1]);
                                }
                                System.out.println("Which move would you like to use?");
                                int moveChoice = input.nextInt();
                                System.out.println("You used " + user.moveList[moveChoice-1] + " !");
                                randMon.deductHealth(user.moveList[moveChoice-1].damage());
                                System.out.println("The " + randMon + " attacked back!");
                                user.deductHealth(randMon.monDamage());
                                System.out.println(user.getHealth());
                                System.out.println(randMon.getHealth());
                            }
                            if (user.getHealth() <= 0) {
                                System.out.println("You lost to the " + randMon + " !");
                                running = false;
                            } else {
                                System.out.println("You defeated the " + randMon + " !");
                            }   
                        }
                    }
                }
            } else if (userChoice == 'S') {
                shop playerShop = new shop();
                System.out.println("What would you like to buy? \n 1. Potions(P) \n 2. Moves(M)");
                char userShopChoice1 = input.next().charAt(0);
                if (userShopChoice1 == 'P') {
                    System.out.println("What kind of potion would you like to buy? \n 1. potion \n 2. super potion \n 3. mega potion \n 4. ultra potion");
                    String potionPurchase = input.next();
                    System.out.println("That will cost you " + playerShop.potionPrice(potionPurchase) + " Would you like to purchase? \n 1. Yes(y) \n 2. No(n)");
                    char userShopChoice2 = input.next().charAt(0);
                    if (userShopChoice2 == 'y') {
                        if (user.getHealth() == 100) {
                            System.out.println("You cannot purchase potions at this time as you have full health");
                        } else if(user.getMoney() < playerShop.potionPrice(potionPurchase)) {
                            System.out.println("You cannot afford the potion you selected. Get a cheaper potion or increase the amount of money in your wallet");
                        } else {
                            potion potionBought = new potion(potionPurchase);
                            user.addHealth(potionBought.healthBoost());
                            user.deductMoney(playerShop.potionPrice(potionPurchase));
                            System.out.println("Purchase Succesful!");
                        }
                    } else {
                        System.out.println("Ok! Cya later!");
                    }
                }
            } else if (userChoice == 'Q') {
                System.out.println("Thanks for playing " + user.getName() + "!");
                running = false;
            }
        }
    }
}
               