package io.github.some_example_name.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.some_example_name.Controller.CheatMenuController;
import io.github.some_example_name.Controller.LoginMenuController;
import io.github.some_example_name.Enums.CheatCodesConstants;
import io.github.some_example_name.Main;
import io.github.some_example_name.Model.GameAssetsManager;

public class CheatMenuView implements Screen {
    private Stage stage;
    private Label cheatLabel;
    private CheatMenuController controller;
    private BitmapFont font;
    private Texture backgroundTexture;
    private Image backgroundImage;
    private Table table;
    private SelectBox<String> cheatCodeBox;
    private TextButton selectButton;
    private TextButton exitButton;
    public CheatMenuView(CheatMenuController controller, Skin skin) {
        this.controller = controller;
        this.stage = new Stage();
        this.font = new BitmapFont();
        this.table = new Table();
        this.cheatLabel = new Label("Select a cheat code", skin);
        this.exitButton = new TextButton("Exit", skin);
        this.backgroundTexture = new Texture(Gdx.files.internal("backgrounds/GameBG.png"));
        this.backgroundImage = new Image(backgroundTexture);
        this.controller.setView(this);
        String[] cheats = {CheatCodesConstants.TIME_EATER.getName(),
            CheatCodesConstants.LEVEL_BOOSTER.getName(),
            CheatCodesConstants.HEART_DAHANDE.getName(),
            CheatCodesConstants.KERM_DASHTAN.getName(),
            CheatCodesConstants.HESOYAM.getName()};
        cheatCodeBox = new SelectBox<>(GameAssetsManager.getSkin());
        cheatCodeBox.setItems(cheats);
        selectButton = new TextButton("Select", skin);
    }

    @Override
    public void show() {
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        table.setFillParent(true);
        cheatCodeBox.setColor(Color.BLACK);
        cheatLabel.setFontScale(1.9f);
        table.clear();
        table.reset();
        table.center();
        table.add(cheatLabel);
        table.row();
        table.add(cheatCodeBox).width(600).padBottom(32f).height(60);
        table.row();
        table.add(selectButton).width(600).padBottom(32f).height(60);
        table.row();
        table.add(exitButton).width(600).padBottom(32f).height(60);

        stage.addActor(backgroundImage);
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0f, 0.1f, 0.2f, 1f);

        stage.act(delta);
        stage.draw();
        Main.getBatch().begin();
        Main.getBatch().end();
        controller.handleCheatMenuButtons();
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

    public SelectBox<String> getCheatCodeBox() {
        return cheatCodeBox;
    }

    public TextButton getSelectButton() {
        return selectButton;
    }

    public TextButton getExitButton() {
        return exitButton;
    }
}
