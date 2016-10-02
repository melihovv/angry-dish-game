package melihovv.PetriDish.main;

import com.golden.gamedev.object.SpriteGroup;
import melihovv.PetriDish.events.FieldObjectListener;
import melihovv.PetriDish.fieldObjects.Bird;
import melihovv.PetriDish.fieldObjects.FieldObject;
import melihovv.PetriDish.fieldObjects.Pig;
import melihovv.PetriDish.fieldObjects.WoodenObstacle;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The class represents game field.
 * Singleton class.
 */
public class Field {
    /**
     * The width of the field.Depends on background image size.
     */
    private static final int FIELD_WIDTH = 5000;

    /**
     * The height of the field.Depends on background image size.
     */
    private static final int FIELD_HEIGHT = 3750;

    /**
     * The only one instance of the class due to its singleton pattern.
     */
    private static Field _instance;

    /**
     * The set of field objects.
     */
    private List<FieldObject> _fieldObjects = new ArrayList<>();

    /**
     * The set of field listeners.
     */
    private List<FieldObjectListener> _fieldObjectListeners = new ArrayList<>();

    /**
     * The collision sprite group for pigs(game object type).
     */
    private SpriteGroup _pigsGroup =
            new SpriteGroup("Pig Group");

    /**
     * The collision sprite group for birds(game object type).
     */
    private SpriteGroup _birdsGroup =
            new SpriteGroup("Bird Group");

    /**
     * The collision sprite group for wooden obstacles(game object type).
     */
    private SpriteGroup _woodenObstacles =
            new SpriteGroup("Wooden obstacle Group");

    /**
     * The actual amount of pigs on the field.
     */
    private int _pigsCounter;

    /**
     * The getter for _instance class member.
     *
     * @return value of _instance.
     */
    public static Field getInstance() {
        if (_instance == null) {
            _instance = new Field();
        }

        return _instance;
    }

    /**
     * The getter for FIELD_WIDTH class member.
     *
     * @return value of FIELD_WIDTH.
     */
    public static int getFieldWidth() {
        return FIELD_WIDTH;
    }

    /**
     * The getter for FIELD_HEIGHT class member.
     *
     * @return value of FIELD_HEIGHT.
     */
    public static int getFieldHeight() {
        return FIELD_HEIGHT;
    }

    /**
     * Adds object to the specified field position.
     *
     * @param object   object to add.
     * @param position position of the added object.
     */
    public void addFieldObject(final FieldObject object, final Point position) {
        object.setPosition(position);
        _fieldObjects.add(object);

        if (object instanceof Bird) {
            _birdsGroup.add(object.getFieldObjectView());
        } else if (object instanceof Pig) {
            _pigsGroup.add(object.getFieldObjectView());
            ++_pigsCounter;
        } else if (object instanceof WoodenObstacle) {
            _woodenObstacles.add(object.getFieldObjectView());
        }

        fireObjectAdded(object);
    }

    /**
     * Removes object from the field.
     *
     * @param object object to remove.
     */
    public void removeFieldObject(final FieldObject object) {
        _fieldObjects.remove(object);

        if (object instanceof Bird) {
            _birdsGroup.remove(object.getFieldObjectView());
        } else if (object instanceof Pig) {
            _pigsGroup.remove(object.getFieldObjectView());
        } else if (object instanceof WoodenObstacle) {
            _woodenObstacles.remove(object.getFieldObjectView());
        }

        fireObjectDeleted(object);
    }

    /**
     * Updates field variables.
     *
     * @param elapsedTime time passed after the last update.
     */
    public void update(final long elapsedTime) {
        for (FieldObject object : _fieldObjects) {
            object.update(elapsedTime);
        }
    }

    /**
     * Adds object to a random field position.
     *
     * @param object object to add.
     */
    public void addFieldObjectToRandomPosition(final FieldObject object) {
        Random randomizer = new Random();

        /* Getting random position coordinates */
        int x = randomizer.nextInt(FIELD_WIDTH);
        int y = randomizer.nextInt(FIELD_HEIGHT);

        Point randomPosition = new Point(x, y);

        if (isPositionFree(randomPosition, object)) {
            addFieldObject(object, randomPosition);
        }
    }

    /**
     * Checks if field position is free.
     *
     * @param position position to check.
     * @param object   object which is desired to be added.
     * @return is position free.
     */
    public boolean isPositionFree(
            final Point position,
            final FieldObject object
    ) {
        int x = position.x;
        int y = position.y;
        int halfObjectSize = object.getSize() / 2;

        /* Checking field borders */
        if (x - halfObjectSize < 0
                || x + halfObjectSize >= FIELD_WIDTH
                || y - halfObjectSize < 0
                || y + halfObjectSize >= FIELD_HEIGHT) {
            return false;
        }

        /* Checking overlays with other field objects */
        for (FieldObject fieldObject : _fieldObjects) {
            int x1 = fieldObject.getPosition().x;
            int y1 = fieldObject.getPosition().y;

            double distanceBetweenCenters =
                    Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));

            final double minDistance =
                    (object.getSize() + fieldObject.getSize()) / 2.0;
            if (distanceBetweenCenters <= minDistance) {
                return false;
            }
        }

        return true;
    }

    /**
     * Decreases pigs counter by 1.
     */
    public void decreasePigsCounter() {
        --_pigsCounter;
    }

    /**
     * The getter for _fieldObjects class member.
     *
     * @return value of _fieldObjects.
     */
    public List<FieldObject> getFieldObjects() {
        return _fieldObjects;
    }

    /**
     * The getter for sprite group class members.
     *
     * @param objectsType type of objects in sprite group.
     * @return sprite group of objects with specified type.
     */
    public SpriteGroup getSpriteGroup(final Class objectsType) {
        if (objectsType.equals(Bird.class)) {
            return _birdsGroup;
        } else if (objectsType.equals(Pig.class)) {
            return _pigsGroup;
        } else if (objectsType.equals(WoodenObstacle.class)) {
            return _woodenObstacles;
        } else {
            return null;
        }
    }

    /**
     * The getter for _pigsCounter class member.
     *
     * @return value of _pigsCounter.
     */
    public int getPigsCounter() {
        return _pigsCounter;
    }

    /**
     * Adds field listener.
     *
     * @param objectListener listener to add.
     */
    public void addObjectListener(final FieldObjectListener objectListener) {
        _fieldObjectListeners.add(objectListener);
    }

    /**
     * Removes field listener.
     *
     * @param objectListener listener to remove.
     */
    public void deleteObjectListener(final FieldObjectListener objectListener) {
        _fieldObjectListeners.remove(objectListener);
    }

    /**
     * Fires the event of adding field object to all field listeners.
     *
     * @param fieldObject added field object.
     */
    private void fireObjectAdded(final FieldObject fieldObject) {
        for (FieldObjectListener objectListener : _fieldObjectListeners) {
            objectListener.fieldObjectAdded(fieldObject);
        }
    }

    /**
     * Fires the event of deleting field object to all field listeners.
     *
     * @param fieldObject deleted field object.
     */
    private void fireObjectDeleted(final FieldObject fieldObject) {
        for (FieldObjectListener objectListener : _fieldObjectListeners) {
            objectListener.fieldObjectDeleted(fieldObject);
        }
    }
}
