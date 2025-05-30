package io.github.some_example_name.Enums;

import com.badlogic.gdx.graphics.Texture;
import io.github.some_example_name.Model.GameAssetsManager;

import java.time.temporal.Temporal;

public enum AbilityConstants {
    VITALITY("vitality", 1, GameAssetsManager.getVitality(), "increases max Hp by 1"),
    DAMAGER("damager", 2, GameAssetsManager.getDamager(), "increases weapon damage by 25% for 10s"),
    PROCREASE("procrease", 3, GameAssetsManager.getProcrease(), "increases weapon projectile by 1"),
    AMOCREASE("amorecase", 4, GameAssetsManager.getAmocrease(), "increases max Ammo by 5"),
    SPEEDY("speedy", 5, GameAssetsManager.getSpeedy(), "increases speed for 10s"),
    ;

    final String name;
    final int number;
    final Texture texture;
    final String description;

    AbilityConstants(String name, int number, Texture texture, String description) {
        this.name = name;
        this.number = number;
        this.texture = texture;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public Texture getTexture() {
        return texture;
    }

    public String getDescription() {
        return description;
    }
}
