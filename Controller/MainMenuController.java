package io.github.some_example_name.Controller;

import io.github.some_example_name.Main;
import io.github.some_example_name.Model.App;
import io.github.some_example_name.Model.GameAssetsManager;
import io.github.some_example_name.View.*;

public class MainMenuController {
    private MainMenuView view;

    public void setView(MainMenuView view) {
        this.view = view;
    }

    public void handleMainMenuButtons() {
        if (view.getProfileButton().isChecked()) {
            Main.getMain().getScreen().dispose();
            Main.getMain().setScreen(new ProfileMenuView(new ProfileMenuController(), GameAssetsManager.getSkin()));
        } else if (view.getPreGameButton().isChecked()) {
            Main.getMain().getScreen().dispose();
            Main.getMain().setScreen(new PreGameMenuView(new PreGameMenuController(), GameAssetsManager.getSkin()));
        } else if (view.getScoreBoardButton().isChecked()) {

        } else if (view.getHintButton().isChecked()) {

        } else if (view.getSettingButton().isChecked()) {
            Main.getMain().getScreen().dispose();
            Main.getMain().setScreen(new SettingMenuView(new SettingMenuController(), GameAssetsManager.getSkin()));
        } else if (view.getLogOutButton().isChecked()) {
            App.setCurrentPlayer(null);
            Main.getMain().getScreen().dispose();
            Main.getMain().setScreen(new LoginMenuView(new LoginMenuController(), GameAssetsManager.getSkin()));
        }
    }
}
