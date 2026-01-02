package exercise.rpg;

import exercise.rpg.entity.Monster;
import exercise.rpg.entity.Player;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Ciccio", 10);
        Monster monster = new Monster( 10);


        monster.printStatus();




    }
}
