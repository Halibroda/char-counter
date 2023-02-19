package ua.com.foxminded.charcounter;

import java.util.Map;

abstract class Cache implements Counter {
    private Counter counter;
    
    protected Cache(Counter counter) {
       this.counter = counter;
    }

    @Override
    public Map<Character, Integer> countCharacters(String data) {
        return counter.countCharacters(data);
    }

}
