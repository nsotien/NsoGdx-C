package com.monkey.nso.lib;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.monkey.nso.NSO;

public class MenuCustom {

    private Stage stage;
    private Skin skin;
    private Viewport viewport;
    public boolean isVisible = false;

    public MenuCustom() {
        init();
    }

    public void init() {
        viewport = new ScreenViewport();
        stage = new Stage(viewport);
        viewport.apply();
        skin = new Skin(Gdx.files.internal("Nso/"+"skin.json"));
        Gdx.input.setInputProcessor(stage);
        Window root = new Window("Menu", skin, "main");
        root.setFillParent(true);
        stage.addActor(root);
        root.top();

        Label titleLabel = new Label("Main Menu", skin);
        root.add(titleLabel).colspan(2).pad(20 + Gdx.graphics.getSafeInsetTop());
        root.row();


        final TextField keyBoardCodesTF = new TextField("default", skin);
        keyBoardCodesTF.setMessageText("Key code");
        root.add(new Label("Key code", skin)).pad(5);
        root.add(keyBoardCodesTF).width(230).pad(5);
        root.row();

        final TextField activeKeyTF = new TextField("default", skin);
        activeKeyTF.setMessageText("Activation key");
        activeKeyTF.setTextFieldFilter(new TextField.TextFieldFilter.DigitsOnlyFilter());
        root.add(new Label("Activation key", skin)).pad(5);
        root.add(activeKeyTF).width(150).pad(5);
        root.row();

        final TextField delayTF = new TextField("default", skin);
        delayTF.setMessageText("Sleep");
        delayTF.setTextFieldFilter(new TextField.TextFieldFilter.DigitsOnlyFilter());
        root.add(new Label("Sleep", skin)).pad(5);
        root.add(delayTF).width(150).pad(5);
        root.row();
        TextButton saveButton = new TextButton("Save", skin);
        TextButton exitButton = new TextButton("Exit", skin);
        Table buttonTable = new Table();
        buttonTable.add(saveButton).pad(10).right();
        buttonTable.add(exitButton).pad(10).left();
        root.add(buttonTable).colspan(2).padTop(20).right().expandY().top();
        saveButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                try {
//                    String[] keyboardCodes = keyBoardCodesTF.getText().split(",");
//                    for (String code : keyboardCodes) {
//                        String[] clickCode = code.split(":");
//                        if (clickCode.length != 2 || notNumber(clickCode[0]) || notNumber(clickCode[1])) {
//                            showAlert("Warning", "Invalid key code");
//                            return;
//                        }
//                    }
//
//                    if (notNumber(activeKeyTF.getText())) {
//                        showAlert("Warning", "Invalid activation key");
//                        return;
//                    }
//
//                    _config.autoClickConfig.keyBoardCodes = keyBoardCodesTF.getText();
//                    _config.autoClickConfig.activeKey = Integer.parseInt(activeKeyTF.getText());
//                    _config.autoClickConfig.delay = Integer.parseInt(delayTF.getText());
//                    _config.saveConfig();
                } catch (Exception e) {
                }
                hide();
            }
        });

        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                hide();
            }
        });
    }

    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    private void showAlert(String title, String message) {
        Dialog dialog = new Dialog(title, skin);
        dialog.text(message);
        dialog.button("OK", true);
        dialog.align(Align.center);
        dialog.pack();
        dialog.show(stage);
    }

    public void show() {
        isVisible = true;
        Gdx.input.setInputProcessor(stage);
    }

    public void hide() {
        isVisible = false;
        Gdx.input.setInputProcessor(NSO.instance.inputMultiplexer);
    }


    public void render() {
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
