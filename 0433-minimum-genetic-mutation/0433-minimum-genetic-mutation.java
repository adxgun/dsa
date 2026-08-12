class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) return -1;
        
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(startGene);
        visited.add(startGene);
        int step = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(endGene)) return step;

                for (String next : getAllMutations(cur)) {
                    if (!visited.contains(next) && bankSet.contains(next)) {
                        visited.add(next);
                        q.offer(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private List<String> getAllMutations(String s) {
        List<String> res = new ArrayList<>();
        char[] geneChars = s.toCharArray();
        for (int i = 0; i < geneChars.length; i++) {
            char oldChar = geneChars[i];
            for (char next : new char[]{'A', 'G', 'C', 'T'}) {
                geneChars[i] = next;
                res.add(new String(geneChars));
            }
            geneChars[i] = oldChar;
        }
        return res;
    }
}