class TweetCounts {
    // tweetName -> (time -> count of tweets at that time)
    private Map<String, TreeMap<Integer, Integer>> tweets;

    public TweetCounts() {
        tweets = new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        tweets.computeIfAbsent(tweetName, k -> new TreeMap<>())
              .merge(time, 1, Integer::sum);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName,
                                                    int startTime, int endTime) {
        int chunkSize = switch (freq) {
            case "minute" -> 60;
            case "hour"   -> 3600;
            default       -> 86400;   // "day"
        };

        // number of chunks: ceil((endTime - startTime + 1) / chunkSize)
        int numChunks = (endTime - startTime) / chunkSize + 1;
        int[] counts = new int[numChunks];

        TreeMap<Integer, Integer> times = tweets.get(tweetName);
        if (times != null) {
            // only iterate tweets within [startTime, endTime] (inclusive) via subMap
            for (var entry : times.subMap(startTime, true, endTime, true).entrySet()) {
                int t = entry.getKey(), cnt = entry.getValue();
                int chunkIdx = (t - startTime) / chunkSize;   // which chunk this time lands in
                counts[chunkIdx] += cnt;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int c : counts) result.add(c);
        return result;
    }
}