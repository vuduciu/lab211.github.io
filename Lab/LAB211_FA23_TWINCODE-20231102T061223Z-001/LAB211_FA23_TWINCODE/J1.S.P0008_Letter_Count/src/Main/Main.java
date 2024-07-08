package Main;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author tranh
 */
public class Main {

    public static void main(String[] args) {
        // Step 1: Ask user enter content
        String str = getString("Enter your content:");
        // Step 2: Count number of words
        countAndDisplayNumberOfWords(str);
        // Step 4: Count number of characters
        countAndDisplayNumberOfCharacter(str);
    }

    private static String getString(String msg) {
        Scanner sc = new Scanner(System.in);
        String str;
        // Loop to ask user re-enter string until it's valid
        do {
            System.out.println(msg);
            str = sc.nextLine();
            // Check is user entered empty string
            if (!str.isEmpty()) {
                break;
            } else {
                System.out.println("Empty input! Try again!");
            }
        } while (true);
        return str;
    }

    private static void countAndDisplayNumberOfWords(String str) {
        Map<String, Integer> wordCountMap = new LinkedHashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(str, " ");
        String subStr;
        // Loop to read all tokens in the string
        while (tokenizer.hasMoreTokens()) {
            subStr = tokenizer.nextToken();
            // Check is existed key in the map
            if (wordCountMap.containsKey(subStr)) {
                wordCountMap.put(subStr, wordCountMap.get(subStr) + 1);
            } else {
                wordCountMap.put(subStr, 1);
            }
        }
        System.out.println(wordCountMap);
    }

    private static void countAndDisplayNumberOfCharacter(String str) {
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
        // Loop to read each character of the string
        for (int i = 0; i < str.length(); i++) {
            boolean skip = false;
            char character = str.charAt(i);
            // Check is reading character is a space character
            if (character == ' ') {
                skip = true;
            }
            // Check is reading character is not a space character
            if (skip == false) {
                // Check is existed key in the map
                if (charCountMap.containsKey(character)) {
                    charCountMap.put(character, charCountMap.get(character) + 1);
                } else {
                    charCountMap.put(character, 1);
                }
            }
        }
        System.out.println(charCountMap);
    }
}
