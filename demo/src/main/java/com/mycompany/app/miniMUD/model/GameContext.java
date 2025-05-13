package com.mycompany.app.miniMUD.model;

public class GameContext {
    private Player player;
    private Room currentRoom;

    public GameContext(Player player, Room currentRoom) {
        this.player = player;
        this.currentRoom = currentRoom;
    }

    public Player getPlayer() {
        return player;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
