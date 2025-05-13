package com.mycompany.app.miniMUD.service;

import com.mycompany.app.miniMUD.command.Command;
import com.mycompany.app.miniMUD.command.CommandParser;
import com.mycompany.app.miniMUD.model.GameContext;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private final GameContext gameContext;

    public GameService() {
        this.gameContext = GameInitializer.init();
    }

    public String processCommand(String commandString) {
        Command command = CommandParser.parse(commandString);
        if (command == null) {
            return "未知的指令：" + commandString;
        }
        return command.execute(gameContext);
    }
}
