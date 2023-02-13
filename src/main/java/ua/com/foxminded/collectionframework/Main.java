package ua.com.foxminded.collectionframework;

import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<String, Map<Character, Integer>> cache = new HashMap<String, Map<Character, Integer>>();

    public static void main(String[] args) {
        printCharCount("Hello World!!");
        printCharCount("HI");
        printCharCount("   ");
        printCharCount("Hello World!!");
    }

    private static void printCharCount(String text) {
        Counter counter = new Counter();
        Formatter formatter = new Formatter();
        if (cache.containsKey(text)) {
            System.out.println(formatter.format(text, cache));
        } else {
            Map<Character, Integer> test = counter.countChar(text);
            cache.put(text, test);
            System.out.println(formatter.format(text, cache));
        }
    }

}
