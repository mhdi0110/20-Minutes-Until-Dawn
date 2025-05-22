package io.github.some_example_name.Model;

public class Hero {
    private String name;
    private int speed;
    private int health;

    public Hero(String name, int speed, int health) {
        this.name = name;
        this.speed = speed;
        this.health = health;
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
}
