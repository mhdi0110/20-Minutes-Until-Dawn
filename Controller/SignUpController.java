package io.github.some_example_name.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;
import com.badlogic.gdx.utils.Timer;
import io.github.some_example_name.Main;
import io.github.some_example_name.Model.App;
import io.github.some_example_name.Model.GameAssetsManager;
import io.github.some_example_name.Model.Player;
import io.github.some_example_name.View.LoginMenuView;
import io.github.some_example_name.View.MainMenuView;
import io.github.some_example_name.View.SignUpMenuView;

import java.util.Random;

public class SignUpController {
    private SignUpMenuView view;

    public void setView(SignUpMenuView view) {
        this.view = view;
    }

    public void handleSignUpButtons() {
        if (view.getTextButton().isChecked()) {
            String username = view.getUsernameBox().getText();
            String password = view.getPasswordBox().getText();
            String question = view.getSelectBox().getSelected();
            String answer = view.getSecurityAnswerBox().getText();

            if (username.isEmpty()) {
                view.setErrorMessage("Username is required");
            } else if (password.isEmpty()) {
                view.setErrorMessage("Password is required");
            } else if (App.isPlayerRegistered(username)) {
                view.setErrorMessage("This username already exists!");
            } else if (password.length() < 8 ||
                !password.matches("(?=.*[@#$%&*()_]+)(?=.*[A-Z])(?=.*[0-9])[@#$%&*()_a-zA-Z0-9]+")) {
                view.setErrorMessage("Password is weak!");
            } else if (question.isEmpty()) {
                view.setErrorMessage("Question is required");
            } else if (answer.isEmpty()) {
                view.setErrorMessage("Answer is required");
            } else {
                view.getTextButton().setChecked(false);
                Player player = new Player(username, password);
                App.setPlayer(player);
                player.setSecurity(question);
                player.setSecurityAnswer(answer);
                setAvatar(player);
                view.setErrorMessage("User registered successfully!");
                App.setCurrentPlayer(player);
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        Main.getMain().getScreen().dispose();
                        Main.getMain().setScreen(new MainMenuView(new MainMenuController(), GameAssetsManager.getSkin()));
                    }
                }, 2);
                SaveAndLoadData.saveData(player);
            }
        } else if (view.getLoginButton().isChecked()) {
            Main.getMain().getScreen().dispose();
            Main.getMain().setScreen(new LoginMenuView(new LoginMenuController(), GameAssetsManager.getSkin()));
        } else if (view.getLoginAsGuestButton().isChecked()) {
            App.setCurrentPlayer(new Player("Guest", ""));
            view.setErrorMessage("You've logged in as a guest!");
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    Main.getMain().getScreen().dispose();
                    Main.getMain().setScreen(new MainMenuView(new MainMenuController(), GameAssetsManager.getSkin()));
                }
            }, 2);

        }
    }
    public void setAvatar(Player user) {
        int randomNumber = GenerateRandomNumber.generateRandomNumber(1, 5);
        String avatarStr = "avatar/avatar" + randomNumber + ".png";
        user.setAvatar(new Texture(Gdx.files.internal(avatarStr)));
    }
}

