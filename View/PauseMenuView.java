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
import io.github.some_example_name.Controller.MainMenuController;
import io.github.some_example_name.Controller.PauseMenuController;
import io.github.some_example_name.Enums.CheatCodesConstants;
import io.github.some_example_name.Main;
import io.github.some_example_name.Model.Ability;
import io.github.some_example_name.Model.App;

public class PauseMenuView implements Screen {
    private Stage stage;
    private Table table;
    private BitmapFont font;
    private Texture backgroundTexture;
    private Image backgroundImage;
    private String errorMessage;
    private TextButton resumeButton;
    private TextButton giveUpButton;
    private PauseMenuController controller;

    public PauseMenuView(PauseMenuController controller, Skin skin) {
        this.controller = controller;
        this.backgroundTexture = new Texture(Gdx.files.internal("backgrounds/GameBG.png"));
        this.backgroundImage = new Image(backgroundTexture);
        this.table = new Table();
        this.font = new BitmapFont();
        this.controller.setView(this);
        this.resumeButton = new TextButton("Resume", skin);
        this.giveUpButton = new TextButton("GiveUp", skin);
    }

    @Override
    public void show() {
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        this.font.setColor(Color.WHITE);
        resumeButton.setColor(Color.BLACK);
        giveUpButton.setColor(Color.BLACK);
        table.setFillParent(true);
        table.center();
        table.add(resumeButton).width(600).padBottom(32f).height(80);
        table.row();
        table.add(giveUpButton).width(600).padBottom(32f).height(80);
        stage.addActor(backgroundImage);
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1f, 1f, 1f, 1f);

        stage.act(delta);
        stage.draw();
        Main.getBatch().begin();
        font.getData().setScale(2f);
        int i = 1;
        font.draw(Main.getBatch(), "abilities: ", 0, Gdx.graphics.getHeight());
        for (Ability ability : App.getCurrentPlayer().getAbilities()) {
            font.draw(Main.getBatch(), i + "-" + ability.getName(), 0, Gdx.graphics.getHeight() - 40 * i);
            i++;
        }
        i = 1;
        font.draw(Main.getBatch(), "cheat codes: ", 0, Gdx.graphics.getHeight() - 400);
        for (CheatCodesConstants value : CheatCodesConstants.values()) {
            font.draw(Main.getBatch(), i + "-" + value.getName(), 0, Gdx.graphics.getHeight() - 40 * i - 400);
            i++;
        }
        font.getData().setScale(1.7f);
        if (errorMessage != null && !errorMessage.isEmpty()) {
            font.draw(Main.getBatch(), errorMessage, 850, Gdx.graphics.getHeight() - 50);
        }
        controller.handlePauseMenuButtons();
        Main.getBatch().end();
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

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public TextButton getResumeButton() {
        return resumeButton;
    }

    public TextButton getGiveUpButton() {
        return giveUpButton;
    }
}
