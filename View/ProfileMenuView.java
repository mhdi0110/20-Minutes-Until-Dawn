package io.github.some_example_name.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.some_example_name.Controller.MainMenuController;
import io.github.some_example_name.Controller.ProfileMenuController;
import io.github.some_example_name.Main;
import io.github.some_example_name.Model.App;
import io.github.some_example_name.Model.GameAssetsManager;

import java.util.ArrayList;

public class ProfileMenuView implements Screen {
    private Stage stage;
    private Table table;
    private BitmapFont font;
    private Texture backgroundTexture;
    private Image backgroundImage;
    private String errorMessage;
    private Label profileTitle;
    private ProfileMenuController controller;
    private TextButton usernameChangeButton;
    private TextButton passwordChangeButton;
    private TextButton avatarChangeButton;
    private TextButton deleteUserButton;
    private TextButton backButton;
    private boolean isInUsernameChange;
    private boolean isInPasswordChange;
    private boolean isInAvatarChange;
    private TextField usernameBox;
    private TextField passwordBox;
    private TextButton usernameButton;
    private TextButton passwordButton;
    private ArrayList<Texture> avatarsList;
    private TextField avatarBox;
    private TextButton avatarButton;
    public ProfileMenuView(ProfileMenuController controller, Skin skin) {
        this.controller = controller;
        this.backgroundTexture = new Texture(Gdx.files.internal("backgrounds/MainMenuBG.png"));
        this.backgroundImage = new Image(backgroundTexture);
        this.table = new Table();
        this.font = new BitmapFont();
        this.profileTitle = new Label("Profile", skin);
        this.profileTitle.setFontScale(0.5f);
        this.controller.setView(this);
        this.usernameChangeButton = new TextButton("Change Username", skin);
        this.passwordChangeButton = new TextButton("Change Password", skin);
        this.avatarChangeButton = new TextButton("Change Avatar", skin);
        this.deleteUserButton = new TextButton("Delete User", skin);
        this.backButton = new TextButton("back", skin, "no-box");
        this.usernameButton = new TextButton("Change Username", skin);
        this.passwordButton = new TextButton("Change Password", skin);
        this.usernameBox = new TextField("", skin);
        this.passwordBox = new TextField("", skin);
        this.isInUsernameChange = false;
        this.isInPasswordChange = false;
        this.isInAvatarChange = false;
        this.avatarsList = getAvatarsTexture();
        this.avatarBox = new TextField("", skin);
        this.avatarButton = new TextButton("Change Avatar", skin);

    }

    @Override
    public void show() {
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        this.profileTitle.setFontScale(1.9f);
        this.font.setColor(Color.WHITE);
        this.usernameChangeButton.setColor(Color.BLACK);
        this.passwordChangeButton.setColor(Color.BLACK);
        this.avatarChangeButton.setColor(Color.BLACK);
        this.deleteUserButton.setColor(Color.BLACK);
        this.usernameButton.setColor(Color.BLACK);
        this.passwordButton.setColor(Color.BLACK);
        this.avatarButton.setColor(Color.BLACK);
        table.setFillParent(true);
        table.clear();
        table.reset();
        table.center();
        if (isInUsernameChange) {
            usernameBox.setMessageText("Enter your username");
            usernameBox.setBlinkTime(0.6f);
            table.add(usernameBox).width(600).padBottom(32f).height(80);
            table.row();
            table.add(usernameButton).width(600).padBottom(32f).height(80);
            table.row();
            table.add(backButton).width(600).padBottom(32f).height(60);
            table.row();
        } else if (isInPasswordChange) {
            passwordBox.setMessageText("Enter your password");
            passwordBox.setBlinkTime(0.6f);
            passwordBox.setPasswordMode(true);
            passwordBox.setPasswordCharacter('•');
            table.add(passwordBox).width(600).padBottom(32f).height(80);
            table.row();
            table.add(passwordButton).width(600).padBottom(32f).height(80);
            table.row();
            table.add(backButton).width(600).padBottom(32f).height(60);
            table.row();
        } else if (isInAvatarChange) {
            table.add(avatarBox).width(600).padBottom(32f).height(80);
            table.row();
            table.add(avatarButton).width(600).padBottom(32f).height(80);
            table.row();
        } else {
            table.add(profileTitle).padBottom(20f);
            table.row();
            table.add(usernameChangeButton).width(600).padBottom(32f).height(80);
            table.row();
            table.add(passwordChangeButton).width(600).padBottom(32f).height(80);
            table.row();
            table.add(avatarChangeButton).width(600).padBottom(32f).height(80);
            table.row();
            table.add(deleteUserButton).width(600).padBottom(32f).height(80);
            table.row();
            table.add(backButton).width(600).padBottom(32f).height(60);
            table.row();
        }
        stage.addActor(backgroundImage);
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1f, 1f, 1f, 1f);

        stage.act(delta);
        stage.draw();
        Main.getBatch().begin();
        if (isInAvatarChange) {
            for (int i = 1; i <= avatarsList.size(); i++) {
                Texture tex = avatarsList.get(i - 1);

                Main.getBatch().draw(tex, 200 * (i - 1), 1000, 200, 200);
                font.draw(Main.getBatch(), i + "", 200 * (i - 1) + 90, 980);
            }
        }
        font.getData().setScale(1.7f);
        if (errorMessage != null && !errorMessage.isEmpty()) {
            font.draw(Main.getBatch(), errorMessage, 850, Gdx.graphics.getHeight() - 50);
        }
        Main.getBatch().end();
        controller.handleSignUpButtons();
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

    public void setInUsernameChange(boolean inUsernameChange) {
        isInUsernameChange = inUsernameChange;
        show();
    }

    public void setInPasswordChange(boolean inPasswordChange) {
        isInPasswordChange = inPasswordChange;
        show();
    }

    public void setInAvatarChange(boolean inAvatarChange) {
        isInAvatarChange = inAvatarChange;
        show();
    }

    public TextButton getUsernameChangeButton() {
        return usernameChangeButton;
    }

    public TextButton getPasswordChangeButton() {
        return passwordChangeButton;
    }

    public TextButton getAvatarChangeButton() {
        return avatarChangeButton;
    }

    public TextButton getDeleteUserButton() {
        return deleteUserButton;
    }

    public TextButton getBackButton() {
        return backButton;
    }

    public TextButton getPasswordButton() {
        return passwordButton;
    }

    public TextButton getUsernameButton() {
        return usernameButton;
    }

    public TextField getPasswordBox() {
        return passwordBox;
    }

    public TextField getUsernameBox() {
        return usernameBox;
    }

    public boolean isInUsernameChange() {
        return isInUsernameChange;
    }

    public boolean isInPasswordChange() {
        return isInPasswordChange;
    }

    public boolean isInAvatarChange() {
        return isInAvatarChange;
    }

    public TextButton getAvatarButton() {
        return avatarButton;
    }

    public TextField getAvatarBox() {
        return avatarBox;
    }

    public ArrayList<Texture> getAvatarsList() {
        return avatarsList;
    }

    public ArrayList<Texture> getAvatarsTexture() {
        ArrayList<Texture> textures = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            textures.add(new Texture(Gdx.files.internal("avatar/avatar" + i + ".png")));
        }
        return textures;
    }
    public void printSelectedAvatar(Texture selectedAvatar) {
        stage.addActor(new Image(selectedAvatar));
    }
}
