package com.poetaytoe.untitled.world;

import com.poetaytoe.untitled.character.Character;

import java.awt.*;

public abstract class Location {

    protected Color color = new Color(255, 0, 255);
    protected boolean solid = true;
    protected boolean transparent = false;

    public Location() {
    }

    public Location setColor(Color color) {
        this.color = color;
        return this;
    }

    public Location setColor(int r, int g, int b) {
        this.color = new Color(r, g, b);
        return this;
    }

    public boolean isSolid() {
        return solid;
    }

    public Color getColor() {
        return color;
    }

    public boolean isTransparent() {
        return transparent;
    }

    //When the block is landed on
    public void onLandOn(Character character) {

    }

}
