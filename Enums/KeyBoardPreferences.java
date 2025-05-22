package io.github.some_example_name.Enums;

import com.badlogic.gdx.Input;

public enum KeyBoardPreferences {
    UP(Input.Keys.W),
    LEFT(Input.Keys.A),
    DOWN(Input.Keys.S),
    RIGHT(Input.Keys.D),
    RELOAD(Input.Keys.R),;
    public int value;

    KeyBoardPreferences(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value, KeyBoardPreferences preferences) {
        preferences.value = value;
    }
}
