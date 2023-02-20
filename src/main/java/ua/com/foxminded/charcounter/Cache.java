package ua.com.foxminded.charcounter;

import java.util.Map;

abstract class Cache implements CharCounter {
    private CharCounter charCounter;
    
    protected Cache(CharCounter charCounter) {
       this.charCounter = charCounter;
    }

    @Override
    public Map<Character, Integer> countCharacters(String data) {
        return charCounter.countCharacters(data);
    }

}
