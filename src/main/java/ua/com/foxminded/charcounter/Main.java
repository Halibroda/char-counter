package ua.com.foxminded.charcounter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String NEW_LINE = System.lineSeparator();
    private static final char QUOTES = '"';
    private static final String APOSTROPHE = "'";
    private static final String HYPHEN = " - ";

    private static Cache cacheTest = new TextCache(new HashMap<>());
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printCharCount(readLine());
        }
    }

    private static void printCharCount(String text) {
        if (cacheTest.getData().containsKey(text)) {
            System.out.println(format(text));
        } else {
            cacheTest.addData(text);
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
        } else if (cacheTest == null) {
            throw new NullPointerException("Cache cann`t be null");
        }
        if (text.equals("")) {
            return "#NO TEXT ENTERED#" + NEW_LINE;
        }
        StringBuilder formattedResult = new StringBuilder();
        try {
            for (Character character : cacheTest.getData().get(text).keySet()) {
                if (character.equals('"')) {
                    formattedResult.append(APOSTROPHE + character.toString() + APOSTROPHE + HYPHEN
                            + cacheTest.getData().get(text).get(character) + NEW_LINE);
                } else {
                    formattedResult.append(QUOTES + character.toString() + QUOTES + HYPHEN
                            + cacheTest.getData().get(text).get(character) + NEW_LINE);
                }
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("No text in cache");
        }
        return formattedResult.toString();
    }

}
