package exercise.rpg.entity;

import java.util.Random;

public class Player {
    private Random random;
    private String name;
    private int maxHP;
    private int currentHP;
    private int attackPower;

    public Player(String name) {
        this.random = new Random();
        this.name = name;
        this.maxHP = randomHP();
        currentHP = maxHP;
        this.attackPower = randomPower();
    }

    public void attack(Monster monster) {
        System.out.println("Hai attaccato il mostro");
        int criticalChance = random.nextInt(0, 5);

        if (criticalChance == 2) {
            monster.takeDamage(attackPower * 2);
            System.out.println("Critical Hit");
        } else {
            monster.takeDamage(attackPower);
        }

    }

    public void takeDamage(int damage) {
        System.out.println(name + " ha preso " + damage + " di danno");
        currentHP -= damage;
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
            System.out.println(name + " HP:" + currentHP + "/" + maxHP);
        }
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

}
