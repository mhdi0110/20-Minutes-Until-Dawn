package io.github.some_example_name.Model;

public class Hero {
    private String name;
    private int speed;
    private int health;
    private int maxHealth;

    public Hero(String name, int speed, int health) {
        this.name = name;
        this.speed = speed;
        this.health = health;
        this.maxHealth = health;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}
