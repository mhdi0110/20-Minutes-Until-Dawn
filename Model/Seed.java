package io.github.some_example_name.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import io.github.some_example_name.Controller.EnemyController;

public class Seed {
    Enemy enemy;
    private Texture texture;
    private Sprite sprite;
    private float x, y;
    private float width, height;
    private HitBox hitBox;
    private int xp;
    public Seed(Enemy enemy, float x, float y, float width, float height, Texture texture) {
        this.enemy = enemy;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.texture = texture;
        xp = 3;
        sprite = new Sprite(texture);
        sprite.setPosition(x, y);
        sprite.setSize(width, height);
        hitBox = new HitBox(x, y, width, height);
    }

    public void updateSpritePosition(Player player) {
        float newX = x - player.getPosX() + (float) (Gdx.graphics.getWidth() / 2);
        float newY = y - player.getPosY() + (float) (Gdx.graphics.getHeight() / 2);
        sprite.setPosition(newX, newY);
    }

    public HitBox getHitBox() {
        return hitBox;
    }

    public int getXp() {
        return xp;
    }

    public Sprite getSprite() {
        return sprite;
    }
}
