class Solution {
    
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Integer[] order = new Integer[timestamp.length];
        for (int i = 0; i < order.length; i++) order[i] = i;

        Arrays.sort(order, (a, b) -> Integer.compare(timestamp[a], timestamp[b]));
        Map<String, List<String>> visits = new HashMap<>();
        for (int i : order) {
            visits.computeIfAbsent(username[i], (k) -> new ArrayList<>()).add(website[i]);
        }

        Map<String, Integer> score = new HashMap<>();
        for (List<String> sites : visits.values()) {
            int m = sites.size();
            Set<String> seen = new HashSet<>();
            for (int i = 0; i < m; i++)
                for (int j = i + 1; j < m; j++)
                    for (int k = j + 1; k < m; k++)
                        seen.add(sites.get(i) + " " + sites.get(j) + " " + sites.get(k));

            for (String s : seen) score.merge(s, 1, Integer::sum);
        }

        String best = null;
        int max = 0;
        for (Map.Entry<String, Integer> entry : score.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (value > max || (value == max && key.compareTo(best) < 0)) {
                best = key;
                max = value;
            }
        }

        return Arrays.asList(best.split(" "));
    }
}