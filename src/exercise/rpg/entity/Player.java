package exercise.rpg.entity;

public class Player {
    private String name;
    private int maxHP;
    private int currentHP;
    private int attackPower;

    public Player(String name, int maxHP) {
        this.name = name;
        this.maxHP = maxHP;
        currentHP = maxHP;
        attackPower = 1;
    }

    public void attack(Monster monster) {
        System.out.println("Hai attaccato il mostro");
        monster.takeDamage(attackPower);
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
}
