package com.poetaytoe.untitled.character;

import com.poetaytoe.untitled.world.Map;

import java.awt.*;

public abstract class Character {

    protected String name = "no-name";
    protected Map map;
    protected int x;
    protected int y;
    protected Color color;

    public Character(Map map, int x, int y, String name, Color color) {
        this.map = map;
        map.addCharacter(this);
        this.x = x;
        this.y = y;
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(int r, int g, int b) {
        color = new Color(r, g, b);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Map getMap() {
        return map;
    }

    //X units right and Y units down
    public boolean moveBy(int x, int y) {
        int tempX = this.x + x;
        int tempY = this.y + y;

        if (map.isOpen(tempX, tempY)) {
            warpTo(map, tempX, tempY);
            return true;
        }
        return false;
    }

    public boolean warpTo(Map map, int x, int y) {
        if (map.isOpen(x, y)) {
            map.getLocation(x,y).onLandOn();
            this.map = map;
            this.x = x;
            this.y = y;
            map.repaint();
            return true;
        }
        return false;
    }
}
