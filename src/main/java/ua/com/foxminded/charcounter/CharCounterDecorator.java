package ua.com.foxminded.charcounter;

import java.util.Map;

abstract class CharCounterDecorator implements CharCounter {
    
    private CharCounter charCounter;

    protected CharCounterDecorator(CharCounter charCounter) {
        this.charCounter = charCounter;
    }

    @Override
    public Map<Character, Integer> countCharacters(String text) {
        return charCounter.countCharacters(text);
    }

}
