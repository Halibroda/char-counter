package ua.com.foxminded.charcounter;

import java.util.HashMap;
import java.util.Map;

public class DataCache extends Cache{

    private Map<String, Map<Character, Integer>> cache = new HashMap<>();
    
    public DataCache(Counter data) {
        super(data);
    }
    
    @Override
    public Map<Character, Integer> countCharacters(String text) {
        return cache.computeIfAbsent(text, super::countCharacters);
    }
}
