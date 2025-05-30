package io.github.some_example_name.Controller;

import io.github.some_example_name.Model.App;
import io.github.some_example_name.Model.Player;
import io.github.some_example_name.Model.PlayerData;
import io.github.some_example_name.View.ScoreBoardMenuView;

import java.util.ArrayList;

public class ScoreBoardMenuController {
    private ScoreBoardMenuView view;

    public void setView(ScoreBoardMenuView view) {
        this.view = view;
    }

    public void handleScoreBoardMenuButtons() {
        String order = view.getOrderBox().getSelected();

    }
    private void sortData(String order) {
        ArrayList<PlayerData> data = App.getPlayerData();
        switch (order) {
            case "Kill":
                break;
            case "Score":
                break;
            case "Username":
                break;
            case "Time Alive":
                break;

        }
    }
}
