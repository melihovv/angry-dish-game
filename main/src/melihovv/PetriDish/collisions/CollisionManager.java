package melihovv.PetriDish.collisions;

import melihovv.library.SpriteGroup;

public class CollisionManager {

    private BirdToPigCollision _birdToPigCollision;
    private BirdToWoodenObstacleCollision _birdToWoodenObstacleCollision;
    private PlayerToComputerBirdCollision _playerToComputerBirdCollision;

    public CollisionManager(SpriteGroup birdsGroup,
                            SpriteGroup pigsGroup,
                            SpriteGroup mainPlayerGroup,
                            SpriteGroup woodenObstaclesGroup) {

        _birdToPigCollision = new BirdToPigCollision(
                birdsGroup,
                pigsGroup
        );

        _birdToWoodenObstacleCollision = new BirdToWoodenObstacleCollision(
                birdsGroup,
                woodenObstaclesGroup
        );

        _playerToComputerBirdCollision = new PlayerToComputerBirdCollision(
                mainPlayerGroup,
                birdsGroup
        );
    }


    public void checkCollision() {
        _birdToPigCollision.checkCollision();
        _birdToWoodenObstacleCollision.checkCollision();
        _playerToComputerBirdCollision.checkCollision();
    }
}
