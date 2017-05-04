package melihovv.library;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class GameObject extends ApplicationAdapter implements Screen {
    private OrthographicCamera _camera;

    static Camera _currentCamera;

    private SpriteBatch _batch;

    private Graphics2D _ctx;

    private Stage stage;
    private Game _game;

    public GameObject(Game game)
    {
        _game = game;
        stage = new Stage(new ScreenViewport());

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

    public void create() {

    }

    public void initResources() {

    }

    public void update(long elapsedTime) {

    }

    public void renderInContext(Graphics2D g) {

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();

//        _camera.update();
//        Gdx.gl.glClearColor(1, 0, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//        update((long) (Gdx.graphics.getDeltaTime() * 1000.0));
//
//        _ctx.getBatch().setProjectionMatrix(_camera.combined);
//
//        _ctx.begin();
//        renderInContext(_ctx);
//        _ctx.end();
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

    public void finish() {
        dispose();
    }

    @Override
    public void dispose() {
        stage.dispose();
        TextureManager.disposeTextures();
    }

    public int getMouseX() {
        return Gdx.input.getX() - Gdx.graphics.getWidth() / 2;
    }

    public int getMouseY() {
        return (Gdx.graphics.getHeight() / 2 - Gdx.input.getY());
    }

    public boolean isLeftMouseKeyPressed(){
        return Gdx.input.isKeyPressed(Input.Keys.LEFT);
    }

}
