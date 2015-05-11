package com.poetaytoe.untitled.world.locations;

import com.poetaytoe.untitled.character.Character;
import com.poetaytoe.untitled.world.Location;
import com.poetaytoe.untitled.world.Map;

public class WarpSpace extends Location {

    Map targetMap;
    int targetX;
    int targetY;

    public WarpSpace(Map map, int x, int y) {
        this.targetMap = map;
        this.targetX = x;
        this.targetY = y;
        solid = false;
    }

    @Override
    public void onLandOn(Character character) {

        character.warpTo(targetMap, targetX, targetY);

    }
}
