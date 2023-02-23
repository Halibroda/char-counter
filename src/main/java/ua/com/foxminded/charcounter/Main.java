package ua.com.foxminded.charcounter;

import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final char QUOTES = '"';
    private static final String APOSTROPHE = "'";
    private static final String HYPHEN = " - ";

    private static CharCounter charCounter = new CachedCharCounter(new UniqueCharCounter());
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter 'Stop' to stop program");
        String text = scanner.next();
        while (!text.equals("Stop")) {
            for (Map.Entry<Character, Integer> entry : charCounter.countCharacters(text).entrySet())  {
                Character character = entry.getKey();
                Integer count = entry.getValue();
                if (character.equals('"')) {
                    System.out.println(APOSTROPHE + character.toString() + APOSTROPHE + HYPHEN
                            + count);
                } else {
                    System.out.println(QUOTES + character.toString() + QUOTES + HYPHEN
                            + count);
                }
            }
            text = scanner.next();
        }
        scanner.close();
    }
}
