package ua.com.foxminded.charcounter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class CharCounterTest {

    private CharCounter charCounter = new UniqueCharCounter();

    @Test
    void countCharacters_singleChar_correctLine() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put('h', 1);
        assertEquals(expectedResult, charCounter.countCharacters("h"));
    }

    @Test
    void countCharacters_singleQuote_correctLine() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put('"', 1);
        assertEquals(expectedResult, charCounter.countCharacters(String.valueOf('"')));
    }

    @Test
    void countCharacters_severalQuotes_correctLine() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put('"', 3);
        assertEquals(expectedResult, charCounter.countCharacters(String.valueOf('"') + '"' + '"'));
    }

    @Test
    void countCharacters_singleSpace_correctLine() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put(' ', 1);
        assertEquals(expectedResult, charCounter.countCharacters(" "));
    }

    @Test
    void countCharacters_severalSpace_correctLine() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put(' ', 3);
        assertEquals(expectedResult, charCounter.countCharacters("   "));
    }

    @Test
    void countCharacters_multipleSameLettersUpperLowerCase_correctLine() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put('q', 4);
        expectedResult.put('Q', 3);
        assertEquals(expectedResult, charCounter.countCharacters("qqqqQQQ"));
    }

    @Test
    void countCharacters_nonLettersString_correctLine() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put('1', 1);
        expectedResult.put('!', 1);
        expectedResult.put('@', 2);
        expectedResult.put('#', 1);
        assertEquals(expectedResult, charCounter.countCharacters("1!@#@"));
    }

    @Test
    void countCharacters_simpleString_correctMap() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put('H', 1);
        expectedResult.put('e', 5);
        expectedResult.put('E', 1);
        expectedResult.put('l', 2);
        expectedResult.put('o', 1);
        expectedResult.put(',', 1);
        expectedResult.put(' ', 1);
        expectedResult.put('m', 1);
        expectedResult.put('y', 1);
        expectedResult.put('!', 2);
        assertEquals(expectedResult, charCounter.countCharacters("Heeeeello, Emy!!"));
    }

    @Test
    void countCharacters_emptyString_emptyMap() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        assertEquals(expectedResult, charCounter.countCharacters(""));
    }

    @Test
    void countCharacters_null_throwNullPointerException() {
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> charCounter.countCharacters(null));
        assertEquals("Text cann`t be null", thrown.getMessage());
    }

}
