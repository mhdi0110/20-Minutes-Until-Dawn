package io.github.some_example_name.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.some_example_name.Controller.LoginMenuController;
import io.github.some_example_name.Main;
import io.github.some_example_name.Model.App;

public class LoginMenuView implements Screen {
    private Stage stage;
    private Label loginLabel;
    private LoginMenuController controller;
    private String errorMessage;
    private BitmapFont font;
    private Texture backgroundTexture;
    private Image backgroundImage;
    private Table table;
    private TextField usernameBox;
    private TextField passwordBox;
    private TextButton loginButton;
    private TextButton signUpButton;
    private TextButton forgetPasswordButton;
    private TextField securityQuestionBox;
    private TextField securityAnswerBox;
    private TextButton securityAnswerButton;
    private TextButton exitButton;
    private TextField newPasswordBox;
    private boolean isInForgetPassword;

    public LoginMenuView(LoginMenuController controller, Skin skin) {
        App.s();
        this.controller = controller;
        this.stage = new Stage();
        this.font = new BitmapFont();
        this.table = new Table();
        this.loginLabel = new Label("Login", skin);
        this.usernameBox = new TextField("", skin);
        this.passwordBox = new TextField("", skin);
        this.loginButton = new TextButton("Login", skin);
        this.signUpButton = new TextButton("Don't have any account?", skin, "no-box");
        this.forgetPasswordButton = new TextButton("Forget Password", skin, "no-box");
        this.securityAnswerBox = new TextField("", skin);
        this.securityQuestionBox = new TextField("", skin);
        this.securityAnswerButton = new TextButton("Submit", skin);
        this.newPasswordBox = new TextField("", skin);
        this.exitButton = new TextButton("Exit", skin, "no-box");
        this.backgroundTexture = new Texture(Gdx.files.internal("backgrounds/MainMenuBG.png"));
        this.backgroundImage = new Image(backgroundTexture);
        this.controller.setView(this);
        this.isInForgetPassword = false;
    }

    @Override
    public void show() {
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        table.setFillParent(true);
        loginButton.setColor(Color.BLACK);
        securityAnswerButton.setColor(Color.BLACK);
        usernameBox.setMessageText("Enter your username");
        usernameBox.setBlinkTime(0.6f);
        passwordBox.setMessageText("Enter your password");
        passwordBox.setBlinkTime(0.6f);
        securityAnswerBox.setMessageText("Enter your answer");
        securityAnswerBox.setBlinkTime(0.6f);
        newPasswordBox.setMessageText("Enter your new password");
        newPasswordBox.setBlinkTime(0.6f);
        passwordBox.setPasswordMode(true);
        passwordBox.setPasswordCharacter('•');
        newPasswordBox.setPasswordMode(true);
        newPasswordBox.setPasswordCharacter('•');
        loginLabel.setFontScale(1.9f);
        table.clear();
        table.reset();
        table.center();
        if(!isInForgetPassword) {
            table.add(loginLabel);
            table.row();
            table.add(usernameBox).width(600).padBottom(32f).height(60);
            table.row();
            table.add(passwordBox).width(600).padBottom(32f).height(60);
            table.row();
            table.add(loginButton).width(600).padBottom(32f).height(60);
            table.row();
            table.add(signUpButton).width(600).padBottom(32f).padTop(10f).height(60);
            table.row();
            table.add(forgetPasswordButton).width(600).padBottom(32f).height(0);
            table.row();
        }
        else {
            securityQuestionBox.setDisabled(true);
            table.add(securityQuestionBox).width(600).padBottom(32f).height(60);
            table.row();
            table.add(securityAnswerBox).width(600).padBottom(32f).height(60);
            table.row();
            table.add(newPasswordBox).width(600).padBottom(32f).height(60);
            table.row();
            table.add(securityAnswerButton).width(600).padBottom(32f).height(60);
            table.row();
            table.add(exitButton).width(600).padBottom(32f).height(60);
            table.row();
        }
        stage.addActor(backgroundImage);
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0f, 0.1f, 0.2f, 1f);

        stage.act(delta);
        stage.draw();
        font.getData().setScale(1.7f);
        if (errorMessage != null && !errorMessage.isEmpty()) {
            Main.getBatch().begin();
            font.draw(Main.getBatch(), errorMessage, 850, Gdx.graphics.getHeight() - 50);
            Main.getBatch().end();
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    errorMessage = null;
                }
            }, 2);
        }
        controller.handleLoginButtons();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public TextField getUsernameBox() {
        return usernameBox;
    }

    public TextField getPasswordBox() {
        return passwordBox;
    }

    public TextButton getLoginButton() {
        return loginButton;
    }

    public TextButton getSignUpButton() {
        return signUpButton;
    }

    public TextButton getForgetPasswordButton() {
        return forgetPasswordButton;
    }

    public void setInForgetPassword(boolean inForgetPassword) {
        isInForgetPassword = inForgetPassword;
        show();
    }

    public TextButton getSecurityAnswerButton() {
        return securityAnswerButton;
    }

    public TextField getSecurityAnswerBox() {
        return securityAnswerBox;
    }

    public TextField getSecurityQuestionBox() {
        return securityQuestionBox;
    }

    public TextField getNewPasswordBox() {
        return newPasswordBox;
    }

    public TextButton getExitButton() {
        return exitButton;
    }
}
