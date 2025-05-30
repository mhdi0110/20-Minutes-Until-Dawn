package io.github.some_example_name.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import io.github.some_example_name.Enums.EnemyConstants;
import io.github.some_example_name.Main;
import io.github.some_example_name.Model.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnemyController {
    private List<Enemy> enemies;
    private Player player;
    private float tentacleSpawnTimer = 0;
    private float eyeBatSpawnTimer = 0;
    private float eyeBatShotTimer = 0;
    private Game game;
    private ArrayList<Bullet> bullets = new ArrayList<>();

    public EnemyController(List<Enemy> enemies, Player player, Game game) {
        this.enemies = enemies;
        this.player = player;
        this.game = game;
    }

    public void update() {
        float playerX = player.getPosX();
        float playerY = player.getPosY();
        spawnEnemies();
        updateBullets(Gdx.graphics.getDeltaTime(), player);
        ArrayList<Enemy> enemiesToRemove = new ArrayList<>();
        for (Enemy enemy : enemies) {
            if (enemy.isDead()) {
                Animation<Texture> animation = GameAssetsManager.getDeathAnimation();
                enemy.getEnemySprite().setRegion(animation.getKeyFrame(enemy.getTime(), false));
                if (!animation.isAnimationFinished(enemy.getTime())) {
                    enemy.setTime(enemy.getTime() + Gdx.graphics.getDeltaTime());
                    enemy.getEnemySprite().draw(Main.getBatch());
                } else {
                    enemiesToRemove.add(enemy);
                }
            }
            enemy.updateSpritePosition(player);
            if (!enemy.isDead()) {
                enemy.moveTowards(playerX, playerY);
                enemyAnimation(enemy);
                enemy.getEnemySprite().draw(Main.getBatch());
                if (player.getHitBox().collidesWith(enemy.getHitBox())) {//TODO:hits the tree, stays, doesn't have effect
                    player.reducePlayerHealth(enemy.getDamage());
                    playerHitAnimation();
                    player.setInvincibleTime(1);
                }
                if (enemy.getName().equals("eyeBat")) {
                    if (eyeBatShotTimer >= 3) {
                        float dirX = playerX - enemy.getX();
                        float dirY = playerY - enemy.getY();
                        float length = (float) Math.sqrt(dirX * dirX + dirY * dirY);
                        dirX /= length;
                        dirY /= length;
                        Bullet bullet = new Bullet(enemy.getX(), enemy.getY(), dirX, dirY);
                        bullet.setBulletTexture();
                        bullets.add(bullet);
                        eyeBatShotTimer = 0;
                    } else {
                        eyeBatShotTimer += Gdx.graphics.getDeltaTime();
                    }
                }
            }
        }
        for (Enemy enemy : enemiesToRemove) {
            enemies.remove(enemy);
        }
    }

    public void updateBullets(float deltaTime, Player player) {
        Iterator<Bullet> iter = bullets.iterator();
        while (iter.hasNext()) {
            Bullet bullet = iter.next();
            bullet.update(deltaTime);
            bullet.getBulletSprite().setPosition(bullet.getScreenX(player), bullet.getScreenY(player));
            bullet.getBulletSprite().draw(Main.getBatch());
            if (bullet.getHitBox().collidesWith(player.getHitBox())) {
                player.reducePlayerHealth(1);
                player.setInvincibleTime(1);
            }
        }
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

    public void spawnEnemies() {
        int x, y;
        for (int i = 0; i < (int) game.getTimePassed() / 30; i++) {
            if (tentacleSpawnTimer >= 3) {
                x = GenerateRandomNumber.generateRandomNumber(0, 3500);
                y = GenerateRandomNumber.generateRandomNumber(0, 2500);
                enemies.add(new Enemy(x, y, EnemyConstants.TENTACLE_MONSTER.getName(), EnemyConstants.TENTACLE_MONSTER.getWidth(),
                    EnemyConstants.TENTACLE_MONSTER.getHeight(), EnemyConstants.TENTACLE_MONSTER.getHealth()));
                tentacleSpawnTimer = 0;
            } else {
                tentacleSpawnTimer += Gdx.graphics.getDeltaTime();
            }
        }
        if (game.getTimePassed() >= game.getDuration() / 4) {
            for (int i = 0; i < (4 * (int) game.getTimePassed() - (int) game.getDuration() + 30) / 30; i++) {
                if (eyeBatSpawnTimer >= 10) {
                    x = GenerateRandomNumber.generateRandomNumber(0, 3500);
                    y = GenerateRandomNumber.generateRandomNumber(0, 2500);
                    enemies.add(new Enemy(x, y, EnemyConstants.EYEBAT.getName(), EnemyConstants.EYEBAT.getWidth(),
                        EnemyConstants.EYEBAT.getHeight(), EnemyConstants.EYEBAT.getHealth()));
                    eyeBatSpawnTimer = 0;
                } else {
                    eyeBatSpawnTimer += Gdx.graphics.getDeltaTime();
                }
            }
        }
    }

    private void playerHitAnimation() {
        Animation<Texture> animation = player.getHitAnimation();
        player.getPlayerSprite().setRegion(animation.getKeyFrame(player.getHitTime(), false));

        if (!animation.isAnimationFinished(player.getHitTime())) {
            player.setHitTime((player.getHitTime() + Gdx.graphics.getDeltaTime()));
        } else {
            player.setHitTime(0);
        }
    }
    
}
