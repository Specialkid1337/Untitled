package com.poetaytoe.untitled;

import com.poetaytoe.untitled.character.Player;
import com.poetaytoe.untitled.character.Rabbit;
import com.poetaytoe.untitled.init.TickRegister;
import com.poetaytoe.untitled.init.UntitledGraphics;
import com.poetaytoe.untitled.init.UntitledInventory;
import com.poetaytoe.untitled.items.consumables.HealthPotion;
import com.poetaytoe.untitled.world.Map;
import com.poetaytoe.untitled.world.locations.WarpSpace;
import java.awt.*;

public class Untitled {

    public static void main(String[] args) {

        Map spawnMap = new Map(15, 15, new Color(0, 103, 5));
        spawnMap.addBorder(new Color(108, 58,0));

        Player player = new Player(spawnMap, 2, 2, "MainPlayer", new Color(128, 102, 17), 100);
        player.damage(30);
        player.addItem(new HealthPotion("HP", 5, 6, 5));

        Map map2 = new Map(20, 5, new Color(190, 184, 33));
        map2.addBorder(new Color(108, 58,0));

        TickRegister.register(new Rabbit(spawnMap, 5, 7));

        spawnMap.setLocation(14, 7, new WarpSpace(map2, 1, 2).setColor(0, 20, 200));
        map2.setLocation(0, 2, new WarpSpace(spawnMap, 13, 7).setColor(0, 20, 200));

        UntitledGraphics ex = new UntitledGraphics();
        UntitledInventory ui = new UntitledInventory();
        ex.setLocation(200, 200);
        ui.setLocation(20 * 15 + 250, 200);
        ex.setVisible(true);
        ui.setVisible(true);
        UntitledGraphics.ug = ex;

        ex.setMap(spawnMap);

        TickRegister tr = new TickRegister();
        tr.init();
    }

}
