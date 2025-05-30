package io.github.some_example_name.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.some_example_name.Controller.CheatMenuController;
import io.github.some_example_name.Controller.HintMenuController;
import io.github.some_example_name.Enums.AbilityConstants;
import io.github.some_example_name.Enums.CheatCodesConstants;
import io.github.some_example_name.Enums.HeroConstants;
import io.github.some_example_name.Enums.KeyBoardPreferences;
import io.github.some_example_name.Main;
import io.github.some_example_name.Model.GameAssetsManager;

public class HintMenuView implements Screen {
    private Stage stage;
    private Label cheatLabel;
    private HintMenuController controller;
    private BitmapFont font;
    private Texture backgroundTexture;
    private Image backgroundImage;
    private Table table;
    private TextButton exitButton;

    public HintMenuView(HintMenuController controller, Skin skin) {
        this.controller = controller;
        this.stage = new Stage();
        this.font = new BitmapFont();
        this.table = new Table();
        this.cheatLabel = new Label("Hint menu", skin);
        this.backgroundTexture = new Texture(Gdx.files.internal("backgrounds/MainMenuBG.png"));
        this.backgroundImage = new Image(backgroundTexture);
        this.controller.setView(this);
        exitButton = new TextButton("back", skin, "no-box");
    }

    @Override
    public void show() {
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        table.setFillParent(true);
        exitButton.setColor(Color.BLACK);
        font.setColor(Color.WHITE);
        cheatLabel.setFontScale(1.9f);
        table.clear();
        table.reset();
        table.center();
        table.add(cheatLabel).padBottom((float) Gdx.graphics.getHeight() / 2 + 100);
        table.row();
        table.add(exitButton).width(600).padTop(302f).height(60);
        stage.addActor(backgroundImage);
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0f, 0.1f, 0.2f, 1f);

        stage.act(delta);
        stage.draw();
        Main.getBatch().begin();
        font.getData().setScale(1.5f);
        font.draw(Main.getBatch(), "Heroes:", 0, Gdx.graphics.getHeight());
        font.draw(Main.getBatch(), "hero's name", 0, Gdx.graphics.getHeight() - 50);
        font.draw(Main.getBatch(), "hero's speed", 200, Gdx.graphics.getHeight() - 50);
        font.draw(Main.getBatch(), "hero's health", 400, Gdx.graphics.getHeight() - 50);
        int i = 1;
        for (HeroConstants value : HeroConstants.values()) {
            font.draw(Main.getBatch(), value.getName(), 0, Gdx.graphics.getHeight() - 50 * (i + 1));
            font.draw(Main.getBatch(), value.getSpeed() + "", 200, Gdx.graphics.getHeight() - 50 * (i + 1));
            font.draw(Main.getBatch(), value.getHealth() + "", 400, Gdx.graphics.getHeight() - 50 * (i + 1));
            i++;
        }
        font.draw(Main.getBatch(), "Game keys:", 0, Gdx.graphics.getHeight() - 400);
        i = 1;
        for (KeyBoardPreferences value : KeyBoardPreferences.values()) {
            font.draw(Main.getBatch(), value.name() + ": " + value.getCharacter(), 0,
                Gdx.graphics.getHeight() - 50 * (i + 1) - 350);
            i++;
        }
        i = 1;
        font.draw(Main.getBatch(), "Abilities:", 200, Gdx.graphics.getHeight() - 400);
        for (AbilityConstants value : AbilityConstants.values()) {
            font.draw(Main.getBatch(), value.getName() + ": " + value.getDescription(), 200,
                Gdx.graphics.getHeight() - 50 * (i + 1) - 350);
            i++;
        }
        i = 1;
        font.draw(Main.getBatch(), "Cheat codes:", 0, Gdx.graphics.getHeight() - 800);
        for (CheatCodesConstants value : CheatCodesConstants.values()) {
            font.draw(Main.getBatch(), value.getName() + ": " + value.getDescription(), 0,
                Gdx.graphics.getHeight() - 800 - 50 * (i + 1));
            i++;
        }
        Main.getBatch().end();
        controller.handleHintMenuButtons();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public TextButton getExitButton() {
        return exitButton;
    }
}
