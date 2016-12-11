package melihovv.PetriDish.main;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * The class which functions is asking and saving player's name.n
 */
public class PlayerNameDialog {
    /**
     * The default player name. If user doesn't specify his own name or leaves
     * an input field empty, the default player name will be set.
     */
    private static final String DEFAULT_PLAYER_NAME = "Red Angry";

    /**
     * The message to show within dialog.
     */
    private static final String DIALOG_MESSAGE = "Введите имя пользователя:";

    /**
     * The title of dialog.
     */
    private static final String DIALOG_TITLE = "Выбор имени пользователя";

    /**
     * The name of player.
     */
    private String _playerName;

    /**
     * The basic constructor for class members initialization.
     */
    public PlayerNameDialog() {

        _playerName = DEFAULT_PLAYER_NAME;
    }

    /**
     * Asks player's name and saves it.
     */
    public void askUserName() {

        /* Getting user name */
        JFrame frame = new JFrame();
        JOptionPane dialog = new JOptionPane();
        _playerName = (String) dialog.showInputDialog(
                frame,
                DIALOG_MESSAGE,
                DIALOG_TITLE,
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                DEFAULT_PLAYER_NAME
        );

        /* If user left input field empty */
        if (_playerName.isEmpty()) {

            _playerName = DEFAULT_PLAYER_NAME;
        }
    }


    /**
     * The getter for _playerName class member.
     *
     * @return value of _playerName.
     */
    public String getPlayerName() {
        return _playerName;
    }
}
