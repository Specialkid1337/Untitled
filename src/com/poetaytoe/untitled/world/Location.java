package com.poetaytoe.untitled.world;

import java.awt.*;

public abstract class Location {

    protected Color color;
    protected boolean solid;
    protected boolean transparent;

    public Location() {
    }

    public Location(Color color) {
        this.color = color;
    }

    public Location(int r, int g, int b) {
        this.color = new Color(r, g, b);
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
    public void onLandOn(){

    }

}
