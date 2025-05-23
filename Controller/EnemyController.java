package io.github.some_example_name.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import io.github.some_example_name.Main;
import io.github.some_example_name.Model.Enemy;
import io.github.some_example_name.Model.GameAssetsManager;
import io.github.some_example_name.Model.Player;

import java.util.List;

public class EnemyController {
    private List<Enemy> enemies;
    private Player player;

    public EnemyController(List<Enemy> enemies, Player player) {
        this.enemies = enemies;
        this.player = player;
    }

    public void update() {
        float playerX = player.getPosX();
        float playerY = player.getPosY();
        for (Enemy enemy : enemies) {
            if (enemy.getHealth() > 0) {
                enemy.moveTowards(playerX, playerY);
                enemyAnimation(enemy);
                enemy.updateSpritePosition(player);
                enemy.getEnemySprite().draw(Main.getBatch());
                if (player.getHitBox().collidesWith(enemy.getHitBox())) {//TODO:hits the tree, stays, doesn't have effect
                    enemy.reducePlayerHealth(player);
                    player.setInvincibleTime(1);
                }
            }
        }
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void enemyAnimation(Enemy enemy) {
        Animation<Texture> animation = enemy.getEnemyAnimation();
        enemy.getEnemySprite().setRegion(animation.getKeyFrame(enemy.getTime(), true));

        if (!animation.isAnimationFinished(enemy.getTime())) {
            enemy.setTime((enemy.getTime() + Gdx.graphics.getDeltaTime()));
        } else {
            enemy.setTime(0);
        }
    }

}
