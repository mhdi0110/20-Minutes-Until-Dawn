package io.github.some_example_name.Controller;

import io.github.some_example_name.Model.App;
import io.github.some_example_name.Model.Game;
import io.github.some_example_name.Model.Player;
import io.github.some_example_name.View.GameView;

public class GameController {
    private GameView view;
    private PlayerController playerController = new PlayerController(App.getCurrentPlayer());
    private WeaponController weaponController = new WeaponController(App.getCurrentPlayer().getWeapon());
    private WorldController worldController = new WorldController(playerController);

    public void setView(GameView view) {
        this.view = view;
    }

    public void updateGame() {
        if(view != null) {
            worldController.update();
            playerController.update();
            weaponController.update();
        }
    }

    public WeaponController getWeaponController() {
        return weaponController;
    }
}
