package io.github.some_example_name.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Bullet {
    private Texture bulletTexture = GameAssetsManager.getBullet();
    private Sprite bulletSprite = new Sprite(bulletTexture);
    private int x;
    private int y;
    private int width;
    private int height;
    private HitBox hitBox;

    public Bullet(int x, int y){
        this.x = x;
        this.y = y;
        this.width = 20;
        this.height = 20;
        hitBox = new HitBox(x, y, width, height);
    }

    public Texture getBulletTexture() {
        return bulletTexture;
    }

    public Sprite getBulletSprite() {
        return bulletSprite;
    }

    public int getX() {
        return x;
    }

    public int getY() {
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
    }
}
