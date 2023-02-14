package ua.com.foxminded.charcounter;

import java.util.HashMap;
import java.util.Map;

public class TextCache implements Cache {
    private Map<String, Map<Character, Integer>> textData = new HashMap<>();

    public TextCache(Map<String, Map<Character, Integer>> textData) {
        this.textData = textData;
    }

    @Override
    public void addData(String text) {
        if (text == null) {
            throw new NullPointerException("Text cann`t be null");
        }
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (charCount.containsKey(currentChar)) {
                charCount.put(currentChar, charCount.get(currentChar) + 1);
            } else {
                charCount.put(currentChar, 1);
            }
        }
        textData.put(text, charCount);
    }

    @Override
    public Map<String, Map<Character, Integer>> getData() {
        return textData;
    }

}
