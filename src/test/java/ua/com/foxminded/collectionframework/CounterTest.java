package ua.com.foxminded.collectionframework;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class CounterTest {

    private Counter counter = new Counter();

    @Test
    void format_singleChar_correctLine() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put("h".charAt(0), 1);
        assertEquals(expectedResult, counter.countChar("h"));
    }

    @Test
    void format_singleQuote_correctLine() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put('"', 1);
        assertEquals(expectedResult, counter.countChar(String.valueOf('"')));
    }

    @Test
    void format_severalQuotes_correctLine() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put('"', 3);
        assertEquals(expectedResult, counter.countChar(String.valueOf('"') + '"' + '"'));
    }

    @Test
    void format_singleSpace_correctLine() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put(" ".charAt(0), 1);
        assertEquals(expectedResult, counter.countChar(" "));
    }

    @Test
    void format_severalSpace_correctLine() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put(" ".charAt(0), 3);
        assertEquals(expectedResult, counter.countChar("   "));
    }

    @Test
    void format_multipleSameLettersUpperLowerCase_correctLine() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put("q".charAt(0), 4);
        expectedResult.put("Q".charAt(0), 3);
        assertEquals(expectedResult, counter.countChar("qqqqQQQ"));
    }

    @Test
    void format_nonLettersString_correctLine() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put("1".charAt(0), 1);
        expectedResult.put("!".charAt(0), 1);
        expectedResult.put("@".charAt(0), 2);
        expectedResult.put("#".charAt(0), 1);
        assertEquals(expectedResult, counter.countChar("1!@#@"));
    }

    @Test
    void countChar_simpleString_correctMap() {
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
        assertEquals(expectedResult, counter.countChar("Heeeeello, Emy!!"));
    }

    @Test
    void countChar_emptyString_emptyMap() {
        Map<Character, Integer> expectedResult = new HashMap<>();
        assertEquals(expectedResult, counter.countChar(""));
    }

    @Test
    void countChar_null_throwNullPointerException() {
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> counter.countChar(null));
        assertEquals("Text cann`t be null", thrown.getMessage());
    }
}
