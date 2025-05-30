package io.github.some_example_name.Controller;

import io.github.some_example_name.Main;
import io.github.some_example_name.Model.GameAssetsManager;
import io.github.some_example_name.View.GameView;
import io.github.some_example_name.View.HintMenuView;
import io.github.some_example_name.View.MainMenuView;

public class HintMenuController {
    private HintMenuView view;
    public void setView(HintMenuView hintMenuView) {
        this.view = hintMenuView;
    }

    public void handleHintMenuButtons() {
        if(view.getExitButton().isChecked()) {
            Main.getMain().setScreen(new MainMenuView(new MainMenuController(), GameAssetsManager.getSkin()));
            view.getExitButton().setChecked(false);
        }
    }
}
