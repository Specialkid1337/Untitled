package com.poetaytoe.untitled.character;

import com.poetaytoe.untitled.Untitled;
import com.poetaytoe.untitled.init.PlayerInventory;
import com.poetaytoe.untitled.init.UntitledGraphics;
import com.poetaytoe.untitled.items.Item;
import com.poetaytoe.untitled.world.Map;

import java.awt.*;

public class Player extends HealthyCharacter {

    public static Player player;
    private Item[][] inventory;

    public Player(Map map, int x, int y, String name, Color color, int maxHealth) {
        super(map, x, y, name, color, maxHealth);
        player = this;
        inventory = new Item[4][9];
    }

    public Item[][] getInventory() {
        return inventory;
    }

    @Override
    public boolean warpTo(Map map, int x, int y) {
        if (map.isOpen(x, y)) {
            if (map == this.map) {
                this.x = x;
                this.y = y;
                map.getLocation(x, y).onLandOn(this);
                map.repaint();
                return true;
            } else {
                this.map.removeCharacter(this);
                map.addCharacter(this);
                this.x = x;
                this.y = y;
                this.map = map;
                UntitledGraphics.ug.setMap(map);
                map.getLocation(x, y).onLandOn(this);
                map.repaint();
                return true;
            }
        }
        return false;
    }

    public Item getItem(int indexX, int indexY) {
        if (indexX >= 0 && indexY >= 0 && indexX < inventory.length && indexY < inventory[0].length) {
            return inventory[indexX][indexY];
        }
        return null;
    }

    public boolean addItem(Item item) {
        for (int x = 0; x < inventory.length; x++) {
            for (int y = 0; y < inventory[x].length; y++) {
                if (inventory[x][y] == null) {
                    inventory[x][y] = item;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void onDeath(){
        super.onDeath();
        UntitledGraphics.ug.dispose();
    }

    public void removeItem(Item item) {
        for (int x = 0; x < inventory.length; x++) {
            for (int y = 0; y < inventory[x].length; y++) {
                if (inventory[x][y] == item) {
                    inventory[x][y] = null;
                }
            }
        }
    }
}
