package io.github.some_example_name.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Ability {
    private final String name;
    private final Texture texture;
    private final Sprite sprite;

    public Ability(String name, Texture texture) {
        this.name = name;
        this.texture = texture;
        this.sprite = new Sprite(texture);
    }

    public String getName() {
        return name;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public Texture getTexture() {
        return texture;
    }

    public void applyAbility() {
        Player player = App.getCurrentPlayer();
        switch (name) {
            case "vitality":
                player.getHero().setMaxHealth(player.getHero().getMaxHealth() + 1);
                break;
            case "damager":
                player.getWeapon().setDamage((int) (player.getWeapon().getDamage()
                    + player.getWeapon().getDamage() * 0.25));
                break;
            case "procrease":
                player.getWeapon().setProjectile(player.getWeapon().getProjectile() + 1);
                break;
            case "amocrease":
                player.getWeapon().setMaxAmmo(player.getWeapon().getMaxAmmo() + 1);
                break;
            case "speedy":
                player.getHero().setSpeed(player.getHero().getSpeed() * 2);
                break;
        }
    }
}
