class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int r = 0; r < routes.length; r++) {
            for (int stop : routes[r]) {
                graph.computeIfAbsent(stop, (k) -> new ArrayList<>()).add(r);
            }
        }

        Set<Integer> visitedRoutes = new HashSet<>();
        Set<Integer> visitedStops = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        visitedStops.add(source);

        int buses = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            buses++;
            for (int i = 0; i < size; i++) {
                int stop = queue.poll();
                for (int routeId : graph.getOrDefault(stop, Collections.emptyList())) {
                    if (visitedRoutes.contains(routeId)) continue;
                    visitedRoutes.add(routeId);

                    for (int nextStop : routes[routeId]) {
                        if (visitedStops.add(nextStop)) queue.offer(nextStop);
                    }
                }
            }
            if (visitedStops.contains(target)) return buses;
        }

        return -1;
    }
}