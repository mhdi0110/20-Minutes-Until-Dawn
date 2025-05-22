package io.github.some_example_name.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Bullet {
    private Texture bulletTexture = GameAssetsManager.getBullet();
    private Sprite bulletSprite = new Sprite(bulletTexture);
    private int damage = 5;
    private int x;
    private int y;

    public Bullet(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Texture getBulletTexture() {
        return bulletTexture;
    }

    public Sprite getBulletSprite() {
        return bulletSprite;
    }

    public int getDamage() {
        return damage;
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
        bulletSprite.setSize(20 , 20);
        bulletSprite.setX((float) Gdx.graphics.getWidth() / 2);
        bulletSprite.setY((float) Gdx.graphics.getHeight() / 2);
    }
}
