package exercise.rpg;

import exercise.rpg.entity.Monster;
import exercise.rpg.entity.Player;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Inserisci il tuo nome: ");
        String playerName = input.nextLine();
        boolean gameRunning = true;


        // Creazione player e monster
        Player player = new Player(playerName);
        Monster monster = new Monster();


        while (monster.isAlive() && player.isAlive() && gameRunning) {

            System.out.println(player.getName() + " seleziona una mossa:");

            System.out.print("1 per attaccare, 2 per curare, 3 prova a fuggire :");
            int moveSelect = input.nextInt();

            switch (moveSelect) {
                case 1:
                    player.attack(monster);
                    break;
                case 2:
                    player.heal();
                    break;
                case 3:
                    boolean playerEscape = player.run();
                    if (playerEscape){
                        gameRunning = false;
                    }
                    break;
            }

            if (monster.isAlive() && gameRunning) {
                monster.attack(player);
            }

            player.printStatus();
            monster.printStatus();

            System.out.println();
        }


    }
}
