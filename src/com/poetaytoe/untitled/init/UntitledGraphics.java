package com.poetaytoe.untitled.init;

import com.poetaytoe.untitled.character.Player;
import com.poetaytoe.untitled.config.UntitledConfig;
import com.poetaytoe.untitled.world.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UntitledGraphics extends JFrame implements KeyListener, MouseListener{

    public static UntitledGraphics ug;
    Map map;

    public UntitledGraphics() {

        setTitle("Untitled");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setAutoRequestFocus(true);

        addMouseListener(this);

        addKeyListener(this);
    }

    public void setMap(Map map){

        if(this.map != null)
            remove(this.map);

        this.map = map;
        add(this.map);

        setSize(map.getMapWidth() * UntitledConfig.MAP_SQUARE_SIZE + 10, (map.getMapHeight() + 1) * UntitledConfig.MAP_SQUARE_SIZE + 10);

        repaint();
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

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
