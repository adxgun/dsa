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
        int left = 0, right = s.length() - 1;
        char[] arr = s.toCharArray();
        
        while(left < right) {
            while(left < right && !VOWELS.contains(arr[left])) {
                left++;
            }

            while(left < right && !VOWELS.contains(arr[right])) {
                right--;
            }

            if (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }
        return new String(arr);
    }

    private boolean isVowel(char c) {
        return VOWELS.contains(c);
    }
}