package io.github.some_example_name.Enums;

public enum HeroConstants {
    SHANA("shana", 4, 4),
    DIAMOND("diamond", 1, 7),
    SCARLET("scarlet", 5, 3),
    LILITH("lilith", 3, 5),
    DASHER("dasher", 10, 2),
    ;
    final String name;
    final int health;
    final int speed;

    HeroConstants(String name, int speed, int health) {
        this.name = name;
        this.health = health;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }
}
