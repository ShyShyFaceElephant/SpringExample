package com.mycompany.app.miniMUD.command;

public class CommandParser {
    public static Command parse(String input) {
        if (input == null || input.trim().isEmpty()) {
            return null;
        }

        String[] parts = input.toLowerCase().split("\\s+");
        String action = parts[0];

        switch (action) {
            case "look":
                return new LookCommand();
            case "attack":
                return new AttackCommand();
            case "skill":
                if (parts.length < 2) {
                    return null;
                }
                return new SkillCommand(parts[1]);
            case "use":
                if (parts.length < 2 && parts[1].equals("potion")) {
                    return null;
                }
                return new UsePotionCommand();
            case "move":
                if (parts.length < 2) {
                    return null;
                }
                return new MoveCommand(parts[1]);
            case "exit":
                return new ExitCommand();
            default:
                return null;
        }
    }
}
