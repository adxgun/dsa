/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> importance = new HashMap<>();
        
        for (Employee em : employees) {
            graph.computeIfAbsent(em.id, (k) -> new ArrayList<>()).addAll(em.subordinates);
            importance.put(em.id, em.importance);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(id);

        int total = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            total += importance.getOrDefault(current, 0);

            for (int nei : graph.get(current)) {
                queue.offer(nei);
            }
        }

        return total;
    }
}