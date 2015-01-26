package com.poetaytoe.untitled;

import com.poetaytoe.untitled.character.Player;
import com.poetaytoe.untitled.config.UntitledConfig;
import com.poetaytoe.untitled.init.UntitledGraphics;
import com.poetaytoe.untitled.world.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Untitled{

    public static void main(String[] args) {

        UntitledGraphics ex = new UntitledGraphics();
        ex.setVisible(true);
        UntitledGraphics.ug = ex;

        Map spawnMap = new Map(15, 15, new Color(0, 103, 5));

        new Player(spawnMap, 2, 2, "MainPlayer", new Color(164, 118, 255), 10);

        ex.setMap(spawnMap);
    }

}
