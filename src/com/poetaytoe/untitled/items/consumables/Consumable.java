package com.poetaytoe.untitled.items.consumables;

import com.poetaytoe.untitled.character.Character;
import com.poetaytoe.untitled.items.IActivatable;
import com.poetaytoe.untitled.items.Item;

public abstract class Consumable extends Item implements IActivatable {

    protected int maxUses;
    protected int usesLeft;

    public Consumable(String name) {
        super(name);
    }

    public void add(int add) {
        usesLeft += add;
    }

    @Override
    public boolean activate(Character character) {
        usesLeft--;
        effect(character);
        if (usesLeft == 0) {
            return false;
        }
        return true;
    }

    @Override
    public String getName() {
        return super.getName() + " (" + usesLeft + "/" + maxUses + ")";
    }

    public abstract void effect(Character character);
}
