package io.github.some_example_name.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.some_example_name.Controller.SignUpController;
import io.github.some_example_name.Main;

public class SignUpView implements Screen {
    private SignUpController controller;
    private Stage stage;
    private Table table;
    private Label gameTitle;
    private TextField userNameBox;
    private TextField passwordBox;
    private TextButton textButton;
    public SignUpView(SignUpController controller, Skin skin) {
        this.controller = controller;
        this.textButton = new TextButton("", skin);
        this.gameTitle = new Label("20 Minutes Till Dawn", skin);
        this.userNameBox = new TextField("", skin);
        this.passwordBox = new TextField("", skin);
        this.table = new Table();
        this.controller.setView(this);
    }
    @Override
    public void show() {
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        table.setFillParent(true);
        table.center();
        table.add(gameTitle);
        table.row().pad(10, 0, 10, 0);
        table.add(userNameBox).width(600);
        userNameBox.setBlinkTime(0.6f);
        userNameBox.setMessageText("Enter your username");
        table.row().pad(10, 0, 10, 0);
        table.add(passwordBox).width(600);
        passwordBox.setBlinkTime(0.6f);
        passwordBox.setMessageText("Enter your password");
        table.row().pad(10, 0, 10, 0);
        table.add(textButton).width(300);
        textButton.setColor(0f, 0.1f, 0.15f, 0.35f);
        table.row().pad(10, 10, 10, 10);
        stage.addActor(table);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0f, 0.1f, 0.2f, 0);
        Main.getBatch().begin();
        Main.getBatch().end();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
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

    public TextField getUserNameBox() {
        return userNameBox;
    }

    public TextButton getTextButton() {
        return textButton;
    }

    public TextField getPasswordBox() {
        return passwordBox;
    }
}
