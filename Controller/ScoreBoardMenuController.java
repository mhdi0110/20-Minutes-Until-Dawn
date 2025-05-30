package io.github.some_example_name.Controller;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import io.github.some_example_name.Main;
import io.github.some_example_name.Model.App;
import io.github.some_example_name.Model.Player;
import io.github.some_example_name.Model.PlayerData;
import io.github.some_example_name.View.ScoreBoardMenuView;

import java.awt.*;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;

public class ScoreBoardMenuController {
    private ScoreBoardMenuView view;

    public void setView(ScoreBoardMenuView view) {
        this.view = view;
    }

    public void handleScoreBoardMenuButtons() {
        BitmapFont font = view.getFont();
        String order = view.getOrderBox().getSelected();
        ArrayList<PlayerData> data = sortData(order);
        int i = 1;
        font.getData().setScale(1.5f);
        for (PlayerData playerData : data) {
            if (i > 10) break;
            if (i == 1) font.setColor(Color.BLUE);
            else if (i == 2) font.setColor(Color.RED);
            else if (i == 3) font.setColor(Color.GREEN);
            if (playerData.getUsername().equals(App.getCurrentPlayer().getUsername()))
                font.draw(Main.getBatch(), "->" + i + "- " + playerData.getUsername(), 675, 500 - i * 50);
            else
                font.draw(Main.getBatch(), i + "- " + playerData.getUsername(), 700, 500 - i * 50);
            font.setColor(Color.WHITE);
            font.draw(Main.getBatch(), playerData.getScore() + "", 880, 500 - i * 50);
            font.draw(Main.getBatch(), playerData.getKills() + "", 1000, 500 - i * 50);
            font.draw(Main.getBatch(), playerData.getTimeAlive() + "", 1100, 500 - i * 50);
            i++;
        }
    }

    private ArrayList<PlayerData> sortData(String order) {
        ArrayList<PlayerData> data = App.getPlayerData();
        switch (order) {
            case "Kill":
                data.sort((a, b) -> Integer.compare(b.getKills(), a.getKills()));
                break;
            case "Score":
                data.sort((a, b) -> Integer.compare(b.getScore(), a.getScore()));
                break;
            case "Username":
                data.sort(Comparator.comparing(PlayerData::getUsername, String.CASE_INSENSITIVE_ORDER));
                break;
            case "Time Alive":
                data.sort((a, b) -> Integer.compare(b.getTimeAlive(), a.getTimeAlive()));
                break;
            default:
                break;
        }
        return data;
    }
}
