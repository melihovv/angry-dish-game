package melihovv.library;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public abstract class GameEngine extends Game {

    static public Skin gameSkin;
    public int nextGameID = 0;

    public void create () {
        gameSkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
    }

    public void render () {
        super.render();
    }

    public void dispose () {
    }

    public abstract GameObject getGame(final int gameID);
}
