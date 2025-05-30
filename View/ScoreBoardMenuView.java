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
import io.github.some_example_name.Controller.ScoreBoardMenuController;
import io.github.some_example_name.Main;
import io.github.some_example_name.Model.App;
import io.github.some_example_name.Model.GameAssetsManager;

public class ScoreBoardMenuView implements Screen {
    private Stage stage;
    private Table table;
    private BitmapFont font;
    private Texture backgroundTexture;
    private Image backgroundImage;
    private Label gameTitle;
    private ScoreBoardMenuController controller;
    private SelectBox<String> orderBox;

    public ScoreBoardMenuView(ScoreBoardMenuController controller, Skin skin) {
        this.controller = controller;
        this.backgroundTexture = new Texture(Gdx.files.internal("backgrounds/MainMenuBG.png"));
        this.backgroundImage = new Image(backgroundTexture);
        this.table = new Table();
        this.font = new BitmapFont();
        this.gameTitle = new Label("Scoreboard", skin);
        this.gameTitle.setFontScale(0.5f);
        this.controller.setView(this);
        orderBox = new SelectBox<>(GameAssetsManager.getSkin());
        String[] orders = {"Kill", "Score", "Username", "Time Alive"};
        orderBox.setItems(orders);
    }

    @Override
    public void show() {
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        this.gameTitle.setFontScale(1.9f);
        this.font.setColor(Color.WHITE);
        orderBox.setColor(Color.BLACK);
        table.setFillParent(true);
        table.center();
        table.add(gameTitle).padBottom(20f);
        table.row();
        table.add(orderBox).width(600).padBottom(32f).height(80);
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
        font.getData().setScale(1.5f);
        font.draw(Main.getBatch(), "username", 800, 500);
        font.draw(Main.getBatch(), "score", 900, 500);
        font.draw(Main.getBatch(), "kill", 1000, 500);
        font.draw(Main.getBatch(), "time alive", 1100, 500);
        Main.getBatch().end();
        controller.handleScoreBoardMenuButtons();
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

    public SelectBox<String> getOrderBox() {
        return orderBox;
    }
}
