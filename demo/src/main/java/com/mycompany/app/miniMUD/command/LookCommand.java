package com.mycompany.app.miniMUD.command;

import com.mycompany.app.miniMUD.model.*;

public class LookCommand implements Command {
    @Override
    public String execute(GameContext context) {
        StringBuilder response = new StringBuilder();
        Room currentRoom = context.getCurrentRoom();
        
        response.append("【房間】：").append(currentRoom.getName()).append("\n");
        response.append("【描述】：").append(currentRoom.getDescription()).append("\n");
        
        Monster monster = currentRoom.getMonster();
        if (monster != null && monster.getHp() > 0) {
            response.append("【怪物】：").append(monster.getName())
                   .append("（HP: ").append(monster.getHp()).append("）\n");
        }
        
        response.append("【出口】：");
        currentRoom.getExits().keySet().forEach(direction -> 
            response.append(direction).append(" "));
        response.append("\n");
        
        if (currentRoom.hasPotion()) {
            response.append("【道具】：治療藥水");
        }
        
        return response.toString();
    }
}
