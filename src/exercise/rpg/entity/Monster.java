package exercise.rpg.entity;

import java.util.Random;

public class Monster {
    private String name;
    private int maxHP;
    private int currentHP;
    private int attackPower;
    private Random random;

    public Monster() {
        this.random = new Random();
        this.name = randomNameMonster();
        this.maxHP = randomHP();
        currentHP = maxHP;
        this.attackPower = randomPower();
    }

    public void attack(Player player) {
        System.out.println(player.getName() + " viene attaccato");
        player.takeDamage(attackPower);
    }

    public void takeDamage(int damage) {
        System.out.println("Il mostro " + name + " ha preso " + damage + " di danno");
        currentHP -= damage;
    }

    public boolean isAlive() {
        return currentHP > 0;
    }


    public void printStatus() {
        if (!isAlive()) {
            System.out.println(name + " è morto");
        } else {
            System.out.println(name + " HP:" + currentHP + "/" + maxHP);
        }
    }


    private String randomNameMonster() {
        String upperCase = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String lowerCase = "qwertyuiopasdfghjklzxcvbnm";

        String name = "";

        Random r = new Random();
        int firstLetter = r.nextInt(0, upperCase.length());
        name += upperCase.charAt(firstLetter);

        for (int i = 0; i < 4; i++) {
            int rLetter = r.nextInt(0, upperCase.length());
            name += lowerCase.charAt(rLetter);
        }
        return name;
    }

    public static Monster generateNewMonster(){
        return new Monster();
    }

    private int randomHP() {
        return random.nextInt(8, 13);
    }

    private int randomPower() {

        return random.nextInt(1, 5);
    }

    @Override
    public String toString() {
        return "Il nome del mostro è: " + name;
    }
}


