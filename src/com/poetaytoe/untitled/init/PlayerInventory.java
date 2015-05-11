package com.poetaytoe.untitled.init;

import com.poetaytoe.untitled.character.Player;
import com.poetaytoe.untitled.items.IActivatable;
import com.poetaytoe.untitled.items.Item;

import javax.swing.*;
import java.awt.*;

public class PlayerInventory extends JPanel {

    int width = 9;
    int height = 4;
    int[][] inventory = new int[width][height];

    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, 400, 400);

        Player player = Player.player;

        Item[][] inventory = player.getInventory();


        g.setColor(new Color(0, 0, 0));
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                g.drawRect(y * 32, x * 32, 32, 32);
                if (inventory[x][y] != null) {
                    g.drawString(inventory[x][y].getName(),y * 32 + 4, x * 32 + 28);
                }
            }
        }

        g.drawString("Health: " + Player.player.getHealth() + " / " + Player.player.getMaxHealth(), 0, 200);
    }

    public void click(Point point) {
        int x = (int) point.getX() - 3;
        int y = (int) point.getY() - 22;

        int indexX = x / 32;
        int indexY = y / 32;

        if (Player.player.getItem(indexX, indexY) != null) {
            Item item = Player.player.getItem(indexX, indexY);
            if (item instanceof IActivatable) {
                if (!((IActivatable) item).activate(Player.player)) {
                    Player.player.removeItem(item);
                }
            }
        }

        repaint();
    }
}
