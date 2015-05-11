package com.poetaytoe.untitled.init;

import com.poetaytoe.untitled.interfaces.Ticker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class TickRegister implements ActionListener {
    private static ArrayList<Ticker> tickers = new ArrayList<Ticker>();
    private static long time = 0;

    public static void tick() {

        time++;

        Random random = new Random();

        for (int i = 0; i < tickers.size(); i++) {
            tickers.get(i).onTick(random);
        }
    }

    public void init() {
        Timer timer = new Timer(1000 / 10, this);
        timer.start();
    }

    public long getTime(){
        return time;
    }

    public static void register(Ticker object) {
        tickers.add(object);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tick();
        UntitledGraphics.ug.repaint();
    }
}
