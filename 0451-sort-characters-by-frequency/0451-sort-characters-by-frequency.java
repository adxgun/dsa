class Solution {
    public String frequencySort(String s) {
        var map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        StringBuilder sb = new StringBuilder();
        map.entrySet().
            stream().
            sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
            forEach(e -> appendValues(e.getKey(), e.getValue(), sb));
    
        return sb.toString();
    }

    private void appendValues(char c, int count, StringBuilder sb) {
        while (count > 0) {
            sb.append(c);
            count--;
        }
    }
}