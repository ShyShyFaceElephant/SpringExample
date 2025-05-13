package com.mycompany.app.miniMUD.service;

import com.mycompany.app.miniMUD.model.*;

public class GameInitializer {
    public static GameContext init() {
        Room forest = new Room("森林入口", "你站在茂密森林的邊緣", new Monster("哥布林", 30, 8), true);
        Room temple = new Room("神殿大廳", "光線從破碎的石窗灑落", new Monster("亡靈戰士", 50, 12), false);
        Room cave = new Room("黑暗洞穴", "陰暗潮濕的洞穴，隱約聽到水滴聲", new Monster("洞穴巨鼠", 20, 5), false);
        Room tower = new Room("高塔頂端", "風聲呼嘯，視野極佳", new Monster("塔樓守衛", 60, 15), false);
        Room garden = new Room("秘密花園", "花香四溢，充滿魔法氣息", new Monster("花園精靈", 40, 10), true);

        forest.setExit("north", temple);
        temple.setExit("south", forest);
        temple.setExit("east", cave);
        cave.setExit("west", temple);
        cave.setExit("north", tower);
        tower.setExit("south", cave);
        tower.setExit("east", garden);
        garden.setExit("west", tower);

        Player player = new Player("勇者", 100, 15);
        return new GameContext(player, forest);
    }
}
