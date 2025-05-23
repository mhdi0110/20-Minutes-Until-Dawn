package io.github.some_example_name.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import io.github.some_example_name.Main;

public class Enemy {
    private float x, y;
    private float speed = 2;
    private String name;
    private Animation<Texture> enemyAnimation;
    private Texture enemyTexture;
    private Sprite enemySprite;
    private float time = 0;
    private HitBox hitBox;
    private int width;
    private int height;
    private int damage = 1;
    private int health;

    public Enemy(float x, float y, String name, int width, int height, int health) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.width = width;
        this.height = height;
        this.health = health;
        hitBox = new HitBox(x, y, width, height);
        setAnimation();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void moveTowards(float targetX, float targetY) {
        if (this.name.equals("tree")) {
            return;
        }
        float dx = targetX - x;
        float dy = targetY - y;
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        if (distance > 0) {
            x += (dx / distance) * speed;
            y += (dy / distance) * speed;
        }
    }

    public Animation<Texture> getEnemyAnimation() {
        return enemyAnimation;
    }

    public void setAnimation() {
        Player player = App.getCurrentPlayer();
        switch (this.name) {
            case "tree":
                this.enemyAnimation = GameAssetsManager.getTreeAnimation();
                this.enemyTexture = GameAssetsManager.getTree0();
                this.enemySprite = new Sprite(enemyTexture);
//                this.enemySprite.setPosition(x - player.getPosX(), y - player.getPosY());
                this.enemySprite.setSize(width, height);
                break;
            case "tentacle_monster":
                break;
            case "eyeBat":
                break;
            default:
                break;
        }
    }

    public void updateSpritePosition(Player player) {
        if (name.equals("tree")) {
            enemySprite.setPosition(
                x - player.getPosX() + (float) (Gdx.graphics.getWidth() / 2),
                y - player.getPosY() + (float) (Gdx.graphics.getHeight() / 2)
            );
        } else {
            enemySprite.setPosition(x - player.getPosX(), y - player.getPosY());
        }
    }

    public Sprite getEnemySprite() {
        return enemySprite;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public Texture getEnemyTexture() {
        return enemyTexture;
    }

    public HitBox getHitBox() {
        return hitBox;
    }
    public void reducePlayerHealth(Player player) {
        if(player.getInvincibleTime() == 0) {
            player.getHero().setHealth(player.getHero().getHealth() - damage);
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
