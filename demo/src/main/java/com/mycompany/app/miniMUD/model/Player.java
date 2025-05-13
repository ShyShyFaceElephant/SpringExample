package com.mycompany.app.miniMUD.model;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private String name;
    private int hp;
    private int maxHp;
    private int attackPower;
    private int totalDamage;
    private int killCount;
    private Map<String, Skill> skills;

    public Player(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.attackPower = attackPower;
        this.totalDamage = 0;
        this.killCount = 0;
        this.skills = new HashMap<>();
        this.skills.put("fireball", new FireballSkill());
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

    public void heal(int amount) {
        this.hp = Math.min(maxHp, hp + amount);
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void addDamage(int damage) {
        this.totalDamage += damage;
    }

    public void incrementKillCount() {
        this.killCount++;
    }

    public int getTotalDamage() {
        return totalDamage;
    }

    public int getKillCount() {
        return killCount;
    }

    public Skill getSkill(String skillName) {
        return skills.get(skillName.toLowerCase());
    }

    public boolean hasSkill(String skillName) {
        return skills.containsKey(skillName.toLowerCase());
    }
}
