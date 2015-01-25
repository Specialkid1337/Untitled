package com.poetaytoe.untitled;

import com.poetaytoe.untitled.character.Player;
import com.poetaytoe.untitled.config.UntitledConfig;
import com.poetaytoe.untitled.init.UntitledGraphics;
import com.poetaytoe.untitled.world.Location;
import com.poetaytoe.untitled.world.Map;
import com.poetaytoe.untitled.world.locations.Ethereal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Untitled extends JFrame implements KeyListener {

    public Untitled() {

        initUI();
    }

    private void initUI() {

        add(new UntitledGraphics());

        setSize(15 * UntitledConfig.MAP_SQUARE_SIZE + 10, 16 * UntitledConfig.MAP_SQUARE_SIZE + 10);

        setTitle("Untitled");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setAutoRequestFocus(true);

        addKeyListener(this);

        Map spawnMap = new Map(15, 15, new Color(0, 103, 5));

        new Player(spawnMap, 2, 2, "MainPlayer", new Color(164, 118, 255), 10);

        spawnMap.setLocation(5, 5, new Ethereal(100, 50, 200){
          @Override
          public void onLandOn(){
              setSize(500, 500);
          }
        });

        add(spawnMap);

    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Untitled ex = new Untitled();
                ex.setVisible(true);
            }
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char key = e.getKeyChar();
        switch (Character.toLowerCase(key)) {
            case 'w':
                Player.player.moveBy(0, -1);
                break;
            case 'a':
                Player.player.moveBy(-1, 0);
                break;
            case 's':
                Player.player.moveBy(0, 1);
                break;
            case 'd':
                Player.player.moveBy(1, 0);
                break;
            default:
                break;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
