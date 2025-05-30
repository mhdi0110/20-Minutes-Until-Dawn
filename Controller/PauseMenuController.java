package io.github.some_example_name.Controller;

import io.github.some_example_name.Main;
import io.github.some_example_name.Model.App;
import io.github.some_example_name.Model.GameAssetsManager;
import io.github.some_example_name.Model.Player;
import io.github.some_example_name.View.EndGameMenuView;
import io.github.some_example_name.View.GameView;
import io.github.some_example_name.View.PauseMenuView;

public class PauseMenuController {
    private PauseMenuView view;
    private Player player = App.getCurrentPlayer();

    public void setView(PauseMenuView pauseMenuView) {
        this.view = pauseMenuView;
    }

    public void handlePauseMenuButtons() {
        if (view.getGiveUpButton().isChecked()) {
            player.setHasWon(false);
            view.getGiveUpButton().setChecked(false);
            Main.getMain().setScreen(new EndGameMenuView(new EndGameMenuController(), GameAssetsManager.getSkin()));
        } else if (view.getResumeButton().isChecked()) {
            Main.getMain().getScreen().dispose();
            Main.getMain().setScreen(App.getCurrentGame().getView());
            view.getResumeButton().setChecked(false);
        }
    }
}
