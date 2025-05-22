package io.github.some_example_name.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.awt.*;

public class Weapon {
    private String name;
    private int damage;
    private int projectile;
    private int reloadTime;
    private int maxAmmo;
    private int ammo;
    private Texture weaponTexture;
    private Sprite weaponSprite;
    private float time = 0;
    private boolean isReloading;
    public Weapon(String name, int damage, int projectile, int reloadTime, int maxAmmo) {
        this.name = name;
        this.damage = damage;
        this.projectile = projectile;
        this.reloadTime = reloadTime;
        this.maxAmmo = maxAmmo;
        this.ammo = maxAmmo;
        this.isReloading = false;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getProjectile() {
        return projectile;
    }

    public int getReloadTime() {
        return reloadTime;
    }

    public int getMaxAmmo() {
        return maxAmmo;
    }

    public void setWeaponTexture(Player player) {
        switch (this.name) {
            case "revolver":
                weaponTexture = GameAssetsManager.getRevolverStill();
                break;
            case "shotgun":
                weaponTexture = GameAssetsManager.getRevolverStill();
                break;
            case "smg":
                weaponTexture = GameAssetsManager.getSmgStill();
                break;
            default:
                weaponTexture = GameAssetsManager.getRevolverStill();
                break;
        }
        weaponSprite = new Sprite(weaponTexture);
        weaponSprite.setPosition(
            (float) Gdx.graphics.getWidth() / 2,
            (float) Gdx.graphics.getHeight() / 2
        );
        weaponSprite.setSize(50, 50);
    }

    public Sprite getWeaponSprite() {
        return weaponSprite;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public boolean isReloading() {
        return isReloading;
    }

    public void setReloading(boolean reloading) {
        isReloading = reloading;
    }

    public Texture getWeaponTexture() {
        return weaponTexture;
    }
}
