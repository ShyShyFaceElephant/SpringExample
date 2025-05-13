package com.mycompany.app.miniMUD.command;

import com.mycompany.app.miniMUD.model.GameContext;

public interface Command {
    String execute(GameContext context);
}
