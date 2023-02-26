package ua.com.foxminded.charcounter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class UniqueCharCounterTest {

    private CharCounter charCounter = new UniqueCharCounter();

    @Test
    void countCharacters_singleChar_correctCharactersNumber() {
        Map<Character, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put('h', 1);
        assertEquals(expectedResult, charCounter.countCharacters("h"));
    }

    @Test
    void countCharacters_singleQuote_correctQuoteCharactersNumber() {
        Map<Character, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put('"', 1);
        assertEquals(expectedResult, charCounter.countCharacters(("\"")));
    }

    @Test
    void countCharacters_severalQuotes__correctQuoteCharactersNumber() {
        Map<Character, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put('"', 3);
        assertEquals(expectedResult, charCounter.countCharacters("\"\"\""));
    }

    @Test
    void countCharacters_singleSpace_correctSpaceCharactersNumber() {
        Map<Character, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put(' ', 1);
        assertEquals(expectedResult, charCounter.countCharacters(" "));
    }

    @Test
    void countCharacters_severalSpaces_correctSpaceCharactersNumber() {
        Map<Character, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put(' ', 3);
        assertEquals(expectedResult, charCounter.countCharacters("   "));
    }

    @Test
    void countCharacters_multipleSameLettersUpperLowerCase_correctCharactersNumber() {
        Map<Character, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put('q', 4);
        expectedResult.put('Q', 3);
        assertEquals(expectedResult, charCounter.countCharacters("qqqqQQQ"));
    }

    @Test
    void countCharacters_nonLettersString_correctCharactersNumber() {
        Map<Character, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put('1', 1);
        expectedResult.put('!', 1);
        expectedResult.put('@', 2);
        expectedResult.put('#', 1);
        assertEquals(expectedResult, charCounter.countCharacters("1!@#@"));
    }

    @Test
    void countCharacters_simpleString_correctCharactersNumber() {
        Map<Character, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put('H', 1);
        expectedResult.put('e', 5);
        expectedResult.put('l', 2);
        expectedResult.put('o', 1);
        expectedResult.put(',', 1);
        expectedResult.put(' ', 1);
        expectedResult.put('E', 1);
        expectedResult.put('m', 1);
        expectedResult.put('y', 1);
        expectedResult.put('!', 2);
        assertEquals(expectedResult, charCounter.countCharacters("Heeeeello, Emy!!"));
    }

    @Test
    void countCharacters_emptyString_emptyMap() {
        Map<Character, Integer> expectedResult = new LinkedHashMap<>();
        assertEquals(expectedResult, charCounter.countCharacters(""));
    }

    @Test
    void countCharacters_null_throwNullPointerException() {
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> charCounter.countCharacters(null));
        assertEquals("Text cann`t be null", thrown.getMessage());
    }
}
