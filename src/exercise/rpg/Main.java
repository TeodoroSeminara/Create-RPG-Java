package exercise.rpg;

import exercise.rpg.entity.Monster;
import exercise.rpg.entity.Player;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Inserisci il tuo nome: ");
        String playerName = input.nextLine();
        boolean gameRunning = true;
//        int monsterCounter = 0;


        // Creazione player e monster
        Player player = new Player(playerName);
        Monster monster = new Monster();
//        Monster monster = null;
//        Monster[] monsterList = Monster.generateMonsterList();
//        System.out.println(Arrays.toString(monsterList));


        while (player.isAlive() && gameRunning) {

//            if (monster == null) {
//                monster = monsterList[monsterCounter];
//            }

            System.out.println(player.getName() + " seleziona una mossa:");

            System.out.print("1 per attaccare, 2 per curare, 3 prova a fuggire :");
            int moveSelect = input.nextInt();

            switch (moveSelect) {
                case 1:
                    System.out.print("1 Attacco leggero, " +
                            "2 Attacco pesante " +
                            "3 Torna indietro : ");
                    moveSelect = input.nextInt();
                    switch (moveSelect) {
                        case 1:
                            player.lightAttack(monster);
                            break;
                        case 2:
                            player.heavyAttack(monster);
                            break;
                        case 3:
                            continue;
                    }
                    break;
                case 2:
                    player.heal();
                    break;
                case 3:
                    boolean playerEscape = player.run();
                    if (playerEscape) {
                        gameRunning = false;
                    }
                    break;
            }

            if (monster.isAlive() && gameRunning) {
                monster.lightAttack(player);
            } else if (!monster.isAlive()) {
                System.out.println("Hai ucciso il mostro");
                System.out.println("Attenzione è spawnato un nuovo avversario");
                monster = Monster.generateNewMonster();
//                monsterCounter++;
//                monster = null;
            }

            if (!player.isAlive()) {
                System.out.println("GAME OVAHR");
            }

            player.printStatus();
            monster.printStatus();

//            if (monster != null){
//                monster.printStatus();
//            }

            System.out.println();
        }


    }
}
