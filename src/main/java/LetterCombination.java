import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class LetterCombination {
    private HashMap<Integer, String> dictMap = new HashMap<Integer, String>();

    public String letterCombinations(int[] digits) {
        initializeDict();
        if (digits.length == 0) {
            return "";
        }
        return outputStringResult(findCombination(digits));
    }

    public int sum(int a, int b) {
        return a + b;
    }

    private String outputStringResult(ArrayList<String> combination) {
        if (combination == null || combination.size() == 0) {
            return "";
        }

        StringBuilder resultBuilder = new StringBuilder(combination.get(0));
        for (int i = 1; i < combination.size(); i++) {
            resultBuilder.append(" ").append(combination.get(i));
        }
        return resultBuilder.toString();
    }

    private ArrayList<String> findCombination(int[] digits) {
        ArrayList<String> combinations = new ArrayList<String>();
        if (digits.length == 0) {
            combinations.add("");
            return combinations;
        }
        String letters = getCurDigitLetters(digits[0]);
        ArrayList<String> prevComb = findCombination(ArrayUtils.remove(digits, 0));
        for (int i = 0; i < letters.length(); ++i) {
            for (String s : prevComb) {
                combinations.add(letters.charAt(i) + s);
            }
        }
        return combinations;
    }

    private String getCurDigitLetters(int digit) {
        String letters = dictMap.get(digit);

        StringBuilder lettersBuilder = new StringBuilder();
        if (letters == null) {
            String digitStr = String.valueOf(digit);
            for (int i = 0; i < digitStr.length(); i++) {
                lettersBuilder.append(dictMap.get(digitStr.charAt(i) - '0'));
            }
            letters = lettersBuilder.toString();
        }
        return letters;
    }

    private void initializeDict() {
        dictMap.put(0, "");
        dictMap.put(1, "");
        dictMap.put(2, "abc");
        dictMap.put(3, "def");
        dictMap.put(4, "ghi");
        dictMap.put(5, "jkl");
        dictMap.put(6, "mno");
        dictMap.put(7, "pqrs");
        dictMap.put(8, "tuv");
        dictMap.put(9, "wxyz");
    }
}
