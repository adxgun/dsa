class Solution {

    public List<String> watchedVideosByFriends(
        List<List<String>> watchedVideos, 
        int[][] friends, 
        int id, 
        int level) {
        
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(id);
        visited.add(id);

        int curLevel = 0;
        while (!queue.isEmpty() && curLevel < level) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curFriend = queue.poll();
                for (int next : friends[curFriend]) {
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            curLevel++;
        }

        Map<String, Integer> frequency = new HashMap<>();
        for (int person : queue) {
            for (String video : watchedVideos.get(person)) {
                frequency.merge(video, 1, Integer::sum);
            }
        }

        List<String> sorted = new ArrayList<>(frequency.keySet());
        Collections.sort(sorted, (a, b) -> {
            int freqa = frequency.get(a);
            int freqb = frequency.get(b);
            if (freqa == freqb) return a.compareTo(b);
            return freqa - freqb;
        });

        return sorted;
    }
}