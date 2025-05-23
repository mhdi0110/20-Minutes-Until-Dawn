package io.github.some_example_name.Model;

import java.util.ArrayList;

public class Game {
    private final int duration;
    private ArrayList<Enemy> enemies;
    private int timePassed;

    public Game(int duration) {
        this.duration = duration * 60;
        enemies = new ArrayList<>();
        timePassed = 0;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public int getTimePassed() {
        return timePassed;
    }

    public void setTimePassed(int timePassed) {
        this.timePassed = timePassed;
    }

    public int getDuration() {
        return duration;
    }
}
