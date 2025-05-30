package io.github.some_example_name.Enums;

import com.badlogic.gdx.Input;

public enum KeyBoardPreferences {
    UP(Input.Keys.W, "w"),
    LEFT(Input.Keys.A, "a"),
    DOWN(Input.Keys.S, "s"),
    RIGHT(Input.Keys.D, "d"),
    RELOAD(Input.Keys.R, "r"),
    PAUSE(Input.Keys.P, "p"),
    CHEAT(Input.Keys.C, "c"),
    ;
    public int value;
    public String character;

    KeyBoardPreferences(int value, String character) {
        this.value = value;
        this.character = character;
    }

    public int getValue() {
        return value;
    }

    public String getCharacter() {
        return character;
    }

    public void setValue(int value, KeyBoardPreferences preferences) {
        preferences.value = value;
    }
}
