package com.poetaytoe.untitled.world;

import com.poetaytoe.untitled.character.Character;
import com.poetaytoe.untitled.config.UntitledConfig;
import com.poetaytoe.untitled.world.locations.Air;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Map extends JPanel {

    protected Location[][] locations;
    protected Color bgColor;
    protected ArrayList<Character> characters = new ArrayList<Character>();

    public Map(int w, int h, Color bgColor) {
        this.locations = new Location[w][h];
        this.bgColor = bgColor;
        clear();
    }

    public Map(int w, int h, int r, int g, int b) {
        this.locations = new Location[w][h];
        this.bgColor = new Color(r, g, b);
        clear();
    }

    public Color getBgColor() {
        return bgColor;
    }

    public Location[][] getLocations() {
        return locations;
    }

    public void clear() {
        for (int x = 0; x < locations.length; x++) {
            for (int y = 0; y < locations[x].length; y++) {
                locations[x][y] = new Air();
            }
        }
    }

    public void setLocation(int x, int y, Location loc) {
        locations[x][y] = loc;
    }

    public Location getLocation(int x, int y) {
        return locations[x][y];
    }

    public int getMapWidth(){
        return locations.length;
    }

    public int getMapHeight(){
        return locations[0].length; //assuming non-rectangle map
    }

    public boolean isValid(int x, int y) {
        if (x >= 0 && y >= 0 && y < locations.length && x < locations[0].length) {
            return true;
        }
        return false;
    }

    public boolean isOpen(int x, int y) {
        if (isValid(x, y) && !locations[x][y].isSolid()) {
            return true;
        }
        return false;
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public void removeCharacter(Character character) {
        characters.remove(character);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        int mapSize = (int) UntitledConfig.MAP_SQUARE_SIZE;

        g.setColor(bgColor);

        g.fillRect(0, 0, locations.length * mapSize, locations[0].length * mapSize);

        for (int x = 0; x < locations.length; x++) {
            for (int y = 0; y < locations[x].length; y++) {
                if (!locations[x][y].isTransparent()) {
                    g.setColor(locations[x][y].getColor());
                    g.fillRect(x * mapSize, y * mapSize, mapSize, mapSize);
                }
            }
        }

        for (int i = 0; i < characters.size(); i++) {
            g.setColor(characters.get(i).getColor());
            g.fillRect(characters.get(i).getX() * mapSize, characters.get(i).getY() * mapSize, mapSize, mapSize);
        }
    }

}
