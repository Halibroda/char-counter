package ua.com.foxminded.charcounter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

class DataCacheTest {

    private CharCounter charCounter = new UniqueCharCounter();
    private CharCounterCache charCounterCache = new CharCounterCache(charCounter);

    @Test
    void countCharacters_sameInput_returnsCachedResult() {
        String input = "abc";
        Map<Character, Integer> actualResult1 = charCounterCache.countCharacters(input);
        Map<Character, Integer> actualResult2 = charCounterCache.countCharacters(input);

        assertEquals(actualResult1, actualResult2);
    }

    @Test
    void countCharacters_differentInput_returnsDifferentResult() {
        String input1 = "abc";
        String input2 = "def";
        Map<Character, Integer> result1 = charCounterCache.countCharacters(input1);
        Map<Character, Integer> result2 = charCounterCache.countCharacters(input2);

        assertNotSame(result1, result2);
    }
}
