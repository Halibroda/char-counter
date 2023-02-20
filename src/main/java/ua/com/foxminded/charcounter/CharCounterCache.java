package ua.com.foxminded.charcounter;

import java.util.HashMap;
import java.util.Map;

public class CharCounterCache extends Cache {

    private Map<String, Map<Character, Integer>> cache = new HashMap<>();

    public CharCounterCache(CharCounter charCounter) {
        super(charCounter);
    }

    @Override
    public Map<Character, Integer> countCharacters(String text) {
        if (text == null) {
            throw new NullPointerException("Text cann`t be null");
        }
        return cache.computeIfAbsent(text, super::countCharacters);
    }
}
