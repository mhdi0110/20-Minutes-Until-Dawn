package io.github.some_example_name.Controller;

import io.github.some_example_name.Main;
import io.github.some_example_name.Model.*;
import io.github.some_example_name.View.*;

public class  PreGameMenuController {
    private PreGameMenuView view;

    public void setView( PreGameMenuView view) {
        this.view = view;
    }

    public void handleSignUpButtons() {
        if(view.getPlayButton().isChecked()) {
            String heroName = view.getHeroSelectBox().getSelected();
            String weaponName = view.getWeaponSelectBox().getSelected();
            int duration = view.getDurationSelectBox().getSelected();
            Hero hero = App.getHeroByName(heroName);
            Weapon weapon = App.getWeaponByName(weaponName);
            Game game = new Game(duration);
            App.setGame(game);
            App.setCurrentGame(game);
            Player player = App.getCurrentPlayer();
            player.setHero(hero);
            player.setWeapon(weapon);
            player.setPlayerTexture();
            player.setPlayerAnimation();
            player.getWeapon().setWeaponTexture(player);

            view.getPlayButton().setChecked(false);
            Main.getMain().getScreen().dispose();
            Main.getMain().setScreen(new GameView(new GameController(), GameAssetsManager.getSkin()));
        }
    }
}
