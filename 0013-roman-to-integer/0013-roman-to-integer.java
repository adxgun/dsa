class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new LinkedHashMap<>();
        
        // Populate the map in descending order
        romanMap.put('M', 1000);
        romanMap.put('D', 500);
        romanMap.put('C', 100);
        romanMap.put('L', 50);
        romanMap.put('X', 10);
        romanMap.put('V', 5);
        romanMap.put('I', 1);

        int result = 0, n = s.trim().length();
        for (int i = 0; i < n; i++) {
            int curValue = romanMap.get(s.charAt(i));
            int nextValue = i + 1 < n ? romanMap.get(s.charAt(i + 1)) : 0;
            if (curValue >= nextValue) {
                result += curValue;
            } else {
                result -= curValue;
            }
        }
        return result;
    }
}