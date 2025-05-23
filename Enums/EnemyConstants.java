package io.github.some_example_name.Enums;

public enum EnemyConstants {
    TREE(20, "tree", 100, 100),
    TENTACLE_MONSTER(25, "tentacle_monster", 80, 80),
    EYEBAT(50, "eyeBat", 80, 80),
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

    EnemyConstants(int value, String name, int width, int height) {
        this.health = value;
        this.name = name;
        this.width = width;
        this.height = height;
    }
}
