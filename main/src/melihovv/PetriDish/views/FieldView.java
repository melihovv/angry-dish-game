package melihovv.PetriDish.views;

import melihovv.PetriDish.events.FieldObjectListener;
import melihovv.PetriDish.fieldObjects.FieldObject;
import melihovv.PetriDish.main.PetriDishGame;
import melihovv.PetriDish.views.FieldObjectViews.FieldObjectView;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import melihovv.library.ImageBackground;
import melihovv.library.Graphics2D;

/**
 * The class represents the appearance of a game field.
 */
public class FieldView implements FieldObjectListener {
    /**
     * The path to background image.
     */
    private static final String BACKGROUND_PATH = "background.jpg";


    /*
     * The width of the background image.
     */
    private static final int BACKGROUND_WIDTH = 5000;

    /*
     * The height of the background image.
     */
    private static final int BACKGROUND_HEIGHT = 3750;

    /**
     * The game field background.
     */
    private ImageBackground _background;

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
                    PetriDishGame.getScreenWidth(),
                    PetriDishGame.getScreenHeight()
            );
            _background.setTotalClip(BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
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
    public ImageBackground getBackground() {
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
