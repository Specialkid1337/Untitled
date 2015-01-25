package com.poetaytoe.untitled.world.locations;

import com.poetaytoe.untitled.world.Location;

import java.awt.*;

public class Ethereal extends Location {

    public Ethereal(Color color) {
        super(color);
        solid = false;
        transparent = false;
    }

    public Ethereal(int r, int g, int b) {
        super(new Color(r, g, b));
    }

}
