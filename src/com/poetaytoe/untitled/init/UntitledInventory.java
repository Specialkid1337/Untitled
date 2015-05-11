package com.poetaytoe.untitled.init;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UntitledInventory extends JFrame implements MouseListener {

    public static PlayerInventory inv = new PlayerInventory();

    public UntitledInventory() {

        setTitle("Inventory");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setResizable(false);
        setAutoRequestFocus(true);

        setSize(400, 400);

        addMouseListener(this);

        add(inv);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        inv.click(getMousePosition());
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
