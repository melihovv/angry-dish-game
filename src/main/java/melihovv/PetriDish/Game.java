package melihovv.PetriDish;

import java.awt.*;

import com.golden.gamedev.object.*;
import com.golden.gamedev.object.background.*;

public class Game extends com.golden.gamedev.Game {
    protected SpriteGroup _playerGroup;
    protected Sprite _player;
    protected static final int PLAYER_WIDTH = 194;
    protected static final int PLAYER_HEIGHT = 196;

    protected Background _bg;
    protected static final int BG_SPEED = 2;

    protected static final int MARGIN = 20;

    @Override
    public void initResources() {
        _bg = new ColorBackground(Color.WHITE);
        _bg.move(_bg.getWidth() / 2, _bg.getHeight() / 2);

        _playerGroup = new SpriteGroup("Player");
        _player = new Sprite(getImage("player.png"), PLAYER_WIDTH, PLAYER_HEIGHT);
        _playerGroup.add(_player);
    }

    @Override
    public void update(final long elapsedTime) {
        _bg.update(elapsedTime);
        _playerGroup.update(elapsedTime);

        backgroundMovement();
        playerMovement(elapsedTime);
    }

    protected void backgroundMovement() {
        if (_player.getX() + PLAYER_WIDTH >= getWidth() - MARGIN) {
            _player.setX(_player.getOldX());
            _bg.move(BG_SPEED, 0);
        }

        if (_player.getX() <= MARGIN) {
            _player.setX(_player.getOldX());
            _bg.move(-BG_SPEED, 0);
        }

        if (_player.getY() + PLAYER_HEIGHT >= getHeight() - MARGIN) {
            _player.setY(_player.getOldY());
            _bg.move(0, BG_SPEED);
        }

        if (_player.getY() <= MARGIN) {
            _player.setY(_player.getOldY());
            _bg.move(0, -BG_SPEED);
        }
    }

    protected void playerMovement(final long elapsedTime) {
        _player.moveTo(
                elapsedTime,
                getMouseX() - PLAYER_WIDTH / 2,
                getMouseY() - PLAYER_HEIGHT / 2,
                0.4
        );
    }

    @Override
    public void render(Graphics2D g) {
        _bg.render(g);
        _playerGroup.render(g);
    }
}
