package com.mycompany.app.miniMUD.command;

import com.mycompany.app.miniMUD.model.*;

public class AttackCommand implements Command {
    @Override
    public String execute(GameContext context) {
        StringBuilder response = new StringBuilder();
        Room currentRoom = context.getCurrentRoom();
        Monster target = currentRoom.getMonster();
        
        if (target == null || target.getHp() <= 0) {
            return "這裡沒有可以攻擊的目標。";
        }

        Player player = context.getPlayer();
        int damage = player.getAttackPower();
        target.takeDamage(damage);
        player.addDamage(damage);

        response.append("你對 ").append(target.getName())
                .append(" 造成了 ").append(damage).append(" 傷害！\n");

        if (target.getHp() <= 0) {
            response.append(target.getName()).append(" 被擊倒！\n");
            player.incrementKillCount();
        } else {
            int counterDamage = target.getAttackPower();
            player.takeDamage(counterDamage);
            response.append(target.getName()).append(" 反擊你，造成 ")
                   .append(counterDamage).append(" 傷害！\n");
        }

        response.append("\n=== 狀態更新 ===\n")
                .append("你的 HP：").append(player.getHp()).append("\n")
                .append(target.getName()).append(" HP：").append(target.getHp()).append("\n")
                .append("總傷害：").append(player.getTotalDamage())
                .append("，擊殺數：").append(player.getKillCount());

        return response.toString();
    }
}
