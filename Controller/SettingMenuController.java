package io.github.some_example_name.Controller;

import io.github.some_example_name.Main;
import io.github.some_example_name.Model.GameAssetsManager;
import io.github.some_example_name.View.MainMenuView;
import io.github.some_example_name.View.SettingMenuView;

public class SettingMenuController {
    private SettingMenuView view;

    public void setView(SettingMenuView settingMenuView) {
        this.view = settingMenuView;
    }

    public void handleSignUpButtons() {
        if (view.getBackButton().isChecked()) {
            Main.getMain().getScreen().dispose();
            Main.getMain().setScreen(new MainMenuView(new MainMenuController(), GameAssetsManager.getSkin()));
            view.getBackButton().setChecked(false);
        }
    }
}
