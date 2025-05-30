package io.github.some_example_name.Controller;

import io.github.some_example_name.Main;
import io.github.some_example_name.Model.GameAssetsManager;
import io.github.some_example_name.View.EndGameMenuView;
import io.github.some_example_name.View.MainMenuView;

public class EndGameMenuController {
    private EndGameMenuView view;
    public void setView(EndGameMenuView endGameMenuView) {
        this.view = endGameMenuView;
    }

    public void handleEndGameMenuButtons() {
        if(view.getGoToMainMenuButton().isChecked()) {
            Main.getMain().setScreen(new MainMenuView(new MainMenuController(), GameAssetsManager.getSkin()));
            view.getGoToMainMenuButton().setChecked(false);
        }
    }
}
