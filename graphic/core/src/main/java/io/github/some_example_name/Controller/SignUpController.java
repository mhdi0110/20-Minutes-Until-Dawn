package io.github.some_example_name.Controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import io.github.some_example_name.Main;
import io.github.some_example_name.Model.App;
import io.github.some_example_name.View.SignUpView;

public class SignUpController {
    private SignUpView view;
    BitmapFont font;

    public void setView(SignUpView view) {
        this.view = view;
        font = new BitmapFont();
    }

    public void handleSignUpButtons() {
        if (view.getTextButton().isChecked()) {
            if (!App.isUserRegistered(view.getUserNameBox().getText())) {
                font.draw(Main.getBatch(), "Username already exists.", 10, 10);
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            }
        }
    }
}
