class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) freq.merge(w, 1, Integer::sum);

        Set<String> set = new TreeSet<>((a, b) -> {
            int fa = freq.get(a), fb = freq.get(b);
            if (fa == fb) return a.compareTo(b);
            return freq.get(b) - freq.get(a);
        });
        
        set.addAll(freq.keySet());
        List<String> result = new ArrayList<>();
        for (String s : set) {
            if (result.size() == k) break;
            result.add(s);
        }
        return result;
    }
}