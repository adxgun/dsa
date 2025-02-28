class Solution {

    private static final Set<Character> VOWELS = new HashSet<>();
    static {
        VOWELS.add('a');
        VOWELS.add('e');
        VOWELS.add('i');
        VOWELS.add('o');
        VOWELS.add('u');
        VOWELS.add('A');
        VOWELS.add('E');
        VOWELS.add('I');
        VOWELS.add('O');
        VOWELS.add('U');
    }

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();
        while(left < right) {
            while(left < right && !isVowel(chars[left])) {
                left++;
            }

            while(left < right && !isVowel(chars[right])) {
                right--;
            }

            
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                left++;
                right--;
            }
        }
        return new String(chars);
    }

    private boolean isVowel(char v) {
        return VOWELS.contains(v);
    }
}