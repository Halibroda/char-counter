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
            Map<Character, Integer> charCount = charCounter.countCharacters(text);
            for (Character character : charCount.keySet()) {
                if (character.equals('"')) {
                    System.out.println(APOSTROPHE + character.toString() + APOSTROPHE + HYPHEN
                            + charCount.get(character));
                } else {
                    System.out.println(QUOTES + character.toString() + QUOTES + HYPHEN
                            + charCount.get(character));
                }
            }
            text = scanner.next();
        }
        scanner.close();
    }
}
