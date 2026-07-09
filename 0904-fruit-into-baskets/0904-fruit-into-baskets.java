import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0, total = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < fruits.length; i++) {
            freq.merge(fruits[i], 1, Integer::sum);

            while(freq.size() > 2) {
                if (freq.merge(fruits[left], -1, Integer::sum) == 0) freq.remove(fruits[left]);
                left++;
            }
            
            total = Math.max(i - left + 1, total);
        }
            
        return total;
    }
}