package ua.com.foxminded.charcounter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class CharCounterTest {

    private Counter counter = new CharCounter();

    @Test
    void countCharacters_singleChar_correctLine() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put("h".charAt(0), 1);
        assertEquals(expectedResult, counter.countCharacters("h"));
    }

    @Test
    void countCharacters_singleQuote_correctLine() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put('"', 1);
        assertEquals(expectedResult, counter.countCharacters(String.valueOf('"')));
    }

    @Test
    void countCharacters_severalQuotes_correctLine() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put('"', 3);
        assertEquals(expectedResult, counter.countCharacters(String.valueOf('"') + '"' + '"'));
    }

    @Test
    void countCharacters_singleSpace_correctLine() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put(" ".charAt(0), 1);
        assertEquals(expectedResult, counter.countCharacters(" "));
    }

    @Test
    void countCharacters_severalSpace_correctLine() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put(" ".charAt(0), 3);
        assertEquals(expectedResult, counter.countCharacters("   "));
    }

    @Test
    void countCharacters_multipleSameLettersUpperLowerCase_correctLine() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put("q".charAt(0), 4);
        expectedResult.put("Q".charAt(0), 3);
        assertEquals(expectedResult, counter.countCharacters("qqqqQQQ"));
    }

    @Test
    void countCharacters_nonLettersString_correctLine() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put("1".charAt(0), 1);
        expectedResult.put("!".charAt(0), 1);
        expectedResult.put("@".charAt(0), 2);
        expectedResult.put("#".charAt(0), 1);
        assertEquals(expectedResult, counter.countCharacters("1!@#@"));
    }

    @Test
    void countCharacters_simpleString_correctMap() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put("H".charAt(0), 1);
        expectedResult.put("e".charAt(0), 5);
        expectedResult.put("E".charAt(0), 1);
        expectedResult.put("l".charAt(0), 2);
        expectedResult.put("o".charAt(0), 1);
        expectedResult.put(",".charAt(0), 1);
        expectedResult.put(" ".charAt(0), 1);
        expectedResult.put("m".charAt(0), 1);
        expectedResult.put("y".charAt(0), 1);
        expectedResult.put("!".charAt(0), 2);
        assertEquals(expectedResult, counter.countCharacters("Heeeeello, Emy!!"));
    }

    @Test
    void countCharacters_emptyString_emptyMap() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        assertEquals(expectedResult, counter.countCharacters(""));
    }

    @Test
    void countCharacters_null_throwNullPointerException() {
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> counter.countCharacters(null));
        assertEquals("Text cann`t be null", thrown.getMessage());
    }

}
