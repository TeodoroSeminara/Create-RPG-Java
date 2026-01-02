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


        // Creazione player e monstre
        Player player = new Player(playerName);
        Monster monster = new Monster();

        while (monster.isAlive() && player.isAlive()) {

            System.out.println(player.getName() + " seleziona una mossa:");

            System.out.print("1 per attaccare, 2 per curare: ");
            int moveSelect = input.nextInt();

            if (moveSelect == 1) {
                player.attack(monster);
            } else {
                player.heal();
            }

            if (monster.isAlive()) {
                monster.attack(player);
            }

            player.printStatus();
            monster.printStatus();

            System.out.println();
        }


    }
}
