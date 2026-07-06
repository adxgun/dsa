class TopVotedCandidate {

    private int[] leaders;
    private int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;

        int n = persons.length, leaderVotes = 0, leader = -1;
        Map<Integer, Integer> voteCount = new HashMap<>();
        this.leaders = new int[n];


        for (int i = 0; i < n; i++) {
            int votes = voteCount.merge(persons[i], 1, Integer::sum);

            if (votes >= leaderVotes) {
                leaderVotes = votes;
                leader = persons[i];
            }

            leaders[i] = leader;
        }
    }
    
    public int q(int t) {
        int idx = upperBound(times, t) - 1;
        return this.leaders[idx];
    }

    private int upperBound(int[] times, int t) {
        int lo = 0, hi = times.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (times[mid] <= t) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */