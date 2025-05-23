package io.github.some_example_name.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import io.github.some_example_name.Main;

public class WorldController {
    private PlayerController playerController;
    private Texture backgroundTexture;
    private float backgroundX = 0;
    private float backgroundY = 0;

    public WorldController(PlayerController playerController) {
        this.backgroundTexture = new Texture("backgrounds/GameBG.png");
        this.playerController = playerController;
    }

    public void update() {
        float bgScreenX = 0 - playerController.getPlayer().getPosX() + (float) Gdx.graphics.getWidth() / 2;
        float bgScreenY = 0 - playerController.getPlayer().getPosY() + (float) Gdx.graphics.getHeight() / 2;
        Main.getBatch().draw(backgroundTexture, bgScreenX, bgScreenY);
    }
}
