package com.poetaytoe.untitled.character;

import com.poetaytoe.untitled.world.Map;

import java.awt.*;

public class Player extends HealthyCharacter {

    public static Player player;

    public Player(Map map, int x, int y, String name, Color color, int maxHealth) {
        super(map, x, y, name, color, maxHealth);
        player = this;
    }

}
