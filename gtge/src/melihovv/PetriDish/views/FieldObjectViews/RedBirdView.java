package melihovv.PetriDish.views.FieldObjectViews;

import melihovv.PetriDish.fieldObjects.FieldObject;
import melihovv.PetriDish.fieldObjects.RedBird;
import java.awt.Color;
import java.awt.Font;

import melihovv.library.Graphics2D;
import melihovv.library.SystemFont;

/**
 * The class represents the appearance of a red bird.
 */
public class RedBirdView extends ActiveFieldObjectView {

    /**
     * Oval size to start paint player name.
     */
    private static final int START_OVAL_SIZE = 9;

    /**
     * X-axis coordinate offset of player name.
     */
    private static final int X_OFFSET = 23;

    /**
     * Y-axis coordinate offset of player name.
     */
    private static final int Y_OFFSET = 40;

    /**
     * The path to the bird image.
     */
    private static final String IMAGE_PATH = "heroes/birds/main_hero.png";

    /**
     * The basic constructor for class members initialization.
     *
     * @param fieldObject object for the object view.
     */
    public RedBirdView(final FieldObject fieldObject) {
        super(fieldObject);
    }

    /**
     * Creates field object view for red bird - main player
     * with size oval and player name.
     *
     * @return object view.
     */
    @Override
    public Graphics2D createObjectView() {

        Graphics2D objectView = super.createObjectView();

        /* Setting graphics */
        objectView.setColor(Color.RED);

        final int fontSize = 10;
        SystemFont font = new SystemFont("Lucida", Font.ITALIC, 10, Color.RED);

        RedBird player = ((RedBird) getFieldObject());
        String playerName = player.getPlayerName();
        int playerSize = player.getSize();
        int ovalSize = getOvalSize();

        /* Painting player name */
        if (ovalSize > START_OVAL_SIZE) {

            font.drawString(
                    objectView,
                    playerName,
                    (playerSize / 2) - X_OFFSET,
                    (playerSize / 2) + Y_OFFSET
            );
        }

        return objectView;
    }

    /**
     * Getter for the IMAGE_PATH class member.
     *
     * @return value of IMAGE_PATH.
     */
    @Override
    public String getImagePath() {
        return IMAGE_PATH;
    }
}
