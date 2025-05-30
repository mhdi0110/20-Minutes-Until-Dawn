package io.github.some_example_name.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.some_example_name.Controller.SettingMenuController;
import io.github.some_example_name.Main;
import io.github.some_example_name.Model.App;
import io.github.some_example_name.Model.GameAssetsManager;

public class SettingMenuView implements Screen {
    private Stage stage;
    private Table table;
    private BitmapFont font;
    private Texture backgroundTexture;
    private Image backgroundImage;
    private String errorMessage;
    private Label SettingTitle;
    private SettingMenuController controller;
    private TextButton onOffButton;
    private TextButton backButton;
    private SelectBox<String> music;
    private Music backgroundMusic;
    private boolean isMusicOn;
    private Slider volumeSlider;
    private Label volumeLabel;
    private TextButton autoReloadButton;

    public SettingMenuView(SettingMenuController controller, Skin skin) {
        this.controller = controller;
        this.backgroundTexture = new Texture(Gdx.files.internal("backgrounds/MainMenuBG.png"));
        this.backgroundImage = new Image(backgroundTexture);
        this.table = new Table();
        this.font = new BitmapFont();
        this.SettingTitle = new Label("20 Minutes Till Dawn", skin);
        this.SettingTitle.setFontScale(0.5f);
        this.controller.setView(this);
        this.onOffButton = new TextButton("On", skin);
        this.backButton = new TextButton("back", skin, "no-box");
        this.music = new SelectBox<>(GameAssetsManager.getSkin());
        String[] musics = {"Goriz", "Walking Dead"};
        this.music.setItems(musics);
        this.isMusicOn = false;
        this.volumeSlider = new Slider(0f, 1f, 0.01f, false, skin);
        this.volumeSlider.setValue(0.5f); // Default to 50% volume
        this.volumeLabel = new Label("Volume: 50%", skin);
        this.autoReloadButton = new TextButton("Auto Reload: on", skin);
    }

    @Override
    public void show() {
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        font.setColor(Color.WHITE);
        music.setColor(Color.BLACK);
        onOffButton.setColor(Color.BLACK);
        autoReloadButton.setColor(Color.BLACK);
        table.setFillParent(true);
        table.center();
        table.add(music).width(600).padBottom(32f).height(60);
        table.row();
        table.add(volumeLabel).padBottom(10f);
        table.row();
        table.add(volumeSlider).width(600).padBottom(32f).height(60);
        table.row();
        table.add(onOffButton).width(600).padBottom(32f).height(60);
        table.row();
        table.add(backButton).width(600).padBottom(32f).height(60);
        table.row();
        table.add(autoReloadButton).width(600).padBottom(32f).height(60);
        table.row();
        stage.addActor(backgroundImage);
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1f, 1f, 1f, 1f);

        stage.act(delta);
        stage.draw();
        Main.getBatch().begin();
        font.getData().setScale(1.7f);
        if (errorMessage != null && !errorMessage.isEmpty()) {
            font.draw(Main.getBatch(), errorMessage, 850, Gdx.graphics.getHeight() - 50);
        }
        volumeLabel.setText("Volume: " + (int) (volumeSlider.getValue() * 100) + "%");
        if (backgroundMusic != null) {
            backgroundMusic.setVolume(volumeSlider.getValue());
        }
        if (onOffButton.isChecked()) {
            if (!isMusicOn) {
                isMusicOn = true;
                onOffButton.setText("Off");
                backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("musics/" + music.getSelected() + ".mp3"));
                font.draw(Main.getBatch(), music.getSelected(), 850, Gdx.graphics.getHeight() - 50);
                backgroundMusic.setLooping(true);
                backgroundMusic.setVolume(0.5f);
                backgroundMusic.play();
            } else {
                isMusicOn = false;
                onOffButton.setText("On");
                if (backgroundMusic != null) backgroundMusic.stop();
            }
            onOffButton.setChecked(false);
        }
        if (autoReloadButton.isChecked()) {
            if (App.isIsAutoReloadOn()) {
                App.setAutoReloadOn(false);
                autoReloadButton.setText("Auto Reload: on");
            } else {
                autoReloadButton.setText("Auto Reload: off");
                App.setAutoReloadOn(true);
            }
            autoReloadButton.setChecked(false);
        }
        Main.getBatch().end();
        controller.handleSignUpButtons();
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

    public TextButton getBackButton() {
        return backButton;
    }
}
