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
import io.github.some_example_name.Controller.EndGameMenuController;
import io.github.some_example_name.Controller.PauseMenuController;
import io.github.some_example_name.Controller.SaveAndLoadData;
import io.github.some_example_name.Main;
import io.github.some_example_name.Model.Ability;
import io.github.some_example_name.Model.App;
import io.github.some_example_name.Model.Player;

public class EndGameMenuView implements Screen {
    private Stage stage;
    private Table table;
    private BitmapFont font;
    private Texture backgroundTexture;
    private Image backgroundImage;
    private String errorMessage;
    private EndGameMenuController controller;
    private Label winLoseLabel;
    private TextButton goToMainMenuButton;
    private Player player;

    public EndGameMenuView(EndGameMenuController controller, Skin skin) {
        this.controller = controller;
        this.backgroundTexture = new Texture(Gdx.files.internal("backgrounds/GameBG.png"));
        this.backgroundImage = new Image(backgroundTexture);
        this.table = new Table();
        this.font = new BitmapFont();
        this.controller.setView(this);
        this.winLoseLabel = new Label("", skin);
        winLoseLabel.setFontScale(2f);
        this.goToMainMenuButton = new TextButton("Go back to main menu", skin);
        player = App.getCurrentPlayer();
        player.setTimeAlive((int) App.getCurrentGame().getTimePassed());
        SaveAndLoadData.saveData(player);
    }

    @Override
    public void show() {
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        this.font.setColor(Color.WHITE);
        table.setFillParent(true);
        if (player.HasWon()) {
            winLoseLabel.setText("You won!");
            winLoseLabel.setColor(Color.GREEN);
        } else {
            winLoseLabel.setText("You lost!");
            winLoseLabel.setColor(Color.RED);
        }
        goToMainMenuButton.setColor(Color.BLACK);
        table.center();
        table.add(winLoseLabel);
        table.row();
        table.add(goToMainMenuButton).width(600).padBottom(32f).height(80);

        stage.addActor(backgroundImage);
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1f, 1f, 1f, 1f);

        stage.act(delta);
        stage.draw();
        Main.getBatch().begin();
        font.getData().setScale(1.5f);
        font.draw(Main.getBatch(), "UserName: " + player.getUsername(), 900, 500);
        font.draw(Main.getBatch(), "Time Alive: " + (int) App.getCurrentGame().getTimePassed() + " s",
            900, 470);
        font.draw(Main.getBatch(), "KILLS: " + player.getKills(), 900, 440);
        font.draw(Main.getBatch(), "Score: " + player.getScore(), 900, 410);
        controller.handleEndGameMenuButtons();
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

    public TextButton getGoToMainMenuButton() {
        return goToMainMenuButton;
    }
}
