package exercise.rpg.entity;

import java.util.Random;

public class Player {
    private Random random;
    private String name;
    private int maxHP;
    private int currentHP;
    private int attackPower;
    private int defenceArmor;

    public Player(String name) {
        this.random = new Random();
        this.name = name;
        this.maxHP = randomHP();
        currentHP = maxHP;
        this.attackPower = randomPower();
        this.defenceArmor = randomDefence();
    }

    public void lightAttack(Monster monster) {
        System.out.println("Usi attacco leggero sul mostro");
        int criticalChance = random.nextInt(0, 5);

        if (criticalChance == 2) {
            monster.takeDamage(attackPower * 2);
            System.out.println("Critical Hit");
        } else {
            monster.takeDamage(attackPower);
        }
    }

    public void heavyAttack(Monster monster) {
        System.out.println("Usi attacco pesante sul mostro");
        int probabilyAttacckSuccess = random.nextInt(0, 2);

        if (probabilyAttacckSuccess == 1) {
            monster.takeDamage(attackPower * 2);
        } else {
            System.out.println("Non sei riuscito a sferrare il colpo");
        }
    }

    public void takeDamage(int damage) {
        int attackDefence = damage - this.defenceArmor;
        if (attackDefence < 0) {
            System.out.println("Non hai inflitto danni");
        } else {
            currentHP -= attackDefence;
        }
        System.out.println(name + " ha preso " + attackDefence + " di danno");
    }

    public boolean isAlive() {
        return currentHP > 0;
    }

    public void heal() {
        System.out.println(name + " usa HEAL");

        if (currentHP == maxHP) {
            System.out.println("Impossibile curarsi sei già totalmente guarito");
        } else if ((currentHP + 5) > maxHP) {
            System.out.println("Ti sei completamente curato");
            currentHP += (maxHP - currentHP);
        } else {
            System.out.println(" Ti sei curato di 5 HP");
            currentHP += 5;
        }
    }

    public void printStatus() {

        if (!isAlive()) {
            System.out.println(name + " è morto");
        } else {
            System.out.println(name + " HP:" + currentHP + "/" + maxHP + "(Attacco: " + attackPower + " Difesa: " + defenceArmor);
        }
    }

    public boolean run() {
        int run = random.nextInt(0, 2);
        boolean gameStop = false;
        if (run == 1) {
            System.out.println("Sei riuscito a fuggire");
            gameStop = true;
        } else {
            System.out.println("Non sei riuscito a scappare, il mostro attacca");
        }
        return gameStop;
    }

    public String getName() {
        return name;
    }

    private int randomHP() {
        return random.nextInt(8, 13);
    }

    private int randomPower() {
        return random.nextInt(1, 5);
    }

    private int randomDefence() {
        return random.nextInt(1, 5);
    }

}
