package melihovv.PetriDish;

import com.golden.gamedev.GameLoader;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GameLoader game = new GameLoader();
        game.setup(new Game(), new Dimension(640, 480), false);
        game.start();
    }
}
