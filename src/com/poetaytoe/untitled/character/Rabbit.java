package com.poetaytoe.untitled.character;

import com.poetaytoe.untitled.init.PlayerInventory;
import com.poetaytoe.untitled.init.UntitledInventory;
import com.poetaytoe.untitled.interfaces.Ticker;
import com.poetaytoe.untitled.world.Map;

import java.awt.*;
import java.util.Random;

public class Rabbit extends HealthyCharacter implements Ticker {

    public Rabbit(Map map, int x, int y) {
        super(map, x, y, "Rabbit", new Color(200, 200, 200), 5);
    }

    @Override
    public void onTick(Random random) {
        if (random.nextDouble() < 0.1)
            this.moveBy((int) Math.pow(-1, random.nextInt(2)), (int) Math.pow(-1, random.nextInt(2)));
        Character character = this.getMap().characterAtLocation(this.getX(), this.getY() + 1);
        if(character != null && character instanceof HealthyCharacter){
            ((HealthyCharacter) character).damage(30);
        }
        UntitledInventory.inv.repaint();
    }
}
