package ua.com.foxminded.charcounter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

class CharCounterCacheTest {

    private CharCounter charCounter = mock(CharCounter.class);
    private CharCounter cachedCharCounter = new CachedCharCounter(charCounter);

    @Test
    void countCharacters_input_methodFromCharCounterCalledOnce() {
        String text = "Heeeeello, Emy!!";

        Map<Character, Integer> expected = new HashMap<>();
        expected.put('H', 1);
        expected.put('e', 5);
        expected.put('E', 1);
        expected.put('l', 2);
        expected.put('o', 1);
        expected.put(',', 1);
        expected.put(' ', 1);
        expected.put('m', 1);
        expected.put('y', 1);
        expected.put('!', 2);

        when(charCounter.countCharacters(text)).thenReturn(expected);

        Map<Character, Integer> actual1 = cachedCharCounter.countCharacters(text);
        Map<Character, Integer> actual2 = cachedCharCounter.countCharacters(text);
        
        assertEquals(expected, actual1);
        assertEquals(actual1, actual2);

        verify(charCounter, times(1)).countCharacters(text);
    }
}
