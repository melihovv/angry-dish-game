package melihovv.PetriDish.views;

import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.background.ImageBackground;
import melihovv.PetriDish.events.FieldObjectListener;
import melihovv.PetriDish.factories.FieldObjectsViewFactory;
import melihovv.PetriDish.fieldObjects.FieldObject;
import melihovv.PetriDish.main.PetriDishGame;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The class represents the appearance of a game field.
 */
public class FieldView implements FieldObjectListener {
    /**
     * The path to background image.
     */
    private static final String BACKGROUND_PATH =
            "src/main/resources/background.jpg";

    /**
     * The game field background.
     */
    private Background _background;

    /**
     * The set of field object views.
     */
    private List<FieldObjectView> _fieldObjectViews = new ArrayList<>();

    /**
     * The factory to create field object views.
     */
    private FieldObjectsViewFactory _fieldObjectViewFactory =
            new FieldObjectsViewFactory();

    /**
     * The basic constructor which sets up the background.
     */
    public FieldView() {
        try {
            _background = new ImageBackground(
                    ImageIO.read(new File(BACKGROUND_PATH))
            );
            _background.setClip(
                    0,
                    0,
                    PetriDishGame.getScreenWidth(),
                    PetriDishGame.getScreenHeight()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Renders field view objects.
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
     * @return value of _background.
     */
    public Background getBackground() {
        return _background;
    }

    /**
     * The reaction on field object added event.
     * @param fieldObject added field object.
     */
    @Override
    public void fieldObjectAdded(final FieldObject fieldObject) {
        FieldObjectView fieldObjectView =
                _fieldObjectViewFactory.createFieldObjectView(fieldObject);
        fieldObjectView.setBackground(_background);
        _fieldObjectViews.add(fieldObjectView);
    }

    /**
     * The reaction on field object deleted event.
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
