package io.github.some_example_name.Enums;

public enum EnemyConstants {
    TREE(10, "tree"),
    TENTACLE_MONSTER(25, "tentacle_monster"),
    EYEBAT(50, "eyeBat"),
    ;

    final int health;
    final String name;

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    EnemyConstants(int value, String name) {
        this.health = value;
        this.name = name;
    }
}
