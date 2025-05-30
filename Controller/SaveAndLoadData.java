package io.github.some_example_name.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;
import io.github.some_example_name.Model.App;
import io.github.some_example_name.Model.Player;
import io.github.some_example_name.Model.PlayerData;

import java.util.ArrayList;

public class SaveAndLoadData {
    public static void loadData() {
        Json json = new Json();
        json.setOutputType(JsonWriter.OutputType.json); // not required for loading, but doesn't hurt

        String fileContent = Gdx.files.local("Data/PlayerData.json").readString();
        Array<PlayerData> libgdxArray = json.fromJson(Array.class, PlayerData.class, fileContent);

        ArrayList<PlayerData> arrayList = new ArrayList<>();
        for (PlayerData pd : libgdxArray) {
            arrayList.add(pd);
        }
        App.setPlayerData(arrayList);
    }

    public static void createPlayersWithData() {
        for (PlayerData playerData : App.getPlayerData()) {
            String username = playerData.getUsername();
            String password = playerData.getPassword();
            String security = playerData.getSecurity();
            String securityAnswer = playerData.getSecurityAnswer();
            
            Player player = new Player(username, password);
            player.setSecurity(security);
            player.setSecurityAnswer(securityAnswer);
            App.setPlayer(player);
        }
    }

    public static void saveData(Player player) {
        player.getPlayerData().save(player);

        ArrayList<PlayerData> playerDataList = App.getPlayerData();
        boolean found = false;
        for (int i = 0; i < playerDataList.size(); i++) {
            if (playerDataList.get(i).getUsername().equals(player.getPlayerData().getUsername())) {
                playerDataList.set(i, player.getPlayerData());
                found = true;
                break;
            }
        }
        if (!found) {
            playerDataList.add(player.getPlayerData());
        }
        Json json = new Json();
        json.setOutputType(JsonWriter.OutputType.json);
        json.setTypeName(null);
        String saveString = json.toJson(App.getPlayerData());
        Gdx.files.local("Data/PlayerData.json").writeString(saveString, false);
    }
}
