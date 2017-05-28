package melihovv.PetriDish.main;

import javax.swing.*;

public class LanguageDialog {
    private String _lang = "ru";

    public void askLang() {
        JFrame frame = new JFrame();
        JOptionPane dialog = new JOptionPane();

        Object[] options = {"Русский", "Английский"};
        int choice = dialog.showOptionDialog(
                frame,
                "Выберите язык",
                "Выбор языка",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        if (choice == 0) {
            _lang = "ru";
        } else if (choice == 1) {
            _lang = "en";
        }
    }

    public String getLang() {
        return _lang;
    }
}
