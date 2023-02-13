package ua.com.foxminded.collectionframework;

import java.util.HashMap;
import java.util.Map;

public class Counter {

    public Map<Character, Integer> countChar(String text) {
        if (text == null) {
            throw new NullPointerException("Text cann`t be null");
        }
        Map<Character, Integer> charCount = new HashMap<Character, Integer>();
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (charCount.containsKey(currentChar)) {
                charCount.put(currentChar, charCount.get(currentChar) + 1);
            } else {
                charCount.put(currentChar, 1);
            }
        }
        return charCount;
    }

}
