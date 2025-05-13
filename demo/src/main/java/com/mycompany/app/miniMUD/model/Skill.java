package com.mycompany.app.miniMUD.model;

public interface Skill {
    String getName();
    int use(Player player, Monster target);
}
