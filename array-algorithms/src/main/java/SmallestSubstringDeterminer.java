import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings string1 and string2, find the smallest substring in string1 containing all characters of string2
 * efficiently.
 * <p/>
 * For Example:
 * <p/>
 * Input string1: “this is a test string”
 * Input string2: “tist”
 * Output string: “t stri”
 */
public class SmallestSubstringDeterminer {

    public String determine(String string, String subString) {
        if (string == null) {
            throw new IllegalArgumentException("string cannot be null");
        }
        if (subString == null) {
            throw new IllegalArgumentException("subString cannot be null");
        }
        if(string.length() < subString.length()) {
            throw new IllegalArgumentException("string smaller than subString");
        }


        Map<Character, Integer> subStringMap = buildCharToCountMap(subString);

        //Determine the first substring.
        int left = 0;
        int right = 0;
        int finishCounter = 0;
        Map<Character, Integer> stringMap = new HashMap<Character, Integer>();
        while (finishCounter != subStringMap.size() && right < string.length()) {
            char eachChar = string.charAt(right);

            incrementCharToCountMap(stringMap, eachChar);

            if (subStringMap.containsKey(eachChar)) {
                if (stringMap.get(eachChar) == subStringMap.get(eachChar)) {
                    finishCounter++;
                }
            }

            right++;
        }

        //Determine the shortest substring now.
        int minDiff = Integer.MAX_VALUE;
        int finalLeft = left, finalRight = right;
        while (right < string.length()) {
            char leftChar = string.charAt(left);
            char rightChar = string.charAt(right);

            incrementCharToCountMap(stringMap, rightChar);

            if (leftChar == rightChar) { //If the right character matches left character.

                while (true) {
                    leftChar = string.charAt(left);

                    if (subStringMap.containsKey(leftChar) && stringMap.get(leftChar) == subStringMap.get(leftChar)) {
                        break;
                    }

                    if (subStringMap.containsKey(leftChar) && stringMap.get(leftChar) > subStringMap.get(leftChar)) {
                        decrementCharToCountMap(stringMap, leftChar);
                    }
                    left++;
                }

                //Update the smallest substring.
                int diff = right - left;
                if (diff < minDiff) {
                    finalLeft = left;
                    finalRight = right + 1;
                    minDiff = diff;
                }
            }
            right++;
        }

        return string.substring(finalLeft, finalRight);
    }


    private Map<Character, Integer> buildCharToCountMap(String string) {
        if (string == null) {
            throw new IllegalArgumentException("string cannot be null");
        }

        Map<Character, Integer> charToCountMap = new HashMap<Character, Integer>();
        char[] charArr = string.toCharArray();

        for (char eachChar : charArr) {
            incrementCharToCountMap(charToCountMap, eachChar);
        }

        return charToCountMap;
    }

    private void incrementCharToCountMap(Map<Character, Integer> charToCountMap, char eachChar) {
        if (charToCountMap.containsKey(eachChar)) {
            int count = charToCountMap.get(eachChar);
            count = count + 1;
            charToCountMap.put(eachChar, count);
        } else {
            charToCountMap.put(eachChar, 1);
        }
    }

    private void decrementCharToCountMap(Map<Character, Integer> charToCountMap, char eachChar) {
        if (charToCountMap.containsKey(eachChar)) {
            int count = charToCountMap.get(eachChar);
            count = count - 1;
            charToCountMap.put(eachChar, count);
        }
    }
}
