package com.poetaytoe.untitled.world.locations;

import com.poetaytoe.untitled.world.Location;

import java.awt.*;

public class Block extends Location {

    public Block(Color color) {
        super(color);
        solid = true;
        transparent = false;
    }

    public Block(int r, int g, int b) {
        super(new Color(r, g, b));
    }

}
