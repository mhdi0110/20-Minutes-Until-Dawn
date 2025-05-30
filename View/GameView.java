package io.github.some_example_name.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import io.github.some_example_name.Controller.AbilityController;
import io.github.some_example_name.Controller.EndGameMenuController;
import io.github.some_example_name.Controller.GameController;
import io.github.some_example_name.Controller.PauseMenuController;
import io.github.some_example_name.Enums.KeyBoardPreferences;
import io.github.some_example_name.Main;
import io.github.some_example_name.Model.App;
import io.github.some_example_name.Model.Game;
import io.github.some_example_name.Model.GameAssetsManager;
import io.github.some_example_name.Model.Player;

public class GameView implements Screen, InputProcessor {
    private Stage stage;
    private GameController controller;
    private Player player;
    private Game game;
    private boolean isGamePaused;
    private AbilityController abilityController;
    private Window abilityWindow;
    private BitmapFont font;
    public GameView(GameController controller, Skin skin, Game game) {
        this.controller = controller;
        controller.setView(this);
        player = App.getCurrentPlayer();
        this.game = game;
        isGamePaused = false;
        abilityController = new AbilityController();
        abilityWindow = null;
        font = new BitmapFont();
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        Main.getBatch().begin();
        ScreenUtils.clear(0, 0, 0, 1);
        if (Gdx.input.isKeyPressed(KeyBoardPreferences.PAUSE.getValue())) {
            Main.getBatch().end();
            Main.getMain().setScreen(new PauseMenuView(new PauseMenuController(), GameAssetsManager.getSkin()));
            return;
        }
        if (game.getTimePassed() >= game.getDuration()) {
            player.setHasWon(true);
            Main.getBatch().end();
            Main.getMain().setScreen(new EndGameMenuView(new EndGameMenuController(), GameAssetsManager.getSkin()));
            return;
        }
        if (player.getHero().getHealth() <= 0) {
            player.setHasWon(false);
            Main.getBatch().end();
            Main.getMain().setScreen(new EndGameMenuView(new EndGameMenuController(), GameAssetsManager.getSkin()));
            return;
        }
        if (!isGamePaused) {
            if (abilityWindow != null) {
                abilityWindow.remove();
                abilityWindow = null;
            }
            controller.updateGame(delta, abilityController);
            player.setInvincibleTime(Math.max(0, player.getInvincibleTime() - delta));
            game.setTimePassed(game.getTimePassed() + Gdx.graphics.getDeltaTime());
            font.getData().setScale(2f);
            font.draw(Main.getBatch(), "Time left: " + game.getMinutesLeft() + ":" + game.getSecondsLeft(),
                280, Gdx.graphics.getHeight() - 15);
            font.draw(Main.getBatch(), "Kills: " + player.getKills(), 1480, Gdx.graphics.getHeight() - 15 );
            font.draw(Main.getBatch(), "Level: " + player.getLevel(), 1780, Gdx.graphics.getHeight() - 15 );
            ShapeRenderer shapeRenderer = new ShapeRenderer();
            float width = 800;
            float height = 20;
            float xpFraction = (float) player.getXp() / player.getXpForNextLevel();

            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(Color.GRAY);
            shapeRenderer.rect(560, Gdx.graphics.getHeight() - 30, width, height);
            shapeRenderer.setColor(Color.RED);
            shapeRenderer.rect(560, Gdx.graphics.getHeight() - 30, width * xpFraction, height);
            shapeRenderer.end();
        } else {
            if (abilityWindow == null) {
                Gdx.input.setInputProcessor(stage);
                abilityWindow = new Window("Select your ability", GameAssetsManager.getSkin());
                abilityWindow.setColor(Color.WHITE);
                abilityWindow.setSize(800, 800);
                abilityWindow.setPosition(
                    (Gdx.graphics.getWidth() - abilityWindow.getWidth()) / 2,
                    (Gdx.graphics.getHeight() - abilityWindow.getHeight()) / 2
                );
                abilityController.setView(this);
                abilityController.showRandomAbility(abilityWindow);
                stage.addActor(abilityWindow);
            }
        }
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
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

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        controller.getWeaponController().handleWeaponShoot(screenX, screenY);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        controller.getWeaponController().handleWeaponRotation(screenX, screenY);
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

    public void setGamePaused(boolean gamePaused) {
        isGamePaused = gamePaused;
    }

    public Stage getStage() {
        return stage;
    }
}
