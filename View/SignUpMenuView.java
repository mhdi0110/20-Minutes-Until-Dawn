package io.github.some_example_name.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.some_example_name.Controller.SignUpController;
import io.github.some_example_name.Main;
import io.github.some_example_name.Model.GameAssetsManager;

public class SignUpMenuView implements Screen {
    private SignUpController controller;
    private Stage stage;
    private Table table;
    private Label signupLabel;
    private TextField usernameBox;
    private TextField passwordBox;
    private TextButton textButton;
    private TextButton loginButton;
    private TextButton loginAsGuestButton;
    private SelectBox<String> selectBox;
    private TextField securityAnswerBox;
    private String errorMessage;
    private BitmapFont font;
    private Texture backgroundTexture;
    private Image backgroundImage;

    public SignUpMenuView(SignUpController controller, Skin skin) {
        this.controller = controller;
        this.textButton = new TextButton("Sign Up", skin);
        this.loginButton = new TextButton("Login", skin, "no-box");
        this.loginAsGuestButton = new TextButton("login as guest", skin, "no-box");
        this.signupLabel = new Label("Sign Up", skin);
        this.usernameBox = new TextField("", skin);
        this.passwordBox = new TextField("", skin);
        this.securityAnswerBox = new TextField("", skin);
        this.controller.setView(this);
        this.font = new BitmapFont();
        this.backgroundTexture = new Texture(Gdx.files.internal("backgrounds/MainMenuBG.png"));
        this.backgroundImage = new Image(backgroundTexture);
        String[] questions = {"1.What was the name of your first school?\n",
            "2.What was the name of your first teacher?\n",
            "3.How many siblings do you have?",
            "4.What is your favorite sports team?",
            "5.What is your favorite meal to cook?",
            "6.What was the first concert you attended?",
            "7.What was your childhood nickname?"};
        this.selectBox = new SelectBox<>(GameAssetsManager.getSkin());
        this.selectBox.setItems(questions);
    }

    @Override
    public void show() {
        if (stage != null) {
            stage.dispose();
        }
        this.stage = new Stage(new ScreenViewport());
        this.table = new Table();
        Gdx.input.setInputProcessor(stage);
        table.setFillParent(true);
        table.center();
        selectBox.setColor(Color.BLACK);
        securityAnswerBox.setColor(Color.BLACK);

        securityAnswerBox.setMessageText("Your answer");
        textButton.setColor(Color.BLACK);
        usernameBox.setMessageText("Enter your username");
        usernameBox.setBlinkTime(0.6f);
        passwordBox.setMessageText("Enter your password");
        passwordBox.setBlinkTime(0.6f);
        signupLabel.setFontScale(1.9f);
        passwordBox.setPasswordMode(true);
        passwordBox.setPasswordCharacter('•');

        table.add(signupLabel).padBottom(20f);
        table.row();
        table.add(usernameBox).width(600).padBottom(32f).height(60);
        table.row();
        table.add(passwordBox).width(600).padBottom(32f).height(60);
        table.row();
        table.add(selectBox).width(600).padBottom(32f).height(60);
        table.row();
        table.add(securityAnswerBox).width(600).padBottom(32f).height(60);
        table.row();
        table.add(textButton).width(300).padBottom(32f).height(60f);
        table.row();
        table.add(loginAsGuestButton).width(600).padBottom(32f).padTop(30).height(0);
        table.row();
        table.add(loginButton).width(300).height(60f).padTop(10f);
        table.row();


        stage.addActor(backgroundImage);
        stage.addActor(table);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0f, 0.1f, 0.2f, 1f);

        stage.act(v);
        stage.draw();
        font.getData().setScale(1.7f);

        if (errorMessage != null && !errorMessage.isEmpty()) {
            Main.getBatch().begin();
            font.draw(Main.getBatch(), errorMessage, 850, Gdx.graphics.getHeight() - 50);
            Main.getBatch().end();
        }
        controller.handleSignUpButtons();
    }

    @Override
    public void resize(int i, int i1) {

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

    public TextField getUsernameBox() {
        return usernameBox;
    }

    public TextButton getTextButton() {
        return textButton;
    }

    public TextField getPasswordBox() {
        return passwordBox;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public TextButton getLoginButton() {
        return loginButton;
    }

    public SelectBox<String> getSelectBox() {
        return selectBox;
    }

    public TextField getSecurityAnswerBox() {
        return securityAnswerBox;
    }

    public TextButton getLoginAsGuestButton() {
        return loginAsGuestButton;
    }
}
