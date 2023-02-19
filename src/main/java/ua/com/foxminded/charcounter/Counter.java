package ua.com.foxminded.charcounter;

import java.util.Map;

public interface Counter {
    Map<Character, Integer> countCharacters(String data);
}
