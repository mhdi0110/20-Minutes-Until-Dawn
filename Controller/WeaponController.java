package io.github.some_example_name.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import io.github.some_example_name.Enums.KeyBoardPreferences;
import io.github.some_example_name.Main;
import io.github.some_example_name.Model.Bullet;
import io.github.some_example_name.Model.GameAssetsManager;
import io.github.some_example_name.Model.Weapon;

import java.util.ArrayList;

public class WeaponController {
    Weapon weapon;
    private ArrayList<Bullet> bullets = new ArrayList<>();

    public WeaponController(Weapon weapon) {
        this.weapon = weapon;
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
            Bullet bullet = new Bullet(screenX, screenY);
            bullet.setBulletTexture(weapon);
            bullets.add(bullet);
            weapon.setAmmo(weapon.getAmmo() - 1);
        }
    }


    public void update() {
        weapon.getWeaponSprite().draw(Main.getBatch());
        updateBullets();
        if (Gdx.input.isKeyPressed(KeyBoardPreferences.RELOAD.getValue())) {
            weapon.setReloading(true);
        }
        if (weapon.isReloading()) {
            reloadAnimation();
        }
    }

    public void updateBullets() {
        for (Bullet b : bullets) {
            b.getBulletSprite().draw(Main.getBatch());
            Vector2 direction = new Vector2(
                Gdx.graphics.getWidth() / 2f - b.getX(),
                Gdx.graphics.getHeight() / 2f - b.getY()
            ).nor();

            b.getBulletSprite().setX(b.getBulletSprite().getX() - direction.x * 5);
            b.getBulletSprite().setY(b.getBulletSprite().getY() + direction.y * 5);
        }
    }

    public void reloadAnimation() {
        Animation<Texture> animation = GameAssetsManager.getSmgReload();
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
