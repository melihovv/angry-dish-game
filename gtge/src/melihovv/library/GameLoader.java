package melihovv.library;

import com.golden.gamedev.*;

import java.awt.Dimension;

public class GameLoader {

    private com.golden.gamedev.GameLoader _loader;

    public GameLoader() {
        _loader = new com.golden.gamedev.GameLoader();
    }

    public void setup(GameEngine game, Dimension windowSize, boolean fullscreen) {
        _loader.setup(game, windowSize, fullscreen);
    }

    public void start() {
        _loader.start();
    }
}
