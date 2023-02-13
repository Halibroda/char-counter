package ua.com.foxminded.collectionframework;

import java.util.Map;

public class Formatter {

    private static final String NEW_LINE = System.lineSeparator();
    private static final char QUOTES = '"';
    private static final String HYPHEN = " - ";

    public String format(String text, Map<String, Map<Character, Integer>> cache) {
        if (text == null) {
            throw new NullPointerException("Text cann`t be null");
        } else if (cache == null) {
            throw new NullPointerException("Cache cann`t be null");
        }
        if (text == "") {
            return "#NO TEXT ENTERED#" + NEW_LINE;
        }
        StringBuilder formattedResult = new StringBuilder();
        formattedResult.append(text + NEW_LINE);
        formattedResult.append(formatCount(text, cache));
        return formattedResult.toString();
    }

    private String formatCount(String text, Map<String, Map<Character, Integer>> result) {
        StringBuilder formattedResult = new StringBuilder();
        try {
            for (Character character : result.get(text).keySet()) {
                formattedResult.append(
                        QUOTES + character.toString() + QUOTES + HYPHEN + result.get(text).get(character) + NEW_LINE);
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("No text in cache");
        }
        return formattedResult.toString();
    }

}
