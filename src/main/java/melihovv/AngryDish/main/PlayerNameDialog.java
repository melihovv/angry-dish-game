package melihovv.AngryDish.main;

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
     * The maximum length of player name.
     */
    private static final int MAXIMUM_NAME_LENGTH = 10;

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

        /* Getting player name until user sets it correctly */
        int playerNameLength = 0;
        boolean validationSuccessful = true;
        do {

            validationSuccessful = true;
            _playerName = (String) dialog.showInputDialog(
                    frame,
                    "Введите имя пользователя:",
                    "Выбор имени пользователя",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    null,
                    DEFAULT_PLAYER_NAME
            );

            /* Validating player name */
            if(_playerName != null) {

                playerNameLength = _playerName.length();
                if(playerNameLength > MAXIMUM_NAME_LENGTH) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Длина имени должна быть" + " меньше " +
                                    MAXIMUM_NAME_LENGTH + " символов.",
                            "Внимание!",
                            JOptionPane.WARNING_MESSAGE
                    );
                    validationSuccessful = false;

                } else if (playerNameLength == 0) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Вы не задали имя игрока.",
                            "Внимание!",
                            JOptionPane.WARNING_MESSAGE);
                    validationSuccessful = false;
                }

            } else {

                validationSuccessful = false;
            }
        } while(!validationSuccessful);
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
