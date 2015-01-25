package com.poetaytoe.untitled.character;

import com.poetaytoe.untitled.world.Map;

import java.awt.*;

public abstract class HealthyCharacter extends Character {

    protected int health = 0;
    protected int maxHealth = 0;
    protected boolean dead = false;

    public HealthyCharacter(Map map, int x, int y, String name, Color color, int maxHealth) {
        super(map, x, y, name, color);
        this.health = maxHealth;
        this.maxHealth = maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void damage(int damage) {
        health -= damage;
        if (damage <= 0) {
            onDeath();
        }
    }

    public void heal(int heal) {
        health = (health + heal > maxHealth) ? maxHealth : (health += heal);
    }

    public void onDeath() {
        dead = true;
    }
}
