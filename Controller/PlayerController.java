package io.github.some_example_name.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
        heartAnimation();
        handlePlayerInput();
    }


    public void handlePlayerInput() {
        if (Gdx.input.isKeyPressed(KeyBoardPreferences.UP.getValue())) {
            player.setPosY(player.getPosY() + player.getSpeed());
            player.getHitBox().move(player.getPosX(), player.getPosY());
        }
        if (Gdx.input.isKeyPressed(KeyBoardPreferences.LEFT.getValue())) {
            player.setPosX(player.getPosX() - player.getSpeed());
            player.getPlayerSprite().flip(true, false);
            player.getHitBox().move(player.getPosX(), player.getPosY());
        }
        if (Gdx.input.isKeyPressed(KeyBoardPreferences.DOWN.getValue())) {
            player.setPosY(player.getPosY() - player.getSpeed());
            player.getHitBox().move(player.getPosX(), player.getPosY());
        }
        if (Gdx.input.isKeyPressed(KeyBoardPreferences.RIGHT.getValue())) {
            player.setPosX(player.getPosX() + player.getSpeed());
            player.getHitBox().move(player.getPosX(), player.getPosY());
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

    public void heartAnimation() {
        int health = player.getHero().getHealth();
        for(int i = 0; i < player.getHero().getMaxHealth(); i++) {
            if(i < health) {
                Texture heartTexture = GameAssetsManager.getHeart0();
                Sprite heartSprite = new Sprite(heartTexture);
                heartSprite.setSize(heartTexture.getWidth() * 2, heartTexture.getHeight() * 2);
                heartSprite.setPosition(45 * i, 1140);
                Animation<Texture> animation = GameAssetsManager.getHeartAnimation();
                heartSprite.setRegion(animation.getKeyFrame(player.getHeartTime(), true));
                if (!animation.isAnimationFinished(player.getHeartTime())) {
                    player.setHeartTime((player.getHeartTime() + Gdx.graphics.getDeltaTime()));
                } else {
                    player.setHeartTime(0);
                }

                animation.setPlayMode(Animation.PlayMode.LOOP);
                heartSprite.draw(Main.getBatch());
            } else {
                Texture heartTexture = GameAssetsManager.getHeart3();
                Sprite heartSprite = new Sprite(heartTexture);
                heartSprite.setSize(heartTexture.getWidth() * 2, heartTexture.getHeight() * 2);
                heartSprite.setPosition(45 * i, 1140);
                heartSprite.draw(Main.getBatch());
            }
        }
    }
}
