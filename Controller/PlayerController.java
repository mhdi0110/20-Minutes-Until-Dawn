package io.github.some_example_name.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import io.github.some_example_name.Enums.KeyBoardPreferences;
import io.github.some_example_name.Main;
import io.github.some_example_name.Model.GameAssetsManager;
import io.github.some_example_name.Model.Player;

public class PlayerController {
    private Player player;

    public PlayerController(Player player) {
        this.player = player;
    }

    public void update() {
        player.getPlayerSprite().draw(Main.getBatch());

//        if(player.isPlayerIdle()){
        idleAnimation();
//        }

        handlePlayerInput();
    }


    public void handlePlayerInput() {
        if (Gdx.input.isKeyPressed(KeyBoardPreferences.UP.getValue())) {
            player.setPosY(player.getPosY() - player.getSpeed());
        }
        if (Gdx.input.isKeyPressed(KeyBoardPreferences.LEFT.getValue())) {
            player.setPosX(player.getPosX() + player.getSpeed());
            player.getPlayerSprite().flip(true, false);
        }
        if (Gdx.input.isKeyPressed(KeyBoardPreferences.DOWN.getValue())) {
            player.setPosY(player.getPosY() + player.getSpeed());
        }
        if (Gdx.input.isKeyPressed(KeyBoardPreferences.RIGHT.getValue())) {
            player.setPosX(player.getPosX() - player.getSpeed());
        }
    }


    public void idleAnimation() {
        Animation<Texture> animation = player.getPlayerAnimation();

        player.getPlayerSprite().setRegion(animation.getKeyFrame(player.getTime(), true));

        if (!animation.isAnimationFinished(player.getTime())) {
            player.setTime((player.getTime() + Gdx.graphics.getDeltaTime()));
        } else {
            player.setTime(0);
        }

        animation.setPlayMode(Animation.PlayMode.LOOP);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
