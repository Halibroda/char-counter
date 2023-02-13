package ua.com.foxminded.charcounter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String NEW_LINE = System.lineSeparator();
    private static final char QUOTES = '"';
    private static final String APOSTROPHE = "'";
    private static final String HYPHEN = " - ";

    static Map<String, Map<Character, Integer>> cache = new HashMap<String, Map<Character, Integer>>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printCharCount(readLine());
        }
    }

    private static void printCharCount(String text) {
        Counter counter = new Counter();
        if (cache.containsKey(text)) {
            System.out.println(format(text));
        } else {
            Map<Character, Integer> test = counter.countChar(text);
            cache.put(text, test);
            System.out.println(format(text));
        }
    }

    private static String readLine() {
        String text;
        System.out.print("Enter text: ");
        text = scanner.next();
        return text;
    }

    private static String format(String text) {
        if (text == null) {
            throw new NullPointerException("Text cann`t be null");
        } else if (cache == null) {
            throw new NullPointerException("Cache cann`t be null");
        }
        if (text.equals("")) {
            return "#NO TEXT ENTERED#" + NEW_LINE;
        }
        StringBuilder formattedResult = new StringBuilder();
        formattedResult.append(text + NEW_LINE);
        try {
            for (Character character : cache.get(text).keySet()) {
                if (character.equals('"')) {
                    formattedResult.append(APOSTROPHE + character.toString() + APOSTROPHE + HYPHEN
                            + cache.get(text).get(character) + NEW_LINE);
                } else {
                    formattedResult.append(QUOTES + character.toString() + QUOTES + HYPHEN
                            + cache.get(text).get(character) + NEW_LINE);
                }
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("No text in cache");
        }
        return formattedResult.toString();
    }

}
