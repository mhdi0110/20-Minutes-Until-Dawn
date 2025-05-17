package io.github.some_example_name.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class GameAssetsManager {
    private GameAssetsManager gameAssetsManager;
    private static Skin skin;

    public GameAssetsManager getGameAssetsManager() {
        if (gameAssetsManager == null) {
            gameAssetsManager = new GameAssetsManager();
        }
        return gameAssetsManager;
    }

    public static Skin getSkin() {
        if (skin == null) {
            skin = new Skin(Gdx.files.internal("skin/biological-attack-ui.json"));
        }
        return skin;
    }
}
