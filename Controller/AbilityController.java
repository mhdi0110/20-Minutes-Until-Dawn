package io.github.some_example_name.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import io.github.some_example_name.Enums.AbilityConstants;
import io.github.some_example_name.Model.Ability;
import io.github.some_example_name.Model.App;
import io.github.some_example_name.Model.Player;
import io.github.some_example_name.View.GameView;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class AbilityController {
    private Image[] abilityImages;
    private Image selectedAbility;
    private GameView view;
    private Player player;
    private float damagerDuration;
    private float speedyDuration;

    public AbilityController() {
        abilityImages = new Image[5];
        abilityImages[0] = new Image(AbilityConstants.VITALITY.getTexture());
        abilityImages[1] = new Image(AbilityConstants.DAMAGER.getTexture());
        abilityImages[2] = new Image(AbilityConstants.PROCREASE.getTexture());
        abilityImages[3] = new Image(AbilityConstants.AMOCREASE.getTexture());
        abilityImages[4] = new Image(AbilityConstants.SPEEDY.getTexture());
        player = App.getCurrentPlayer();
        damagerDuration = 0;
        speedyDuration = 0;
    }

    public void setView(GameView view) {
        this.view = view;
    }

    public void update() {
        if (speedyDuration > 0) {
            speedyDuration -= Gdx.graphics.getDeltaTime();
            if(speedyDuration <= 0) {
                speedyDuration = 0;
                player.getHero().setSpeed(player.getHero().getSpeed() / 2);
            }
        }
        if (damagerDuration > 0) {
            damagerDuration -= Gdx.graphics.getDeltaTime();
            if(damagerDuration <= 0) {
                damagerDuration = 0;
                player.getWeapon().setDamage((int) (player.getWeapon().getDamage() -
                    0.25 * player.getWeapon().getDamage()));
            }
        }
    }

    public void showRandomAbility(Window window) {
        window.clear(); // Clear previous content

        int[] random = new int[3];
        for (int i = 0; i < 3; i++) {
            random[i] = GenerateRandomNumber.generateRandomNumber(1, 5);
            if (i >= 1) {
                while (random[i] == random[i - 1]) {
                    random[i] = GenerateRandomNumber.generateRandomNumber(1, 5);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            final Image img = abilityImages[random[i] - 1];
            img.clearListeners();
            img.setColor(Color.WHITE);

            img.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    for (int j = 0; j < 3; j++) {
                        abilityImages[random[j] - 1].setColor(Color.WHITE);
                    }
                    img.setColor(Color.GREEN);
                    selectedAbility = img;
                    selectAbility();
                    if (view != null) {
                        view.setGamePaused(false);
                    }
                    Gdx.input.setInputProcessor(view);
                }
            });

            img.addListener(new InputListener() {
                @Override
                public void enter(InputEvent event, float x, float y, int pointer,
                                  com.badlogic.gdx.scenes.scene2d.Actor fromActor) {
                    img.setColor(Color.YELLOW);
                }

                @Override
                public void exit(InputEvent event, float x, float y, int pointer,
                                 com.badlogic.gdx.scenes.scene2d.Actor toActor) {
                    if (selectedAbility == img) {
                        img.setColor(Color.GREEN);
                    } else {
                        img.setColor(Color.WHITE);
                    }
                }
            });

            window.add(img).pad(10);
        }
    }

    public int getSelectedIndex() {
        for (int i = 0; i < abilityImages.length; i++) {
            if (abilityImages[i] == selectedAbility) return i;
        }
        return -1;
    }

    public void selectAbility() {
        int index = getSelectedIndex() + 1;
        for (AbilityConstants value : AbilityConstants.values()) {
            if (value.getNumber() == index) {
                Ability ability = App.getAbilityByName(value.getName());
                if (ability != null) {
                    player.setAbility(ability);
                    ability.applyAbility();
                    if (ability.getName().equals("damager")) {
                        damagerDuration = 10;
                    } else if (ability.getName().equals("speedy")) {
                        speedyDuration = 10;
                    }
                }
            }
        }
    }

}
