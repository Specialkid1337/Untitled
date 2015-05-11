package com.poetaytoe.untitled.items.consumables;

import com.poetaytoe.untitled.character.Character;
import com.poetaytoe.untitled.character.HealthyCharacter;

public class HealthPotion extends Consumable {

    private int strength;

    public HealthPotion(String name, int uses, int maxUses, int strength) {
        super(name);
        this.usesLeft = uses;
        this.maxUses = maxUses;
        this.strength = strength;
    }

    @Override
    public void effect(Character character) {
        HealthyCharacter hcharacter = (HealthyCharacter) character;
        hcharacter.heal(strength);
    }
}
