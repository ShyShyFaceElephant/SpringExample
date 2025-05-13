package com.mycompany.app.miniMUD.command;

import com.mycompany.app.miniMUD.model.*;

public class SkillCommand implements Command {
    private final String skillName;

    public SkillCommand(String skillName) {
        this.skillName = skillName;
    }

    @Override
    public String execute(GameContext context) {
        StringBuilder response = new StringBuilder();
        Player player = context.getPlayer();
        Monster target = context.getCurrentRoom().getMonster();

        if (!player.hasSkill(skillName)) {
            return "你沒有這個技能！";
        }
        if (target == null || target.getHp() <= 0) {
            return "這裡沒有可以攻擊的目標。";
        }

        Skill skill = player.getSkill(skillName);
        int damage = skill.use(player, target);
        target.takeDamage(damage);
        player.addDamage(damage);

        response.append("🔥 你施放了【").append(skill.getName()).append("】！\n")
                .append("對 ").append(target.getName())
                .append(" 造成 ").append(damage).append(" 傷害！\n");

        if (target.getHp() <= 0) {
            response.append(target.getName()).append(" 被你燒成灰燼了！\n");
            player.incrementKillCount();
        } else {
            response.append(target.getName()).append(" 還活著！\n\n");
            int counterDamage = target.getAttackPower();
            player.takeDamage(counterDamage);
            response.append(target.getName()).append(" 反擊你，造成 ")
                   .append(counterDamage).append(" 傷害！");
        }

        return response.toString();
    }
}
