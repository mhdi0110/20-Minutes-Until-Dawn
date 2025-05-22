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
import io.github.some_example_name.Controller.PreGameMenuController;
import io.github.some_example_name.Main;
import io.github.some_example_name.Model.App;
import io.github.some_example_name.Model.GameAssetsManager;
import io.github.some_example_name.Model.Hero;
import io.github.some_example_name.Model.Weapon;

public class PreGameMenuView implements Screen {
    private Stage stage;
    private Table table;
    private BitmapFont font;
    private Texture backgroundTexture;
    private Image backgroundImage;
    private String errorMessage;
    private PreGameMenuController controller;
    private SelectBox<String> heroSelectBox;
    private SelectBox<String> weaponSelectBox;
    private SelectBox<Integer> durationSelectBox;
    private TextButton playButton;
    public PreGameMenuView(PreGameMenuController controller, Skin skin) {
        this.controller = controller;
        this.backgroundTexture = new Texture(Gdx.files.internal("backgrounds/MainMenuBG.png"));
        this.backgroundImage = new Image(backgroundTexture);
        this.table = new Table();
        this.font = new BitmapFont();
        this.controller.setView(this);
        this.playButton = new TextButton("Play", skin);
        this.heroSelectBox = new SelectBox<>(GameAssetsManager.getSkin());
        this.heroSelectBox.setItems(App.getHeroes());
        this.weaponSelectBox = new SelectBox<>(GameAssetsManager.getSkin());
        this.weaponSelectBox.setItems(App.getWeapons());
        Integer[] durations = new Integer[]{2, 5, 10, 20};
        this.durationSelectBox = new SelectBox<>(GameAssetsManager.getSkin());
        this.durationSelectBox.setItems(durations);
    }

    @Override
    public void show() {
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        this.font.setColor(Color.WHITE);
        heroSelectBox.setColor(Color.BLACK);
        weaponSelectBox.setColor(Color.BLACK);
        playButton.setColor(Color.BLACK);
        durationSelectBox.setColor(Color.BLACK);
        table.setFillParent(true);
        table.center();
        table.add(heroSelectBox).width(600).padBottom(32f).height(60);
        table.row();
        table.add(weaponSelectBox).width(600).padBottom(32f).height(60);
        table.row();
        table.add(durationSelectBox).width(600).padBottom(32f).height(60);
        table.row();
        table.add(playButton).width(600).padBottom(32f).height(60);
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
        font.draw(Main.getBatch(), "Heroes:", 570, 720);
        font.draw(Main.getBatch(), "Weapons:", 540, 625);
        if (errorMessage != null && !errorMessage.isEmpty()) {
            font.draw(Main.getBatch(), errorMessage, 850, Gdx.graphics.getHeight() - 50);
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

    public SelectBox<String> getHeroSelectBox() {
        return heroSelectBox;
    }

    public SelectBox<String> getWeaponSelectBox() {
        return weaponSelectBox;
    }

    public SelectBox<Integer> getDurationSelectBox() {
        return durationSelectBox;
    }

    public TextButton getPlayButton() {
        return playButton;
    }
}
