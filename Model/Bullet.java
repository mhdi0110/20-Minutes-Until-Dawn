package io.github.some_example_name.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Bullet {
    private Texture bulletTexture = GameAssetsManager.getBullet();
    private Sprite bulletSprite = new Sprite(bulletTexture);
    private float x;
    private float y;
    private int width;
    private int height;
    private HitBox hitBox;
    private float dx;
    private float dy;
    private float speed = 500;
    public Bullet(float x, float y, float dx, float dy) {
        this.x = x;
        this.y = y;
        this.width = 20;
        this.height = 20;
        this.dx = dx;
        this.dy = dy;
        hitBox = new HitBox(x, y, width, height);
    }
    public void update(float deltaTime) {
        x += dx * speed * deltaTime;
        y += dy * speed * deltaTime;
        hitBox.move(x, y);
    }
    public float getScreenX(Player player) {
        return x - player.getPosX() + (float) Gdx.graphics.getWidth() / 2;
    }
    public float getScreenY(Player player) {
        return y - player.getPosY() + (float) Gdx.graphics.getHeight() / 2;
    }
    public Texture getBulletTexture() {
        return bulletTexture;
    }

    public Sprite getBulletSprite() {
        return bulletSprite;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
    public void setBulletTexture(Weapon weapon) {
        switch (weapon.getName()) {//TODO
            case "revolver":
                break;
            case "shotgun":
                break;
            case "smg":
                break;
            default:
               break;
        }
        bulletSprite = new Sprite(bulletTexture);
        bulletSprite.setSize(width , height);
        bulletSprite.setX((float) Gdx.graphics.getWidth() / 2);
        bulletSprite.setY((float) Gdx.graphics.getHeight() / 2);
    }

    public HitBox getHitBox() {
        return hitBox;
    }
    public void reduceEnemyHealth(int damage, Enemy enemy) {
        enemy.setHealth(enemy.getHealth() - damage);
        if(enemy.getHealth() <= 0) {
            App.getCurrentGame().getEnemies().remove(enemy);
        }
    }
}
