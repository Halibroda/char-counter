package ua.com.foxminded.collectionframework;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class FormatterTest {

    Formatter formatter = new Formatter();

    @Test
    void format_singleChar_correctLine() {
        Map<Character, Integer> countOfChar = new HashMap<>();
        countOfChar.put("h".charAt(0), 1);
        Map<String, Map<Character, Integer>> cache = new HashMap<>();
        cache.put("h", countOfChar);
        StringBuilder expected = new StringBuilder();
        expected.append("h" + System.lineSeparator());
        expected.append('"' + "h" + '"' + " - 1" + System.lineSeparator());
        assertEquals(expected.toString(), formatter.format("h", cache));
    }
    
    @Test
    void format_singleSpace_correctLine() {
        Map<Character, Integer> countOfChar = new HashMap<>();
        countOfChar.put(" ".charAt(0), 1);
        Map<String, Map<Character, Integer>> cache = new HashMap<>();
        cache.put(" ", countOfChar);
        StringBuilder expected = new StringBuilder();
        expected.append(" " + System.lineSeparator());
        expected.append('"' + " " + '"' + " - 1" + System.lineSeparator());
        assertEquals(expected.toString(), formatter.format(" ", cache));
    }
   
    @Test
    void format_severalSpace_correctLine() {
        Map<Character, Integer> countOfChar = new HashMap<>();
        countOfChar.put(" ".charAt(0), 3);
        Map<String, Map<Character, Integer>> cache = new HashMap<>();
        cache.put("   ", countOfChar);
        StringBuilder expected = new StringBuilder();
        expected.append("   " + System.lineSeparator());
        expected.append('"' + " " + '"' + " - 3" + System.lineSeparator());
        assertEquals(expected.toString(), formatter.format("   ", cache));
    }
    
    @Test
    void format_multipleSameLetters_correctLine() {
        Map<Character, Integer> countOfChar = new HashMap<>();
        countOfChar.put("q".charAt(0), 4);
        countOfChar.put("Q".charAt(0), 3);
        Map<String, Map<Character, Integer>> cache = new HashMap<>();
        cache.put("qqqqQQQ", countOfChar);
        StringBuilder expected = new StringBuilder();
        expected.append("qqqqQQQ" + System.lineSeparator());
        expected.append('"' + "q" + '"' + " - 4" + System.lineSeparator());
        expected.append('"' + "Q" + '"' + " - 3" + System.lineSeparator());
        assertEquals(expected.toString(), formatter.format("qqqqQQQ", cache));
    }
    
    @Test
    void format_nonLettersString_correctLine() {
        Map<Character, Integer> countOfChar = new HashMap<>();
        countOfChar.put("1".charAt(0), 1);
        countOfChar.put("!".charAt(0), 1);
        countOfChar.put("@".charAt(0), 2);
        countOfChar.put("#".charAt(0), 1);
        Map<String, Map<Character, Integer>> cache = new HashMap<>();
        cache.put("1!@#@", countOfChar);
        StringBuilder expected = new StringBuilder();
        expected.append("1!@#@" + System.lineSeparator());
        expected.append('"' + "@" + '"' + " - 2" + System.lineSeparator());
        expected.append('"' + "1" + '"' + " - 1" + System.lineSeparator());
        expected.append('"' + "!" + '"' + " - 1" + System.lineSeparator());
        expected.append('"' + "#" + '"' + " - 1" + System.lineSeparator());
        assertEquals(expected.toString(), formatter.format("1!@#@", cache));
    }
    
    @Test
    void format_simpleString_correctLine() {
        Map<Character, Integer> countOfChar = new HashMap<>();
        countOfChar.put("H".charAt(0), 1);
        countOfChar.put("e".charAt(0), 5);
        countOfChar.put("E".charAt(0), 1);
        countOfChar.put("l".charAt(0), 2);
        countOfChar.put("o".charAt(0), 1);
        countOfChar.put(",".charAt(0), 1);
        countOfChar.put(" ".charAt(0), 1);
        countOfChar.put("m".charAt(0), 1);
        countOfChar.put("y".charAt(0), 1);
        countOfChar.put("!".charAt(0), 2);
        Map<String, Map<Character, Integer>> cache = new HashMap<>();
        cache.put("Heeeeello, Emy!!", countOfChar);
        StringBuilder expected = new StringBuilder();
        expected.append("Heeeeello, Emy!!" + System.lineSeparator());
        expected.append('"' + " " + '"' + " - 1" + System.lineSeparator());
        expected.append('"' + "!" + '"' + " - 2" + System.lineSeparator());
        expected.append('"' + "e" + '"' + " - 5" + System.lineSeparator());
        expected.append('"' + "E" + '"' + " - 1" + System.lineSeparator());
        expected.append('"' + "H" + '"' + " - 1" + System.lineSeparator());
        expected.append('"' + "y" + '"' + " - 1" + System.lineSeparator());
        expected.append('"' + "l" + '"' + " - 2" + System.lineSeparator());
        expected.append('"' + "," + '"' + " - 1" + System.lineSeparator());
        expected.append('"' + "m" + '"' + " - 1" + System.lineSeparator());
        expected.append('"' + "o" + '"' + " - 1" + System.lineSeparator());
        assertEquals(expected.toString(), formatter.format("Heeeeello, Emy!!", cache));
    }

    @Test
    void format_emptyString_noTextEnteredLine() {
        Map<String, Map<Character, Integer>> cache = new HashMap<>();
        assertEquals("#NO TEXT ENTERED#" + System.lineSeparator(), formatter.format("", cache));
    }

    @Test
    void format_noTextInCache_throwNullPointerException() {
        Map<String, Map<Character, Integer>> cache = new HashMap<>();
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> formatter.format("qwer", cache));
        assertEquals("No text in cache", thrown.getMessage());
    }
    
    @Test
    void format_nullText_throwNullPointerException() {
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> formatter.format(null, null));
        assertEquals("Text cann`t be null", thrown.getMessage());
    }

    @Test
    void format_nullCache_throwNullPointerException() {
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> formatter.format("text", null));
        assertEquals("Cache cann`t be null", thrown.getMessage());
    }
}
