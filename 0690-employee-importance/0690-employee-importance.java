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
        Map<Integer, Employee> graph = new HashMap<>();
        
        for (Employee em : employees) {
            graph.put(em.id, em);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(id);

        int total = 0;
        while (!queue.isEmpty()) {
            int curId = queue.poll();
            Employee current = graph.get(curId);
            if (current == null) continue;
            
            total += current.importance;
            for (int nei : current.subordinates) {
                queue.offer(nei);
            }
        }

        return total;
    }
}