package io.github.some_example_name.Controller;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import io.github.some_example_name.Main;
import io.github.some_example_name.Model.App;
import io.github.some_example_name.Model.GameAssetsManager;
import io.github.some_example_name.Model.Player;
import io.github.some_example_name.View.LoginMenuView;
import io.github.some_example_name.View.MainMenuView;
import io.github.some_example_name.View.ProfileMenuView;

public class ProfileMenuController {
    private ProfileMenuView view;

    public void setView(ProfileMenuView view) {
        this.view = view;
    }

    public void handleSignUpButtons() {
        if (view.getUsernameChangeButton().isChecked()) {
            view.setInUsernameChange(true);
            view.getUsernameChangeButton().setChecked(false);
        } else if (view.getPasswordChangeButton().isChecked()) {
            view.setInPasswordChange(true);
            view.getPasswordChangeButton().setChecked(false);
        } else if (view.getAvatarChangeButton().isChecked()) {
            view.setInAvatarChange(true);
            view.getAvatarChangeButton().setChecked(false);
        } else if (view.getDeleteUserButton().isChecked()) {
            Player player = App.getCurrentPlayer();
            App.getPlayers().remove(player);
            App.setCurrentPlayer(null);
            view.setErrorMessage("User deleted successfully!\nRedirecting to login menu...");
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    Main.getMain().getScreen().dispose();
                    Main.getMain().setScreen(new LoginMenuView(new LoginMenuController(), GameAssetsManager.getSkin()));
                }
            }, 2);
            view.getDeleteUserButton().setChecked(false);
        } else if (view.getBackButton().isChecked()) {
            if (view.isInPasswordChange() || view.isInUsernameChange() || view.isInAvatarChange()) {
                view.setInUsernameChange(false);
                view.setInPasswordChange(false);
                view.setInAvatarChange(false);
            } else {
                Main.getMain().getScreen().dispose();
                Main.getMain().setScreen(new MainMenuView(new MainMenuController(), GameAssetsManager.getSkin()));
            }
            view.getBackButton().setChecked(false);
        } else if (view.getUsernameButton().isChecked()) {
            String username = view.getUsernameBox().getText();
            Player player = App.getCurrentPlayer();
            if (username.isEmpty()) {
                view.setErrorMessage("Username is required!");
            } else if (player.getUsername().equals(username)) {
                view.setErrorMessage("Please pick a new username!");
            } else {
                player.setUsername(username);
                view.setErrorMessage("Your username changed to " + username);
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        view.setInUsernameChange(false);
                    }
                }, 2);
            }
            view.getUsernameButton().setChecked(false);
        } else if (view.getPasswordButton().isChecked()) {
            String password = view.getPasswordBox().getText();
            Player player = App.getCurrentPlayer();
            if (password.isEmpty()) {
                view.setErrorMessage("Password is required!");
            } else if (player.getPassword().equals(password)) {
                view.setErrorMessage("Please pick a new password!");
            } else if (!password.matches("(?=.*[@#$%&*()_]+)(?=.*[A-Z])(?=.*[0-9])[@#$%&*()_a-zA-Z0-9]+")) {
                view.setErrorMessage("Password is weak!");
            } else {
                player.setPassword(password);
                view.setErrorMessage("Your password changed to " + password);
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        view.setInPasswordChange(false);
                    }
                }, 2);
            }
            view.getPasswordButton().setChecked(false);
        } else if (view.getAvatarButton().isChecked()) {
            String avatar = view.getAvatarBox().getText();
            int avatarIndex;
            try {
                avatarIndex = Integer.parseInt(avatar);
            } catch (NumberFormatException e) {
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        view.setErrorMessage("You should enter a valid avatar number!");
                    }
                }, 2);
                view.getAvatarButton().setChecked(false);
                return;
            }
            Texture texture = view.getAvatarsTexture().get(avatarIndex - 1);
            Player player = App.getCurrentPlayer();
            player.setAvatar(texture);
            view.printSelectedAvatar(texture);
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    view.setInAvatarChange(false);
                }
            }, 2);
            view.getAvatarButton().setChecked(false);
        }
    }
}
