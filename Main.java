package io.github.some_example_name;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.some_example_name.Controller.SaveAndLoadData;
import io.github.some_example_name.Controller.SignUpController;
import io.github.some_example_name.Model.GameAssetsManager;
import io.github.some_example_name.View.SignUpMenuView;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Main extends Game {
    private static Main main;
    private static SpriteBatch batch;

    @Override
    public void create() {
        main = this;
        batch = new SpriteBatch();
        main.setScreen(new SignUpMenuView(new SignUpController(), GameAssetsManager.getSkin()));
        Cursor customCursor = Gdx.graphics.newCursor(GameAssetsManager.getPixmap(), 16, 16);
        Gdx.graphics.setCursor(customCursor);
        SaveAndLoadData.loadData();
        SaveAndLoadData.createPlayersWithData();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.4f, 1f);
        batch.begin();
        batch.end();
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    public static Main getMain() {
        return main;
    }

    public static SpriteBatch getBatch() {
        return batch;
    }
}
