package ua.com.foxminded.charcounter;

import java.util.Scanner;

public class Main {

    private static final char QUOTES = '"';
    private static final String APOSTROPHE = "'";
    private static final String HYPHEN = " - ";

    private static CharCounter charCounter = new CharCounterCache(new UniqueCharCounter());
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter 'Stop' to stop program");
        String text = scanner.next();
        while (!text.equals("Stop")) {
            for (Character character : charCounter.countCharacters(text).keySet()) {
                if (character.equals('"')) {
                    System.out.println(APOSTROPHE + character.toString() + APOSTROPHE + HYPHEN
                            + charCounter.countCharacters(text).get(character));
                } else {
                    System.out.println(QUOTES + character.toString() + QUOTES + HYPHEN
                            + charCounter.countCharacters(text).get(character));
                }
            }
            text = scanner.next();;
        }
        scanner.close();
    }
}
