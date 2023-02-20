package ua.com.foxminded.charcounter;

import java.util.HashMap;
import java.util.Map;

public class UniqueCharCounter implements CharCounter {
    @Override
    public Map<Character, Integer> countCharacters(String text) {
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
        return charCount;
    }
}
