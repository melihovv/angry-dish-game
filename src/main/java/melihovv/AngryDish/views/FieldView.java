package melihovv.AngryDish.views;

import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.background.ImageBackground;
import melihovv.AngryDish.events.FieldObjectListener;
import melihovv.AngryDish.fieldObjects.FieldObject;
import melihovv.AngryDish.main.AngryDishGame;
import melihovv.AngryDish.views.FieldObjectViews.FieldObjectView;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * The class represents the appearance of a game field.
 */
public class FieldView implements FieldObjectListener {
    /**
     * The path to background image.
     */
    private static final String BACKGROUND_PATH = "background.jpg";

    /**
     * The game field background.
     */
    private Background _background;

    /**
     * The set of field object views.
     */
    private List<FieldObjectView> _fieldObjectViews = new ArrayList<>();

    /**
     * The basic constructor which sets up the background.
     */
    public FieldView() {
        try {
            final InputStream stream = getClass()
                    .getClassLoader()
                    .getResourceAsStream(BACKGROUND_PATH);
            _background = new ImageBackground(ImageIO.read(stream));
            _background.setClip(
                    0,
                    0,
                    AngryDishGame.getScreenWidth(),
                    AngryDishGame.getScreenHeight()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Renders field view objects.
     *
     * @param g2d graphics to render on.
     */
    public void render(final Graphics2D g2d) {
        _background.render(g2d);

        for (FieldObjectView objectView : _fieldObjectViews) {
            objectView.render(g2d);
        }
    }

    /**
     * The getter for _background class member.
     *
     * @return value of _background.
     */
    public Background getBackground() {
        return _background;
    }

    /**
     * The reaction on field object added event.
     *
     * @param fieldObject added field object.
     */
    @Override
    public void fieldObjectAdded(final FieldObject fieldObject) {
        FieldObjectView fieldObjectView = fieldObject.getFieldObjectView();
        fieldObjectView.setBackground(_background);
        _fieldObjectViews.add(fieldObjectView);
    }

    /**
     * The reaction on field object deleted event.
     *
     * @param fieldObject deleted field object.
     */
    @Override
    public void fieldObjectDeleted(final FieldObject fieldObject) {
        for (FieldObjectView objectView : _fieldObjectViews) {
            if (fieldObject.equals(objectView.getFieldObject())) {
                _fieldObjectViews.remove(objectView);
                return;
            }
        }
    }
}
