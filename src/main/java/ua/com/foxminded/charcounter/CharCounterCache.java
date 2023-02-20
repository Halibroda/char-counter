package ua.com.foxminded.charcounter;

import java.util.HashMap;
import java.util.Map;

public class CharCounterCache extends CharCounterDecorator {

    private Map<String, Map<Character, Integer>> cache = new HashMap<>();

    public CharCounterCache(CharCounter charCounter) {
        super(charCounter);
    }

    @Override
    public Map<Character, Integer> countCharacters(String text) {
        return cache.computeIfAbsent(text, super::countCharacters);
    }
}
