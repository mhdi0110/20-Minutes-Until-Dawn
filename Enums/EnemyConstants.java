package io.github.some_example_name.Enums;

public enum EnemyConstants {
    TREE(20, "tree"),
    TENTACLE_MONSTER(25, "tentacle_monster"),
    EYEBAT(50, "eyeBat"),
    ;

    final int health;
    final String name;
    final int width;
    final int height;

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    EnemyConstants(int value, String name) {
        this.health = value;
        this.name = name;
        this.width = 100;
        this.height = 100;
    }
}
