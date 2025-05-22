package io.github.some_example_name.Enums;

public enum WeaponConstants {
    REVOLVER("revolver", 1, 20, 1, 6),
    SHOTGUN("shotgun", 4, 10, 1, 2),
    SMG("smg", 1, 8, 2, 24),
    ;
    final String name;
    final int damage;
    final int projectile;
    final int reloadTime;
    final int maxAmmo;

    WeaponConstants(String name, int projectile, int damage, int reloadTime, int maxAmmo) {
        this.name = name;
        this.damage = damage;
        this.projectile = projectile;
        this.reloadTime = reloadTime;
        this.maxAmmo = maxAmmo;
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

}
