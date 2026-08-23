class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, String> names = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                names.put(email, name);

                graph.computeIfAbsent(email, (k) -> new ArrayList<>());
                if (i > 1) {
                    graph.get(firstEmail).add(email);
                    graph.get(email).add(firstEmail);
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        for (String email : graph.keySet()) {
            if (visited.contains(email)) continue;
            
            Queue<String> queue = new ArrayDeque<>();
            queue.offer(email);
            visited.add(email);

            List<String> level = new ArrayList<>();
            while (!queue.isEmpty()) {
                String current = queue.poll();
                level.add(current);

                for (String nei : graph.get(current)) {
                    if (!visited.contains(nei)) {
                        visited.add(nei);
                        queue.offer(nei);
                    }
                }
            }

            Collections.sort(level);
            level.add(0, names.get(email));
            result.add(level);
        }

        return result;
    }
}