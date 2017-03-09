package melihovv.library;

import com.golden.gamedev.GameEngine;

public class GameObject extends com.golden.gamedev.GameObject {

    public GameObject(GameEngine gameEngine) {
        super(gameEngine);
    }

    @Override
    public void initResources() {

    }

    @Override
    public void update(long l) {

    }

    @Override
    public void render(java.awt.Graphics2D graphics2D) {

        melihovv.library.Graphics2D context
                = new melihovv.library.Graphics2D(graphics2D);
        renderInContext(context);
    }

    public void renderInContext(Graphics2D g) {

    }

    @Override
    public int getMouseX() {
        return super.getMouseX();
    }

    @Override
    public int getMouseY() {
        return super.getMouseY();
    }
}
