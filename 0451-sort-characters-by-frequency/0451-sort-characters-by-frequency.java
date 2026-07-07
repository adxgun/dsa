class Solution {
    public String frequencySortA(String s) {
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

    public String frequencySort(String s) {
        int n = s.length();
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) count.merge(c, 1, Integer::sum);

        // buckets[f] = list of characters occurring exactly f times
        List<Character>[] buckets = new List[n + 1];
        for (var entry : count.entrySet()) {
            int f = entry.getValue();
            if (buckets[f] == null) buckets[f] = new ArrayList<>();
            buckets[f].add(entry.getKey());
        }

        StringBuilder sb = new StringBuilder();
        // read from highest frequency down
        for (int f = n; f >= 1; f--) {
            if (buckets[f] == null) continue;
            for (char c : buckets[f]) {
                for (int i = 0; i < f; i++) sb.append(c);   // append c, f times
            }
        }
        return sb.toString();
    }
}