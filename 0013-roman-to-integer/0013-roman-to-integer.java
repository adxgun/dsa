class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> values = new LinkedHashMap<>();
        
        // Populate the map in descending order
        values.put('M', 1000);
        values.put('D', 500);
        values.put('C', 100);
        values.put('L', 50);
        values.put('X', 10);
        values.put('V', 5);
        values.put('I', 1);

        /*int result = 0, n = s.trim().length();
        for (int i = 0; i < n; i++) {
            int curValue = romanMap.get(s.charAt(i));
            int nextValue = i + 1 < n ? romanMap.get(s.charAt(i + 1)) : 0;
            if (curValue >= nextValue) {
                result += curValue;
            } else {
                result -= curValue;
            }
        }
        return result;*/

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentVal = values.get(s.charAt(i));

            // Check the next character if it exists
            if (i + 1 < s.length()) {
                int nextVal = values.get(s.charAt(i + 1));

                // If current is less than next, subtract current
                if (currentVal < nextVal) {
                    result -= currentVal;
                } else {
                    // Otherwise, add current
                    result += currentVal;
                }
            } else {
                // Last character, just add
                result += currentVal;
            }
        }

        return result;
    }
}