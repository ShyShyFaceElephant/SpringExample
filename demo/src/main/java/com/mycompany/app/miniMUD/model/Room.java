package com.mycompany.app.miniMUD.model;

import java.util.HashMap;
import java.util.Map;

public class Room {
    private String name;
    private String description;
    private Monster monster;
    private boolean hasPotion;
    private Map<String, Room> exits;

    public Room(String name, String description, Monster monster, boolean hasPotion) {
        this.name = name;
        this.description = description;
        this.monster = monster;
        this.hasPotion = hasPotion;
        this.exits = new HashMap<>();
    }

    public void setExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public Map<String, Room> getExits() {
        return exits;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Monster getMonster() {
        return monster;
    }

    public boolean hasPotion() {
        return hasPotion;
    }

    public void usePotion() {
        this.hasPotion = false;
    }
}
