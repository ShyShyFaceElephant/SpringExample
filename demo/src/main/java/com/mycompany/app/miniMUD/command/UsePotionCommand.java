package com.mycompany.app.miniMUD.command;

import com.mycompany.app.miniMUD.model.*;

public class UsePotionCommand implements Command {
    @Override
    public String execute(GameContext context) {
        StringBuilder response = new StringBuilder();
        Room currentRoom = context.getCurrentRoom();
        
        if (!currentRoom.hasPotion()) {
            return "這裡沒有藥水。";
        }

        Player player = context.getPlayer();
        player.heal(30);
        currentRoom.usePotion();
        
        response.append("你喝下治療藥水，回復 30 HP！\n")
                .append("你的 HP：").append(player.getHp());

        return response.toString();
    }
}
