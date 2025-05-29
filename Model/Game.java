package io.github.some_example_name.Model;

import java.util.ArrayList;

public class Game {
    private final float duration;
    private ArrayList<Enemy> enemies;
    private ArrayList<Seed> seeds;
    private float timePassed;

    public Game(float duration) {
        this.duration = duration * 60;
        enemies = new ArrayList<>();
        seeds = new ArrayList<>();
        timePassed = 0;
    }

    public ArrayList<Seed> getSeeds() {
        return seeds;
    }

    public void setSeed(Seed seed) {
        this.seeds.add(seed);
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public float getTimePassed() {
        return timePassed;
    }

    public void setTimePassed(float timePassed) {
        this.timePassed = timePassed;
    }

    public float getDuration() {
        return duration;
    }
}
