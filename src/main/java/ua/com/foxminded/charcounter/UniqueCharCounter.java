package ua.com.foxminded.charcounter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class UniqueCharCounter implements CharCounter {

    @Override
    public Map<Character, Integer> countCharacters(String text) {
        if (text == null) {
            throw new NullPointerException("Text can`t be null");
        }
        return text.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.summingInt(c -> 1)));
    }
}
