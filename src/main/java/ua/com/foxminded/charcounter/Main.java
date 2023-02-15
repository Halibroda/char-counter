package ua.com.foxminded.charcounter;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static final char QUOTES = '"';
    private static final String APOSTROPHE = "'";
    private static final String HYPHEN = " - ";

    private static Cache cache = new DataCache(new TextCache(new HashMap<>()));
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter 'Stop' to stop program");
        String text = readLine();
        while (!text.equals("Stop")) {
            for (Character character : cache.getData(text).keySet()) {
                if (character.equals('"')) {
                    System.out.println(APOSTROPHE + character.toString() + APOSTROPHE + HYPHEN
                            + cache.getData(text).get(character));
                } else {
                    System.out.println(QUOTES + character.toString() + QUOTES + HYPHEN
                            + cache.getData(text).get(character));
                }
            }
            text = readLine();
        }
        scanner.close();
    }

    private static String readLine() {
        String text;
        text = scanner.next();
        return text;
    }

}
