class Solution {
    private static final Map<Character, String> LETTERS = new HashMap<>();

    static {
        LETTERS.put('2', "abc");
        LETTERS.put('3', "def");
        LETTERS.put('4', "ghi");
        LETTERS.put('5', "jkl");
        LETTERS.put('6', "mno");
        LETTERS.put('7', "pqrs");
        LETTERS.put('8', "tuv");
        LETTERS.put('9', "wxyz");
    }


    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder combinations, List<String> result) {
        if (index == digits.length()) {
            result.add(combinations.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = LETTERS.get(digit);

        if (letters == null || letters.length() == 0) {
            backtrack(digits, index + 1, combinations, result);
            return;
        }

        for(char next : letters.toCharArray()) {
            combinations.append(next);
            backtrack(digits, index + 1, combinations, result);
            combinations.deleteCharAt(combinations.length() - 1);
        }
    }
}