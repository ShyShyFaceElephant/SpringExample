package com.mycompany.app.miniMUD.command;

import com.mycompany.app.miniMUD.model.GameContext;

public class ExitCommand implements Command {
    @Override
    public String execute(GameContext context) {
        return "👋 感謝遊玩！再會，勇者！";
    }
}
