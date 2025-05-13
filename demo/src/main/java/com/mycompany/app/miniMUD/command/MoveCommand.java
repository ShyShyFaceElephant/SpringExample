package com.mycompany.app.miniMUD.command;

import com.mycompany.app.miniMUD.model.*;

public class MoveCommand implements Command {
    private final String direction;

    public MoveCommand(String direction) {
        this.direction = direction;
    }

    @Override
    public String execute(GameContext context) {
        StringBuilder response = new StringBuilder();
        Room currentRoom = context.getCurrentRoom();
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            return "那個方向沒有出口。";
        }

        context.setCurrentRoom(nextRoom);
        response.append("你移動到了：").append(nextRoom.getName()).append("\n");

        Monster monster = nextRoom.getMonster();
        if (monster != null && monster.getHp() > 0) {
            response.append("你看到：").append(monster.getName())
                   .append("（HP: ").append(monster.getHp()).append("）\n");
        }

        response.append("可用方向：");
        nextRoom.getExits().forEach((dir, room) -> 
            response.append(dir).append(" "));

        return response.toString();
    }
}
