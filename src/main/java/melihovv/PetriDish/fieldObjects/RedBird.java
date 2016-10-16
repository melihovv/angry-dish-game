package melihovv.PetriDish.fieldObjects;

import melihovv.PetriDish.factories.FieldObjectsFactory;

/**
 * The class represents main game character controlled by a player.
 */
public class RedBird extends Bird {
    /**
     * The size of the bird.
     */
    private static final int DEFAULT_SIZE = 64;

    /**
     * The amount of eaten pigs.
     */
    private int _totalAmountOfEatenPigs;

    /**
     * The basic constructor for class members initialization.
     */
    public RedBird() {
        super();
        setSize(DEFAULT_SIZE);
        setFieldObjectView(FieldObjectsFactory.createFieldObjectView(this));
    }

    /**
     * Overrides parent method by calling it and then increasing internal
     * counter of eaten pigs.
     *
     * @param object object to eat.
     */
    @Override
    public void eatPig(final FieldObject object) {
        super.eatPig(object);
        ++_totalAmountOfEatenPigs;
    }

    /**
     * Fights computer controlled birds.
     *
     * @param enemyBird bird to fight.
     */
    public void fight(final GreenBird enemyBird) {

        int enemyEatenObjectsCount = enemyBird.getEatenObjects().size();
        int playerEatenObjectsCount = getEatenObjects().size();

        if (playerEatenObjectsCount > enemyEatenObjectsCount) {

            eat(enemyBird);
            fireFoughtComputerBird();

        } else if (playerEatenObjectsCount < enemyEatenObjectsCount) {

            fireDied();
        }
    }

    /**
     * The getter for _totalAmountOfEatenPigs class member.
     *
     * @return value of _totalAmountOfEatenPigs.
     */
    public int getTotalAmountOfEatenPigs() {
        return _totalAmountOfEatenPigs;
    }
}
