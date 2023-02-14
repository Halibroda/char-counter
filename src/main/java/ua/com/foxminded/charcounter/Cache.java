package ua.com.foxminded.charcounter;

import java.util.Map;

public interface Cache {
    void addData(String data);
    
    Map<String, Map<Character, Integer>> getData();
}
