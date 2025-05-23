package io.github.some_example_name.Model;

import java.util.ArrayList;

public class Game {
    private int duration;
    private ArrayList<Enemy> enemies;

    public Game(int duration) {
        this.duration = duration;
        enemies = new ArrayList<>();
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemy(Enemy enemy) {
        enemies.add(enemy);
    }
}
