package com.mycompany.app.miniMUD.model;

public class Monster {
    private String name;
    private int hp;
    private int attackPower;

    public Monster(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
    }

    public int getAttackPower() {
        return attackPower;
    }
}
