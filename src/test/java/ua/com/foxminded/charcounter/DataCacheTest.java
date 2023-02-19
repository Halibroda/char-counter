package ua.com.foxminded.charcounter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

class DataCacheTest {

    private Counter counter = new CharCounter();
    private DataCache dataCache = new DataCache(counter);
    
    @Test
    void countCharacters_sameInput_returnsCachedResult() {
        String input = "abc";
        Map<Character, Integer> actualResult1 = dataCache.countCharacters(input);
        Map<Character, Integer> actualResult2 = dataCache.countCharacters(input);

        assertEquals(actualResult1, actualResult2);
    }

    @Test
    void countCharacters_differentInput_returnsDifferentResult() {
        String input1 = "abc";
        String input2 = "def";
        Map<Character, Integer> result1 = dataCache.countCharacters(input1);
        Map<Character, Integer> result2 = dataCache.countCharacters(input2);

        assertNotSame(result1, result2);
    }

    @Test
    void countCharacters_throwsNullPointerExceptionForNullInput() {
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> counter.countCharacters(null));
        assertEquals("Text cann`t be null", thrown.getMessage());
    }

}
