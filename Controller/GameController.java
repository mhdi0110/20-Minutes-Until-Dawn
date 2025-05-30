package io.github.some_example_name.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import io.github.some_example_name.Enums.EnemyConstants;
import io.github.some_example_name.Main;
import io.github.some_example_name.Model.App;
import io.github.some_example_name.Model.Enemy;
import io.github.some_example_name.Model.Game;
import io.github.some_example_name.Model.Player;
import io.github.some_example_name.View.GameView;

import java.util.ArrayList;

public class GameController {
    private GameView view;
    private Game game;
    private PlayerController playerController = new PlayerController(App.getCurrentPlayer());
    private WeaponController weaponController = new WeaponController(App.getCurrentPlayer().getWeapon());
    private WorldController worldController = new WorldController(playerController);
    private EnemyController enemyController;
    private Player player;

    public void setView(GameView view) {
        this.view = view;
        worldController.setView(view);
    }

    public GameController() {
        this.game = App.getCurrentGame();
        this.player = App.getCurrentPlayer();
        ArrayList<Enemy> enemies = game.getEnemies();
        int treeAmount = GenerateRandomNumber.generateRandomNumber(20, 30);
        int x, y;
        for (int i = 0; i < treeAmount; i++) {
            x = GenerateRandomNumber.generateRandomNumber(0, 3500);
            y = GenerateRandomNumber.generateRandomNumber(0, 2500);
            for (Enemy enemy : enemies) {
                while (enemy.getX() == x && enemy.getY() == y) {
                    x = GenerateRandomNumber.generateRandomNumber(0, 3500);
                    y = GenerateRandomNumber.generateRandomNumber(0, 2500);
                }
            }
            enemies.add(new Enemy(x, y, EnemyConstants.TREE.getName(),
                EnemyConstants.TREE.getWidth(), EnemyConstants.TREE.getHeight(), EnemyConstants.TREE.getHealth()));
        }
        enemyController = new EnemyController(enemies, App.getCurrentPlayer(), game);
    }

    public void updateGame(float delta, AbilityController abilityController) {
        if (view != null) {
            player.setInvincibleTime(Math.max(0, player.getInvincibleTime() - delta));
            worldController.update();
            playerController.update();
            weaponController.update(delta);
            enemyController.update();
            abilityController.update();
        }
    }

    public WeaponController getWeaponController() {
        return weaponController;
    }
}
