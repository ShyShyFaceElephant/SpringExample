package com.mycompany.app.miniMUD.controller;

import com.mycompany.app.miniMUD.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/game")
public class GameController {

    @Autowired
    private GameService gameService;

    public static class CommandRequest {
        private String command;

        public String getCommand() {
            return command;
        }

        public void setCommand(String command) {
            this.command = command;
        }
    }

    @PostMapping("/command")
    public String handleCommand(@RequestBody CommandRequest request) {
        return gameService.processCommand(request.getCommand());
    }
}
