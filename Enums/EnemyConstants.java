package io.github.some_example_name.Enums;

public enum EnemyConstants {
    TREE(10),
    TENTACLE_MONSTER(25),
    EYEBAT(50);

    final int health;

    public int getHealth() {
        return health;
    }

    EnemyConstants(int value) {
        this.health = value;
    }
}
