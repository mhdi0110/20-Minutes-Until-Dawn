package io.github.some_example_name.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import io.github.some_example_name.Enums.AbilityConstants;
import io.github.some_example_name.Enums.HeroConstants;
import io.github.some_example_name.Enums.WeaponConstants;

import java.util.ArrayList;

public class App {
    private static ArrayList<Player> players = new ArrayList<>();
    private static ArrayList<Game> games = new ArrayList<>();
    private static Game currentGame;
    private static Player currentPlayer;
    private static Hero[] heroes;
    private static Weapon[] weapons;
    private static Ability[] abilities;

    static {
        heroes = new Hero[5];
        weapons = new Weapon[3];
        abilities = new Ability[5];
        int i = 0;
        for (HeroConstants value : HeroConstants.values()) {
            heroes[i] = new Hero(value.getName(), value.getSpeed(), value.getHealth());
            i++;
        }
        i = 0;
        for (WeaponConstants value : WeaponConstants.values()) {
            weapons[i] = new Weapon(value.getName(), value.getDamage(), value.getProjectile(),
                value.getReloadTime(), value.getMaxAmmo());
            i++;
        }
        i = 0;
        for (AbilityConstants value : AbilityConstants.values()) {
            abilities[i] = new Ability(value.getName(), value.getTexture());
            i++;
        }
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static void setPlayer(Player player) {
        players.add(player);
    }

    public static boolean isPlayerRegistered(String username) {
        for (Player user : players) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static Player getPlayer(String username) {
        for (Player user : players) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static void setCurrentPlayer(Player currentUser) {
        App.currentPlayer = currentUser;
    }

    public static void s() {
        Player user = new Player("m", "1");
        user.setSecurity("ayo");
        user.setSecurityAnswer("yo");
        user.setAvatar(new Texture(Gdx.files.internal("avatar/avatar1.png")));
        App.setPlayer(user);
        App.setCurrentPlayer(user);

    }

    public static String[] getHeroes() {
        String[] result = new String[5];
        int i = 0;
        for (Hero hero : heroes) {
            result[i] = hero.getName();
            i++;
        }
        return result;
    }

    public static String[] getWeapons() {
        String[] result = new String[3];
        int i = 0;
        for (Weapon weapon : weapons) {
            result[i] = weapon.getName();
            i++;
        }
        return result;
    }

    public static Hero getHeroByName(String name) {
        for (Hero hero : heroes) {
            if (hero.getName().equals(name)) {
                return hero;
            }
        }
        return null;
    }

    public static Weapon getWeaponByName(String name) {
        for (Weapon weapon : weapons) {
            if (weapon.getName().equals(name)) {
                return weapon;
            }
        }
        return null;
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        App.currentGame = currentGame;
    }

    public static ArrayList<Game> getGames() {
        return games;
    }

    public static void setGame(Game game) {
        App.games.add(game);
    }

    public static Ability getAbilities(int index) {
        return abilities[index];
    }
    public static Ability getAbilityByName(String name) {
        for (Ability ability : abilities) {
            if (ability.getName().equals(name)) {
                return ability;
            }
        }
        return null;
    }
}
