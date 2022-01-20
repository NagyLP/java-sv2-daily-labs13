package day04;

import java.util.Map;
import java.util.TreeMap;

public class StringStatistics {

    private static final String VOWELS = "aeiou";

    public Map<Character, Integer> voewelCounter(String word) {
        Map<Character, Integer> result = new TreeMap<>();
        for (Character act : word.toCharArray()) {

//        for (int i = 0; i < word.length(); i++) {
//            char act = word.charAt(i);
//            if (isVowel(word.charAt(i))) {
//                if (!result.containsKey(word.charAt(i))) {

            if(isVowel(act) && !result.containsKey(act)) {
                result.put(act, 1);
//             result.put(word.charAt(act), 1); {
            }
            else if (isVowel(act)) {
//                } else {
//                    result.put(act, result.get(act) + 1);
                }
            }
        return result;
    }


    private boolean isVowel(char c) {
        return VOWELS.indexOf(Character.toLowerCase(c)) >= 0;
    }
}
