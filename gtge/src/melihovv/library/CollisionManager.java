package melihovv.library;

import melihovv.PetriDish.collisions.BirdToPigCollision;
import melihovv.PetriDish.collisions.BirdToWoodenObstacleCollision;
import melihovv.PetriDish.collisions.PlayerToComputerBirdCollision;

public class CollisionManager extends
        com.golden.gamedev.object.CollisionManager {

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

    @Override
    public void setCollisionGroup(
            com.golden.gamedev.object.SpriteGroup spriteGroup,
            com.golden.gamedev.object.SpriteGroup spriteGroup1) {

        super.setCollisionGroup(spriteGroup, spriteGroup1);
    }

    @Override
    public void checkCollision() {
        _birdToPigCollision.checkCollision();
        _birdToWoodenObstacleCollision.checkCollision();
        _playerToComputerBirdCollision.checkCollision();
    }
}
