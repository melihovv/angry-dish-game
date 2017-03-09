package melihovv.library;

import java.awt.image.BufferedImage;

public class ImageBackground extends
        com.golden.gamedev.object.background.ImageBackground{

    public ImageBackground(BufferedImage bufferedImage) {
        super(bufferedImage);
    }

    @Override
    public  void setClip(int x, int y, int width, int height) {
        super.setClip(x, y, width, height);
    }

    @Override
    public void update(long elapsed) {
        super.update(elapsed);
    }

    public void render(Graphics2D g) {
        super.render(g.get());
    }

    public void setToCenter(Sprite s) {
        super.setToCenter(s);
    }

    @Override
    public double getX() {
        return super.getX();
    }

    @Override
    public double getY() {
        return super.getY();
    }

}
