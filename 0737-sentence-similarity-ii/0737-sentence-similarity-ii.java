class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        // fine <-> good
        // great <-> good
        // drama <-> acting
        // skills <-> talent
        if (sentence1.length != sentence2.length) return false;
        
        int n = sentence1.length;
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> sm : similarPairs) {
            String a = sm.get(0), b = sm.get(1);
            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        for (int i = 0; i < n; i++) {
            String left = sentence1[i], right = sentence2[i];
            if (left.equals(right)) continue;
            
            Set<String> visited = new HashSet<>();
            Queue<String> queue = new ArrayDeque<>();
            queue.offer(left);
            visited.add(left);
            boolean found = false;

            while (!queue.isEmpty()) {
                String node = queue.poll();
                if (node.equals(right)) {
                    found = true;
                    break;
                }

                for (String nei : graph.getOrDefault(node, Collections.emptyList())) {
                    if (!visited.contains(nei)) {
                        visited.add(nei);
                        queue.offer(nei);
                    }
                }
            }

            if (!found) return false;
        }

        return true;
    }
}