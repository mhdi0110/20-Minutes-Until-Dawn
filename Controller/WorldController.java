package io.github.some_example_name.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import io.github.some_example_name.Main;
import io.github.some_example_name.Model.App;
import io.github.some_example_name.Model.Game;
import io.github.some_example_name.Model.Player;
import io.github.some_example_name.Model.Seed;
import io.github.some_example_name.View.GameView;

import java.util.ArrayList;

public class WorldController {
    private PlayerController playerController;
    private GameView view;
    private Texture backgroundTexture;
    private float backgroundX = 0;
    private float backgroundY = 0;
    private Game game;
    private Player player;

    public WorldController(PlayerController playerController) {
        this.backgroundTexture = new Texture("backgrounds/GameBG.png");
        this.playerController = playerController;
        game = App.getCurrentGame();
        player = playerController.getPlayer();
    }

    public void setView(GameView view) {
        this.view = view;
    }

    public void update() {
        float bgScreenX = 0 - playerController.getPlayer().getPosX() + (float) Gdx.graphics.getWidth() / 2;
        float bgScreenY = 0 - playerController.getPlayer().getPosY() + (float) Gdx.graphics.getHeight() / 2;
        Main.getBatch().draw(backgroundTexture, bgScreenX, bgScreenY);
        ArrayList<Seed> seedToRemove = new ArrayList<>();
        for (Seed seed : game.getSeeds()) {
            seed.updateSpritePosition(player);
            seed.getSprite().draw(Main.getBatch());
            if (seed.getHitBox().collidesWith(player.getHitBox())) {
                seedToRemove.add(seed);
                player.setXp(player.getXp() + seed.getXp());
                if (player.canUpgrade()) {
                    player.setXp(0);
                    player.setLevel(player.getLevel() + 1);
                    view.setGamePaused(true);
                }
            }
        }
        for (Seed seed : seedToRemove) {
            game.getSeeds().remove(seed);
        }
    }
}
