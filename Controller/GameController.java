package io.github.some_example_name.Controller;

import com.badlogic.gdx.scenes.scene2d.ui.List;
import io.github.some_example_name.Enums.EnemyConstants;
import io.github.some_example_name.Model.App;
import io.github.some_example_name.Model.Enemy;
import io.github.some_example_name.Model.Game;
import io.github.some_example_name.Model.Player;
import io.github.some_example_name.View.GameView;

import java.util.ArrayList;

public class GameController {
    private GameView view;
    private PlayerController playerController = new PlayerController(App.getCurrentPlayer());
    private WeaponController weaponController = new WeaponController(App.getCurrentPlayer().getWeapon());
    private WorldController worldController = new WorldController(playerController);
    private EnemyController enemyController;
    public void setView(GameView view) {
        this.view = view;
    }
    public GameController() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy(100, 100, EnemyConstants.TREE.getName()));
        enemyController = new EnemyController(enemies, App.getCurrentPlayer());
    }

    public void updateGame() {
        if(view != null) {
            worldController.update();
            playerController.update();
            weaponController.update();
            enemyController.update();
        }
    }

    public WeaponController getWeaponController() {
        return weaponController;
    }
}
