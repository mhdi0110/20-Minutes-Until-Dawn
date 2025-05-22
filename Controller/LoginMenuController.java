package io.github.some_example_name.Controller;

import io.github.some_example_name.Main;
import io.github.some_example_name.Model.App;
import io.github.some_example_name.Model.GameAssetsManager;
import io.github.some_example_name.Model.Player;
import io.github.some_example_name.View.LoginMenuView;
import io.github.some_example_name.View.MainMenuView;
import io.github.some_example_name.View.SignUpMenuView;

public class LoginMenuController {
    private LoginMenuView view;

    public void setView(LoginMenuView view) {
        this.view = view;
    }

    public void handleSignUpButtons() {
        if (view.getSignUpButton().isChecked()) {
            Main.getMain().getScreen().dispose();
            Main.getMain().setScreen(new SignUpMenuView(new SignUpController(), GameAssetsManager.getSkin()));
        } else if (view.getLoginButton().isChecked()) {
            String username = view.getUsernameBox().getText();
            String password = view.getPasswordBox().getText();
            Player user = App.getPlayer(username);
            if (username.isEmpty()) {
                view.setErrorMessage("Username is required");
            } else if (password.isEmpty()) {
                view.setErrorMessage("Password is required");
            } else if (user == null) {
                view.setErrorMessage("Username does not exist");
            } else if (!password.equals(user.getPassword())) {
                view.setErrorMessage("Wrong password");
            } else {
                App.setCurrentPlayer(user);
                Main.getMain().getScreen().dispose();
                Main.getMain().setScreen(new MainMenuView(new MainMenuController(), GameAssetsManager.getSkin()));
            }
            view.getLoginButton().setChecked(false);
        } else if (view.getForgetPasswordButton().isChecked()) {
            String username = view.getUsernameBox().getText();
            if (username.isEmpty()) {
                view.setErrorMessage("Username is required to change password");
            } else {
                Player user = App.getPlayer(username);
                if (user == null) {
                    view.setErrorMessage("Username does not exist");

                } else {
                    view.getSecurityQuestionBox().setText(user.getSecurity());
                    view.setInForgetPassword(true);
                }
            }
            view.getForgetPasswordButton().setChecked(false);
        } else if (view.getSecurityAnswerButton().isChecked()) {
            String answer = view.getSecurityAnswerBox().getText();
            String username = view.getUsernameBox().getText();
            String newPassword = view.getNewPasswordBox().getText();
            Player user = App.getPlayer(username);
            if (answer.isEmpty()) view.setErrorMessage("Security answer is required");
            else if (!user.getSecurityAnswer().equals(answer)) view.setErrorMessage("Wrong security answer");
            else if (newPassword.isEmpty()) view.setErrorMessage("New password is required");
            else if (!newPassword.matches("(?=.*[@#$%&*()_]+)(?=.*[A-Z])(?=.*[0-9])[@#$%&*()_a-zA-Z0-9]+"))
                view.setErrorMessage("New password is weak!");
            else view.setErrorMessage("Your password changed successfully!");
            view.getSecurityAnswerButton().setChecked(false);
        } else if (view.getExitButton().isChecked()) {
            view.setInForgetPassword(false);
            view.getExitButton().setChecked(false);
        }
    }
}
