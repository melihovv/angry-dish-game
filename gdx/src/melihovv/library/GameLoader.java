package melihovv.library;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import java.awt.*;

public class GameLoader {
    private LwjglApplicationConfiguration _config;

    private LwjglApplication _app;

    private GameObject _game;

    public GameLoader() {
        _config = new LwjglApplicationConfiguration();
        _app = null;
    }

    public void setup(GameObject game, Dimension windowSize, boolean fullscreen) {
        _config.width = windowSize.width;
        _config.height = windowSize.height;
        _config.fullscreen = fullscreen;
        _config.foregroundFPS = 60;
        _config.resizable = false;

        _game = game;
    }

    public void start() {
        _app = new LwjglApplication(_game, _config);
    }
}
