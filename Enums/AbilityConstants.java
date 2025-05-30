package io.github.some_example_name.Enums;

import com.badlogic.gdx.graphics.Texture;
import io.github.some_example_name.Model.GameAssetsManager;

import java.time.temporal.Temporal;

public enum AbilityConstants {
    VITALITY("vitality", 1, GameAssetsManager.getVitality()),
    DAMAGER("damager", 2, GameAssetsManager.getDamager()),
    PROCREASE("procrease", 3, GameAssetsManager.getProcrease()),
    AMOCREASE("amorecase", 4, GameAssetsManager.getAmocrease()),
    SPEEDY("speedy", 5, GameAssetsManager.getSpeedy()),
    ;

    final String name;
    final int number;
    final Texture texture;

    AbilityConstants(String name, int number, Texture texture) {
        this.name = name;
        this.number = number;
        this.texture = texture;
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
}
