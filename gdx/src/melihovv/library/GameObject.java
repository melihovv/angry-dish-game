package melihovv.library;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameObject extends ApplicationAdapter {
    private OrthographicCamera _camera;

    static Camera _currentCamera;

    private SpriteBatch _batch;

    private Graphics2D _ctx;

    @Override
    public void create() {
        _camera = new OrthographicCamera(
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight()
        );
        _camera.position.set(
                Gdx.graphics.getWidth() / 2,
                Gdx.graphics.getHeight() / 2,
                0
        );
        _camera.update();
        _currentCamera = _camera;

        _batch = new SpriteBatch();
        _ctx = new Graphics2D(_batch);

        this.initResources();
    }

    public void initResources() {

    }

    public void update(long elapsedTime) {

    }

    @Override
    public void render() {
        _camera.update();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update((long) (Gdx.graphics.getDeltaTime() * 1000.0));

        _ctx.getBatch().setProjectionMatrix(_camera.combined);

        _ctx.begin();
        renderInContext(_ctx);
        _ctx.end();
    }

    public void renderInContext(Graphics2D g) {

    }

    @Override
    public void dispose() {
        TextureManager.disposeTextures();
    }

    public int getMouseX() {
        return Gdx.input.getX() - Gdx.graphics.getWidth() / 2;
    }

    public int getMouseY() {
        return (Gdx.graphics.getHeight() / 2 - Gdx.input.getY());
    }
}
