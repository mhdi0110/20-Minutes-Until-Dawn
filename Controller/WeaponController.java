package io.github.some_example_name.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import io.github.some_example_name.Enums.KeyBoardPreferences;
import io.github.some_example_name.Main;
import io.github.some_example_name.Model.*;

import java.util.ArrayList;
import java.util.Iterator;

public class WeaponController {
    private Weapon weapon;
    private ArrayList<Bullet> bullets = new ArrayList<>();
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private Player player;

    public WeaponController(Weapon weapon) {
        this.weapon = weapon;
        enemies = App.getCurrentGame().getEnemies();
        player = App.getCurrentPlayer();
    }

    public void handleWeaponRotation(int screenX, int screenY) {
        Sprite weaponSprite = weapon.getWeaponSprite();

        float weaponCenterX = (float) Gdx.graphics.getWidth() / 2;
        float weaponCenterY = (float) Gdx.graphics.getHeight() / 2;

        float angle = (float) Math.atan2(screenY - weaponCenterY, screenX - weaponCenterX);

        weaponSprite.setRotation((float) (3.14 - angle * MathUtils.radiansToDegrees));
    }

    public void handleWeaponShoot(int screenX, int screenY) {
        if (weapon.getAmmo() > 0) {
            for (int i = 0; i < weapon.getProjectile(); i++) {
                float playerX = player.getPosX();
                float playerY = player.getPosY();
                float mouseX = Gdx.input.getX();
                float mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
                float aimWorldX = playerX + (mouseX - (float) Gdx.graphics.getWidth() / 2);
                float aimWorldY = playerY + (mouseY - (float) Gdx.graphics.getHeight() / 2);
                float dirX = aimWorldX - playerX + 80 * i;
                float dirY = aimWorldY - playerY + 80 * i;
                float length = (float) Math.sqrt(dirX * dirX + dirY * dirY);
                dirX /= length;
                dirY /= length;
                Bullet bullet = new Bullet(playerX, playerY, dirX, dirY);
                bullet.setBulletTexture();
                bullets.add(bullet);
            }
            weapon.setAmmo(weapon.getAmmo() - 1);
        } else if(App.isIsAutoReloadOn()) {
            weapon.setReloading(true);
        }
    }


    public void update(float delta) {
        weapon.getWeaponSprite().draw(Main.getBatch());
        updateBullets(delta, player);
        if (Gdx.input.isKeyPressed(KeyBoardPreferences.RELOAD.getValue())) {
            weapon.setReloading(true);
        }
        if (weapon.isReloading()) {
            reloadAnimation();
        }
    }

    public void updateBullets(float deltaTime, Player player) {
        Iterator<Bullet> iter = bullets.iterator();
        while (iter.hasNext()) {
            Bullet bullet = iter.next();
            bullet.update(deltaTime);
            bullet.getBulletSprite().setPosition(bullet.getScreenX(player), bullet.getScreenY(player));
            bullet.getBulletSprite().draw(Main.getBatch());
            for (Enemy enemy : enemies) {
                if (bullet.getHitBox().collidesWith(enemy.getHitBox())) {
                    bullet.reduceEnemyHealth(weapon.getDamage(), enemy);
                    iter.remove();
                    break;
                }
            }
        }
    }

    public void reloadAnimation() {
        Animation<Texture> animation = weapon.getReloadAnimation();
        weapon.getWeaponSprite().setRegion(animation.getKeyFrame(weapon.getTime(), true));

        if (!animation.isAnimationFinished(weapon.getTime())) {
            weapon.setTime((weapon.getTime() + Gdx.graphics.getDeltaTime()));
        } else {
            weapon.setTime(0);
            weapon.setReloading(false);
            weapon.setAmmo(weapon.getMaxAmmo());
            weapon.getWeaponSprite().setRegion(weapon.getWeaponTexture());
        }
    }
}
//
//    public void updateBullets() {
//        for (Bullet bullet : bullets) {
//            bullet.getBulletSprite().draw(Main.getBatch());
//            Vector2 direction = new Vector2(
//                Gdx.graphics.getWidth() / 2f - bullet.getX(),
//                Gdx.graphics.getHeight() / 2f - bullet.getY()
//            ).nor();
//
//
//            bullet.getBulletSprite().setX(bullet.getBulletSprite().getX() - direction.x * 5);
//            bullet.getBulletSprite().setY(bullet.getBulletSprite().getY() + direction.y * 5);
//            bullet.getHitBox().move(bullet.getBulletSprite().getX(), bullet.getBulletSprite().getY());
//            for (Enemy enemy : enemies) {
//                if (bullet.getHitBox().collidesWith(enemy.getHitBox())) {
//                    bullet.reduceEnemyHealth(weapon.getDamage(), enemy);
//                }
//            }
//        }
//    }
