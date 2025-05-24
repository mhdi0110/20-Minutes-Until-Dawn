package io.github.some_example_name.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.awt.*;

public class Player {
    private String username;
    private String password;
    private String security;
    private String securityAnswer;
    private Image avatarImage;
    private int score;
    private Hero hero;
    private Weapon weapon;
    private Texture playerTexture;
    private Sprite playerSprite;
    private HitBox hitBox;
    private float posX = 0;
    private float posY = 0;
    private float time = 0;
    private float heartTime = 0;
    private Animation<Texture> playerAnimation;
    private Sprite heartSprite;
    private Texture heartTexture;
    private float invincibleTime = 0;
    private int xp;
    private int level;
    public Player(String username, String password) {
        this.username = username;
        this.password = password;
        this.security = "";
        this.securityAnswer = "";
        this.score = 0;
        this.xp = 0;
        setHeartTexture();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public void setAvatar(Texture avatarTexture) {
        this.avatarImage = new Image(avatarTexture);
    }

    public Image getAvatarImage() {
        return avatarImage;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Sprite getPlayerSprite() {
        return playerSprite;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public float getPosY() {
        return posY;
    }


    public float getPosX() {
        return posX;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public void setPlayerTexture() {
        switch (hero.getName()) {
            case "shana":
                playerTexture = GameAssetsManager.getShana0();
                break;
            case "diamond":
                playerTexture = GameAssetsManager.getDiamond0();
                break;
            case "scarlet":
                playerTexture = GameAssetsManager.getScarlet0();
                break;
            case "lilith":
                playerTexture = GameAssetsManager.getLilith0();
                break;
            case "dasher":
                playerTexture = GameAssetsManager.getDasher0();
                break;
            default:
                playerTexture = GameAssetsManager.getDasher0();
                break;
        }
        playerSprite = new Sprite(playerTexture);
        playerSprite.setPosition((float) Gdx.graphics.getWidth() / 2, (float) Gdx.graphics.getHeight() / 2);
        playerSprite.setSize(playerTexture.getWidth() * 3, playerTexture.getHeight() * 3);
        hitBox = new HitBox((float) Gdx.graphics.getWidth() / 2, (float) Gdx.graphics.getHeight(),
            playerTexture.getWidth() * 3, playerTexture.getHeight() * 3);
    }

    public Animation<Texture> getPlayerAnimation() {
        return playerAnimation;
    }

    public void setPlayerAnimation() {
        switch (hero.getName()) {
            case "shana":
                playerAnimation = GameAssetsManager.getShanaAnimation();
                break;
            case "diamond":
                playerAnimation = GameAssetsManager.getDiamondAnimation();
                break;
            case "scarlet":
                playerAnimation = GameAssetsManager.getScarletAnimation();
                break;
            case "lilith":
                playerAnimation = GameAssetsManager.getLilithAnimation();
                break;
            case "dasher":
                playerAnimation = GameAssetsManager.getDasherAnimation();
                break;
            default:
                playerAnimation = GameAssetsManager.getDasherAnimation();
                break;
        }
    }

    public HitBox getHitBox() {
        return hitBox;
    }
    public void setHeartTexture() {
        heartTexture = GameAssetsManager.getHeart0();
        heartSprite = new Sprite(heartTexture);
        heartSprite.setSize(heartTexture.getWidth() * 3, heartTexture.getHeight() * 3);
    }

    public Sprite getHeartSprite() {
        return heartSprite;
    }

    public float getHeartTime() {
        return heartTime;
    }

    public void setHeartTime(float heartTime) {
        this.heartTime = heartTime;
    }

    public float getInvincibleTime() {
        return invincibleTime;
    }

    public void setInvincibleTime(float invincibleTime) {
        this.invincibleTime = invincibleTime;
    }

    public void reducePlayerHealth(int damage) {
        if (invincibleTime <= 0) {
            hero.setHealth(hero.getHealth() - damage);
        }
    }
}
