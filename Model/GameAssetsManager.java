package io.github.some_example_name.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class GameAssetsManager {
    private static Skin skin;
    private static final Texture shana0 = new Texture(Gdx.files.internal("Sprite/idle/dasher_0.png"));
    private static final Texture shana1 = new Texture(Gdx.files.internal("Sprite/idle/dasher_1.png"));
    private static final Texture shana2 = new Texture(Gdx.files.internal("Sprite/idle/dasher_2.png"));
    private static final Texture shana3 = new Texture(Gdx.files.internal("Sprite/idle/dasher_3.png"));
    private static final Texture shana4 = new Texture(Gdx.files.internal("Sprite/idle/dasher_4.png"));
    private static final Texture shana5 = new Texture(Gdx.files.internal("Sprite/idle/dasher_5.png"));
    private static final Animation<Texture> shanaAnimation = new Animation<>(0.1f,
        shana0, shana1, shana2, shana3, shana4, shana5);
    private static final Texture dasher0 = new Texture(Gdx.files.internal("Sprite/idle/dasher_0.png"));
    private static final Texture dasher1 = new Texture(Gdx.files.internal("Sprite/idle/dasher_1.png"));
    private static final Texture dasher2 = new Texture(Gdx.files.internal("Sprite/idle/dasher_2.png"));
    private static final Texture dasher3 = new Texture(Gdx.files.internal("Sprite/idle/dasher_3.png"));
    private static final Texture dasher4 = new Texture(Gdx.files.internal("Sprite/idle/dasher_4.png"));
    private static final Texture dasher5 = new Texture(Gdx.files.internal("Sprite/idle/dasher_5.png"));
    private static final Animation<Texture> dasherAnimation = new Animation<>(0.1f,
        dasher0, dasher1, dasher2, dasher3, dasher4, dasher5);
    private static final Texture diamond0 = new Texture(Gdx.files.internal("Sprite/idle/diamond_0.png"));
    private static final Texture diamond1 = new Texture(Gdx.files.internal("Sprite/idle/diamond_1.png"));
    private static final Texture diamond2 = new Texture(Gdx.files.internal("Sprite/idle/diamond_2.png"));
    private static final Texture diamond3 = new Texture(Gdx.files.internal("Sprite/idle/diamond_3.png"));
    private static final Texture diamond4 = new Texture(Gdx.files.internal("Sprite/idle/diamond_4.png"));
    private static final Texture diamond5 = new Texture(Gdx.files.internal("Sprite/idle/diamond_5.png"));
    private static final Animation<Texture> diamondAnimation = new Animation<>(0.1f,
        diamond0, diamond1, diamond2, diamond3, diamond4, diamond5);
    private static final Texture lilith0 = new Texture(Gdx.files.internal("Sprite/idle/lilith_0.png"));
    private static final Texture lilith1 = new Texture(Gdx.files.internal("Sprite/idle/lilith_1.png"));
    private static final Texture lilith2 = new Texture(Gdx.files.internal("Sprite/idle/lilith_2.png"));
    private static final Texture lilith3 = new Texture(Gdx.files.internal("Sprite/idle/lilith_3.png"));
    private static final Texture lilith4 = new Texture(Gdx.files.internal("Sprite/idle/lilith_4.png"));
    private static final Texture lilith5 = new Texture(Gdx.files.internal("Sprite/idle/lilith_5.png"));
    private static final Animation<Texture> lilithAnimation = new Animation<>(0.1f,
        lilith0, lilith1, lilith2, lilith3, lilith4, lilith5);
    private static final Texture scarlet0 = new Texture(Gdx.files.internal("Sprite/idle/scarlet_0.png"));
    private static final Texture scarlet1 = new Texture(Gdx.files.internal("Sprite/idle/scarlet_1.png"));
    private static final Texture scarlet2 = new Texture(Gdx.files.internal("Sprite/idle/scarlet_2.png"));
    private static final Texture scarlet3 = new Texture(Gdx.files.internal("Sprite/idle/scarlet_3.png"));
    private static final Texture scarlet4 = new Texture(Gdx.files.internal("Sprite/idle/scarlet_4.png"));
    private static final Texture scarlet5 = new Texture(Gdx.files.internal("Sprite/idle/scarlet_5.png"));
    private static final Animation<Texture> scarletAnimation = new Animation<>(0.1f,
        scarlet0, scarlet1, scarlet2, scarlet3, scarlet4, scarlet5);
    private static final Texture revolverStill = new Texture(Gdx.files.internal("Sprite/RevolverStill/RevolverStill.png"));
    private static final Texture smgStill = new Texture(Gdx.files.internal("Sprite/SMGStill/SMGStill.png"));
    private static final Texture bullet = new Texture(Gdx.files.internal("bullet.png"));
    private static final Texture smgReload0 = new Texture(Gdx.files.internal("Sprite/SMGReload/SMGReload_0.png"));
    private static final Texture smgReload1 = new Texture(Gdx.files.internal("Sprite/SMGReload/SMGReload_1.png"));
    private static final Texture smgReload2 = new Texture(Gdx.files.internal("Sprite/SMGReload/SMGReload_2.png"));
    private static final Texture smgReload3 = new Texture(Gdx.files.internal("Sprite/SMGReload/SMGReload_3.png"));
    private static final Animation<Texture> smgReload = new Animation<>(0.1f,
        smgReload0, smgReload1, smgReload2, smgReload3);
    private static final Texture tree0 = new Texture(Gdx.files.internal("Sprite/T/T_TreeMonster_0.png"));
    private static final Texture tree1 = new Texture(Gdx.files.internal("Sprite/T/T_TreeMonster_1.png"));
    private static final Texture tree2 = new Texture(Gdx.files.internal("Sprite/T/T_TreeMonster_2.png"));
    private static final Animation<Texture> treeAnimation = new Animation<>(2f,
        tree0, tree1, tree2);
    private static final Texture heart0 = new Texture(Gdx.files.internal("Sprite/HeartAnimation/Heart_0.png"));
    private static final Texture heart1 = new Texture(Gdx.files.internal("Sprite/HeartAnimation/Heart_1.png"));
    private static final Texture heart2 = new Texture(Gdx.files.internal("Sprite/HeartAnimation/Heart_2.png"));
    private static final Texture heart3 = new Texture(Gdx.files.internal("Sprite/HeartAnimation/Heart_3.png"));
    private static final Animation<Texture> heartAnimation = new Animation<>(0.5f,
        heart0, heart1, heart2);

    public static Skin getSkin() {
        if (skin == null) {
            skin = new Skin(Gdx.files.internal("skin/biological-attack-ui.json"));
        }
        return skin;
    }

    public static Animation<Texture> getShanaAnimation() {
        return shanaAnimation;
    }

    public static Animation<Texture> getDasherAnimation() {
        return dasherAnimation;
    }

    public static Animation<Texture> getDiamondAnimation() {
        return diamondAnimation;
    }

    public static Animation<Texture> getLilithAnimation() {
        return lilithAnimation;
    }

    public static Animation<Texture> getScarletAnimation() {
        return scarletAnimation;
    }

    public static Texture getDasher0() {
        return dasher0;
    }

    public static Texture getShana0() {
        return shana0;
    }

    public static Texture getDiamond0() {
        return diamond0;
    }

    public static Texture getLilith0() {
        return lilith0;
    }

    public static Texture getScarlet0() {
        return scarlet0;
    }

    public static Texture getRevolverStill() {
        return revolverStill;
    }

    public static Texture getSmgStill() {
        return smgStill;
    }

    public static Texture getBullet() {
        return bullet;
    }

    public static Animation<Texture> getSmgReload() {
        return smgReload;
    }

    public static Animation<Texture> getTreeAnimation() {
        return treeAnimation;
    }

    public static Texture getTree0() {
        return tree0;
    }

    public static Animation<Texture> getHeartAnimation() {
        return heartAnimation;
    }

    public static Texture getHeart0() {
        return heart0;
    }

    public static Texture getHeart3() {
        return heart3;
    }
}
