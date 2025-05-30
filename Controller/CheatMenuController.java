package io.github.some_example_name.Controller;

import io.github.some_example_name.Main;
import io.github.some_example_name.Model.App;
import io.github.some_example_name.Model.Game;
import io.github.some_example_name.Model.Player;
import io.github.some_example_name.View.CheatMenuView;

public class CheatMenuController {
    private CheatMenuView view;

    public void setView(CheatMenuView cheatMenuView) {
        this.view = cheatMenuView;
    }

    public void handleCheatMenuButtons() {
        if (view.getSelectButton().isChecked()) {
            String cheat = view.getCheatCodeBox().getSelected();
            applyCheat(cheat);
            view.getSelectButton().setChecked(false);
            Main.getMain().setScreen(App.getCurrentGame().getView());
        } else if (view.getExitButton().isChecked()) {
            Main.getMain().setScreen(App.getCurrentGame().getView());
            view.getExitButton().setChecked(false);
        }
    }

    public void applyCheat(String cheat) {
        Player player = App.getCurrentPlayer();
        Game game = App.getCurrentGame();
        switch (cheat) {
            case "Time Eater":
                game.setTimePassed(game.getTimePassed() + 60);
                break;
            case "Level Booster":
                player.setXp(player.getXpForNextLevel() + 1);
                break;
            case "Heart Dahande":
                player.getHero().setHealth(player.getHero().getHealth() + 1);
                break;
            case "Kerm Dashtan":
                break;
            case "Hesoyam":
                player.setImmortal(true);
                break;
        }
    }
}
