package melihovv.PetriDish.main;

import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Objects;

import static java.util.stream.Collectors.joining;

public class LangUtil {
    private static HashMap<String, HashMap<String, String>> _messages;
    private static String _currentLang = "ru";

    void init() {
        _messages = new HashMap<>();
        String input = "";

        try {
            final URL resource = getClass().getClassLoader().getResource("messages.json");
            input = Files.lines(Paths.get(resource.getPath()), StandardCharsets.UTF_8)
                    .collect(joining(""));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonValue root = new JsonReader().parse(input);
        for (JsonValue val : root) {
            String lang = val.name();

            HashMap<String, String> tmp = new HashMap<>();
            for (JsonValue v : val) {
                tmp.put(v.name(), v.asString());
            }

            _messages.put(lang, tmp);
        }
    }

    public static void setLang(String lang) {
        LangUtil._currentLang = lang;
    }

    static void change() {
        _currentLang = _currentLang.equals("ru") ? "en" : "ru";
    }

    public static String get(String message) throws Exception {
        if (!_messages.containsKey(_currentLang)
                || !_messages.get(_currentLang).containsKey(message)) {
            throw new Exception("Specified message does not exist");
        }

        return _messages.get(_currentLang).get(message);
    }
}
