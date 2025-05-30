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
import io.github.some_example_name.Main;
import io.github.some_example_name.Model.App;

public class MainMenuView implements Screen {
    private Stage stage;
    private Table table;
    private TextButton loadGameButton;
    private TextButton profileButton;
    private TextButton preGameButton;
    private TextButton scoreBoardButton;
    private TextButton hintButton;
    private TextButton settingButton;
    private TextButton logOutButton;
    private BitmapFont font;
    private Texture backgroundTexture;
    private Image backgroundImage;
    private String errorMessage;
    private Label gameTitle;
    private Image avatar;
    private MainMenuController controller;

    public MainMenuView(MainMenuController controller, Skin skin) {
        this.controller = controller;
        this.backgroundTexture = new Texture(Gdx.files.internal("backgrounds/MainMenuBG.png"));
        this.backgroundImage = new Image(backgroundTexture);
        this.table = new Table();
        this.loadGameButton = new TextButton("Load game", skin);
        this.settingButton = new TextButton("Settings", skin);
        this.profileButton = new TextButton("Profile", skin);
        this.preGameButton = new TextButton("Pregame", skin);
        this.scoreBoardButton = new TextButton("Score Board", skin);
        this.hintButton = new TextButton("Hint", skin);
        this.logOutButton = new TextButton("Logout", skin);
        this.font = new BitmapFont();
        this.gameTitle = new Label("20 Minutes Till Dawn", skin);
        this.gameTitle.setFontScale(0.5f);
        this.controller.setView(this);
        this.avatar = App.getCurrentPlayer().getAvatarImage();
    }

    @Override
    public void show() {
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        this.gameTitle.setFontScale(1.9f);
        this.loadGameButton.setColor(Color.BLACK);
        this.settingButton.setColor(Color.BLACK);
        this.profileButton.setColor(Color.BLACK);
        this.preGameButton.setColor(Color.BLACK);
        this.scoreBoardButton.setColor(Color.BLACK);
        this.hintButton.setColor(Color.BLACK);
        this.logOutButton.setColor(Color.BLACK);
        this.font.setColor(Color.WHITE);

        table.setFillParent(true);
        table.center();
        table.add(gameTitle).padBottom(20f);
        table.row();
        table.add(loadGameButton).width(600).padBottom(32f).height(80);
        table.row();
        table.add(profileButton).width(600).padBottom(32f).height(80);
        table.row();
        table.add(preGameButton).width(600).padBottom(32f).height(80);
        table.row();
        table.add(scoreBoardButton).width(600).padBottom(32f).height(80);
        table.row();
        table.add(hintButton).width(600).padBottom(32f).height(80);
        table.row();
        table.add(settingButton).width(600).padBottom(32f).height(80);
        table.row();
        table.add(logOutButton).width(600).padBottom(32f).height(80);
        table.row();
        stage.addActor(backgroundImage);
        if (App.getCurrentPlayer().getAvatarImage() != null) {
            App.getCurrentPlayer().getAvatarImage().setScale(0.5f);
            stage.addActor(App.getCurrentPlayer().getAvatarImage());
        }
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1f, 1f, 1f, 1f);

        stage.act(delta);
        stage.draw();
        Main.getBatch().begin();
        font.getData().setScale(2.2f);
        font.draw(Main.getBatch(), "username: " + App.getCurrentPlayer().getUsername(), 5, 1180);
        font.draw(Main.getBatch(), "score: " + App.getCurrentPlayer().getScore(), 5, 1145);
        font.getData().setScale(1.7f);
        if (errorMessage != null && !errorMessage.isEmpty()) {
            font.draw(Main.getBatch(), errorMessage, 850, Gdx.graphics.getHeight() - 50);
        }
        Main.getBatch().end();
        controller.handleMainMenuButtons();
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


    public TextButton getProfileButton() {
        return profileButton;
    }

    public TextButton getPreGameButton() {
        return preGameButton;
    }

    public TextButton getScoreBoardButton() {
        return scoreBoardButton;
    }

    public TextButton getHintButton() {
        return hintButton;
    }

    public TextButton getSettingButton() {
        return settingButton;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public TextButton getLogOutButton() {
        return logOutButton;
    }
}
