package com.mycompany.app.miniMUD.model;

public class FireballSkill implements Skill {
    @Override
    public String getName() {
        return "火球術";
    }

    @Override
    public int use(Player player, Monster target) {
        return 40; // 火球術固定傷害
    }
}
