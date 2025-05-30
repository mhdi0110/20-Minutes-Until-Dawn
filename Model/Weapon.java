package io.github.some_example_name.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;

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
    private Animation<Texture> reloadAnimation;
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

    public void setWeaponTextureAndAnimation() {
        switch (this.name) {
            case "revolver":
                weaponTexture = GameAssetsManager.getRevolverStill();
                reloadAnimation = GameAssetsManager.getShotgunRevolverReload();
                break;
            case "shotgun":
                weaponTexture = GameAssetsManager.getRevolverStill();
                reloadAnimation = GameAssetsManager.getShotgunRevolverReload();
                break;
            case "smg":
                weaponTexture = GameAssetsManager.getSmgStill();
                reloadAnimation = GameAssetsManager.getSmgReload();
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

    public Animation<Texture> getReloadAnimation() {
        return reloadAnimation;
    }

    public void setProjectile(int projectile) {
        this.projectile = projectile;
    }

    public void setMaxAmmo(int maxAmmo) {
        this.maxAmmo = maxAmmo;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
